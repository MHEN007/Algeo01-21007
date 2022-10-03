import java.util.Scanner;
import java.util.ArrayList;
import java.io. *;

class Regresi{
    Regresi(){}
    int i,j,k,l;
    int n,o,m;
    double[][] matrix;
    double[][] xk;
    
    String regresi(){
        Matriks matriks = new Matriks();
        Scanner scan = new Scanner(System.in);

        System.out.println("==========================");
        System.out.println("Pilih Metode Input Matriks");
        System.out.println("1. Input melalui Keyboard");
        System.out.println("2. Input melalui File");
        int pil = scan.nextInt();

        switch (pil){
            case 1:
                System.out.println("Masukkan jumlah peubah x (n): "); //col
                this.n = scan.nextInt();
                this.o = n+1; //banyaknya kolom ditambah Y
                System.out.println("Masukkan jumlah sampel (m): ");//row
                this.m = scan.nextInt();

                // memasukkan nilai taksiran
                this.xk = matriks.makeMatrix(n,1);
                for (i = 0; i < n; i++){
                    System.out.print("Masukkan nilai taksiran xk"+(i+1)+" ");
                    xk[i][0] = scan.nextDouble(); 
                }
                this.matrix = matriks.makeMatrix(m,o);
                System.out.println("Masukkan data variabel dari x1, x2, .., xn, dan y");
                matriks.inputMatriks(matrix,m,o);
                break;
            case 2:
                try{
                    int countRow = 0;
                    int countCol = 1;
                    String line = "";
                    System.out.print("Masukkan nama file: ");
                    String filename = scan.next();

                    File file = new File("../test/"+filename);
                    Scanner sc = new Scanner(file);        

                    ArrayList<ArrayList<Double>> tempmatrix = new ArrayList<ArrayList<Double>>();
                    ArrayList<Double> tempxk = new ArrayList<Double>();

                    i = 0;
                    while(sc.hasNextLine()){
                        countRow++;
                        line = sc.nextLine();
                        Scanner sc1 = new Scanner(line);
                        tempmatrix.add(new ArrayList<Double>());
                        while(sc1.hasNextDouble()){
                            tempmatrix.get(i).add(sc1.nextDouble());
                        }
                        i++;
                    }

                    // ambil xk di baris paling bawah
                    for (j = 0; j < tempmatrix.get(tempmatrix.size()-1).size(); j++){
                        tempxk.add(tempmatrix.get(tempmatrix.size()-1).get(j));
                    }
                    tempmatrix.remove(tempmatrix.size()-1);

                    // for (i = 0; i < tempxk.size(); i++){
                    //     System.out.print(tempxk.get(i) + " ");
                    // }

                    // masukkan ke matrix
                    this.matrix = new double[tempmatrix.size()][tempmatrix.get(0).size()];
                    for (i = 0; i < tempmatrix.size(); i++){
                        for (j = 0; j < tempmatrix.get(0).size();j++){
                            this.matrix[i][j] = tempmatrix.get(i).get(j);
                        }
                    }

                    // masukkan ke xk
                    this.xk = new double[tempxk.size()][1];
                    for (i  = 0; i < tempxk.size(); i++){
                        this.xk[i][0] = tempxk.get(i);
                    }

                    this.n = tempmatrix.get(0).size()-1;
                    this.o = n+1;
                    this.m = tempmatrix.size();

                    //m.printMatriks(matriks, m.getRow(matriks), m.getCol(matriks));

                } catch (FileNotFoundException e){
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
                break;
        }
        
        
        double[][] hasilX = matriks.makeMatrix(o,o);
        double[][] hasilY = matriks.makeMatrix(o,1);
        double[][] hasil = matriks.makeMatrix(o,o+1);

        //isi kolom pertama dengan jumlah baris
        hasilX[0][0] = m;

        //isi baris pertama dengan sum peubah
        for(j=1;j<=n;j++){ //sepanjang peubah
            for(k=0;k<m;k++){
                hasilX[0][j] = hasilX[0][j] + matrix[k][j-1];
            }
        }


        //isi kolom pertama dengan sum peubah
        for(i=1;i<=n;i++){
            for(k=0;k<m;k++){
                hasilX[i][0] = hasilX[i][0] + matrix[k][i-1];
            }
        }

        //isi baris dan kolom sisanya
        for(i=1;i<=n;i++){
            for(j=1;j<=n;j++){
                for(k=0;k<m;k++){
                hasilX[i][j] = hasilX[i][j] + (matrix[k][i-1]*matrix[k][j-1]);
                }
            }
        }
        
        //isi baris untuk kolom Y
        j=(o-1); //indeks Y berada di kolom terkahir
        for (i=0;i<=m-1;i++){
            hasilY[0][0] += matrix[i][n];
        }
        //matriks.printMatriks(hasilY,o,1);

        //isi baris untuk kolom YX[1],..,YX[n]
        for(i=1;i<o;i++){
            for(k=0;k<m;k++){
                hasilY[i][0] += matrix[k][o-1] * matrix[k][i-1];
            }
        }

        //gabung hasilX dan hasilY untuk gauss
        for(i=0;i<=n;i++){
            for(j=0;j<=n;j++){
                hasil[i][j] = hasilX[i][j];
            }
        }

        j=o; //indeks terakhir
        for(i=0;i<=n;i++){
            hasil[i][j] = hasilY[i][0];
        }

        //matriks.printMatriks(hasil,o,o+1);
        //System.out.print("\n");



         //System.out.print("\n");
         matriks.GaussJordan(hasil,o,o+1);
         //matriks.printMatriks(hasil,o,o+1);

         String output = "";

         System.out.println("Persamaan regresi dari masukan diatas adalah: ");

         System.out.print("f(x) = ");
         output += "f(x) = ";
         j=o;
         for(i=0;i<o;i++){
            if(i==0){
                System.out.print(hasil[i][j]);
                output += hasil[i][j];
            }
            else{
                if(hasil[i][j]<0){
                    System.out.print(" - " + hasil[i][j]*(-1) + "x" + i +" ");
                    output += " - " + hasil[i][j]*(-1) + "x" + i +" ";
                }
                else{
                    System.out.print(" + " + hasil[i][j] + "x" + i +"");
                    output += " + " + hasil[i][j] + "x" + i +" ";
                }
            }
         }
        output += "\n";
        System.out.println();

        // menghitung nilai taksiran
        double sum = 0;
        for (i = 0; i < o; i++){
            if (i == 0){
                sum += hasil[i][j];
            }else{
                sum += hasil[i][j] * xk[i-1][0];
            }
        }

        output += "f(xk) =  " + sum;

        System.out.println("Nilai regresinya adalah:");
        System.out.println("f(xk) =  " + sum);
        return output;
    }
}
