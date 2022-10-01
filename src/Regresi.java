import java.util.Scanner;

class Regresi{
    public static void main(String[] args){
        Matriks matriks = new Matriks();
        Scanner scan = new Scanner(System.in);
        System.out.println("Masukkan jumlah peubah x (n): "); //col
        int n = scan.nextInt();
        int o = n+1; //banyaknya kolom ditambah Y
        System.out.println("Masukkan jumlah sampel (m): ");//row
        int m = scan.nextInt();

        double[][] matrix = matriks.makeMatrix(m,o);
        System.out.println("Masukkan data variabel dari X[1],X[2],..,X[n],Y");
        matriks.inputMatriks(matrix,m,o);
        int i,j,k,l;
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
            for(l=0;l<n-1;l++){
                for(k=0;k<m;k++){
                hasilY[i][0] += matrix[k][o-1] * matrix[k][i-1];
                }
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

        matriks.printMatriks(hasil,o,o+1);
        System.out.print("\n");



         System.out.print("\n");
         matriks.GaussJordan(hasil,o,o+1);
         matriks.printMatriks(hasil,o,o+1);

         System.out.println("persamaan regresi dari masukan diatas adalah: ");

         System.out.print("y = ");
         j=o;
         for(i=0;i<o;i++){
            if(i==0){
                System.out.print(hasil[i][j]);
            }
            else{
                if(hasil[i][j]<0){
                    System.out.print(" - " + hasil[i][j]*(-1) + "X[" + i +"] ");
                }
                else{
                    System.out.print(" + " + hasil[i][j] + "X[" + i +"] ");
                }
            }
         }

    }
}

