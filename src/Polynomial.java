import java.util. *;
import java.io. *;

public class Polynomial {
    Polynomial(){}

    Matriks matriks = new Matriks();
    Scanner in = new Scanner(System.in);
    ReadFile r = new ReadFile();
    int m;
    double[][] matrix;
    double a;

    String polynomial(){
        System.out.println("==========================");
        System.out.println("Pilih Metode Input Matriks");
        System.out.println("1. Input melalui Keyboard");
        System.out.println("2. Input melalui File");
        int pil = in.nextInt();

        //INPUT MATRIKS
        switch(pil){
            case 1:
                this.m = matriks.inputRowPolynomial();
                this.matrix = matriks.makeMatrix(m,2);
                matriks.inputMatriks(matrix,m,2);
                this.a = matriks.inputEstimatePolynomial();
                break;
            case 2:
                try{
                    int countRow = 0;
                    int countCol = 1;
                    String line = "";
                    System.out.print("Masukkan nama file: ");
                    Scanner scan = new Scanner(System.in);
                    String filename = scan.next();

                    File file = new File("../test/"+filename);
                    Scanner sc = new Scanner(file);        

                    ArrayList<ArrayList<Double>> tempmatrix = new ArrayList<ArrayList<Double>>();
                    ArrayList<Double> tempxk = new ArrayList<Double>();

                    int i = 0;
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
                    for (int j = 0; j < tempmatrix.get(tempmatrix.size()-1).size(); j++){
                        tempxk.add(tempmatrix.get(tempmatrix.size()-1).get(j));
                    }
                    tempmatrix.remove(tempmatrix.size()-1);

                    // for (i = 0; i < tempxk.size(); i++){
                    //     System.out.print(tempxk.get(i) + " ");
                    // }

                    // masukkan ke matrix
                    this.matrix = new double[tempmatrix.size()][tempmatrix.get(0).size()];
                    for (i = 0; i < tempmatrix.size(); i++){
                        for (int j = 0; j < tempmatrix.get(0).size();j++){
                            this.matrix[i][j] = tempmatrix.get(i).get(j);
                        }
                    }

                    // masukkan ke xk
                    this.a = tempxk.get(0);

                    this.m = tempmatrix.size();

                    //m.printMatriks(matriks, m.getRow(matriks), m.getCol(matriks));

                } catch (FileNotFoundException e){
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
                break;
        }

        // Contoh Input: 
        // 2 2
        // 3 3

        // Dari input kemudian yang kolom 0 mau dibikin jadi Ax
        // Yang kolom ke 1 jadi B

        // Contohnya:
        // 2^0x1 + 2^1x2 = 2
        // 3^0x1 + 3^1x2 = 3
        
        // Bentuk matriksnya jadi:
        // 1 2 2
        // 1 3 3

        int o = m + 1;

        double[][] ubahMatrix = matriks.makeMatrix(m,o);
        int i;
        for (i = 0; i < m; i++){
            int j;
            for (j = 0; j < o; j++){
                ubahMatrix[i][j] = Math.pow(matrix[i][0],j); /* Loop untuk pemangkatannya (Kondisi Ax) */
            }
        }
            
        for (i = 0; i < m; i++) {
            ubahMatrix[i][m] = matrix[i][1]; /* Loop untuk kondisi B */

        }
        // System.out.print("\n");
        // System.out.print("Matriks setelah diubah:\n");
        // matriks.printMatriks(ubahMatrix,m,o); /*Cetak matriks*/
        // System.out.print("\n");
        matriks.Gauss(ubahMatrix,m,o); /*Lakukan Gauss*/
        // System.out.print("Matriks setelah digauss:\n");
        // matriks.printMatriks(ubahMatrix,m,o); /*Cetak matriks*/
        // System.out.print("\n");

        int countZero = 0;
        for (int j = 0; j < o; j++){
            if(ubahMatrix[m-1][j] == 0){
                countZero++;
            }
        }
    
        double[] solusi = new double[o-1]; // jumlah variabel solusi adalah sejumlah kolomnya dikurangi 1
        
        // backward subs dimulai dari belakang
        for (i = m-1; i >= 0; i--){
            double sum = 0.0;
            for (int j = 0; j < o-1; j++){
                sum += ubahMatrix[i][j] * solusi[j];
            }
            solusi[i] = (ubahMatrix[i][o-1] - sum) / ubahMatrix[i][i];
        }

        // for (i = 0; i < o-1; i++){
        //     System.out.println("a"+(i+1)+" = "+solusi[i]);
        // }

        System.out.print("\n");
        double sumNilaiEstimasi = 0.0;

        for (i = 0 ; i < o-1; i++){
            sumNilaiEstimasi += (solusi[i] * Math.pow(a,i));
        }

        String output = "f(x) = ";
        
        for (i = 0; i < o-1; i++){
            output += "(" + solusi[i] + ")x^" + i;
            if (i != o-2){
                output += " + ";
            }else{
                output += "\n";
            }
        }

        output += "f(" + a + ") = " + sumNilaiEstimasi;
        
        System.out.println(output);
        return (output);
    }
}
