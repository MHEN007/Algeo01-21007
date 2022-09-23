import java.util. *;
/* I.S. Matriks yang diterima merupakan matriks yang sudah mengalami transformasi Gauss 
   F.S. Terbentuk Matriks eselon baris tereduksi */

public class GaussJordan{
    static void printMatriks(double[][] matriks, int m, int n){
        int i,j;
        for (i = 0; i < m; i++){
            for (j = 0; j < n; j++){
                System.out.print(matriks[i][j]+" ");
            }
            System.out.println();
        }
    }

    static double[][] CopyMatriks(double[][] matriks, int m, int n){
        double[][] copyMatriks = new double[m][n];
        int i,j;
        for (i = 0; i < m; i++){
            for (j = 0; j < n; j++){
                copyMatriks[i][j] = matriks[i][j];
            }
        }
        return copyMatriks;
    }

    public static void main(String[] args){
        // disini harus ada proses eliminasi gauss terlebih dahulu
        // return berupa matriksGauss tipe double
        //double matriksGauss[][] = {{1,-0.3333333,0.3333333},{0,1,-0.14285714},{0,0,1}}; // contoh dari matriks hasil transformasi gauss
        double matriksGauss[][] = {{1, 2.65, 0.6},{0,1,-0.054},{0,0,1}};
        double copyMatriks[][] = CopyMatriks(matriksGauss,3,3);
        printMatriks(matriksGauss,3,3);
        int i,j,k;
        double simpan;
        boolean one;
        /*
        Algoritma di bawah ini mengecek elemen TEPAT di atas bilangan 1 mulai dari baris 2. Lalu dilakukan pengurangan
        Algoritma masih salah. Belum sempurna.
        */
        for (i = 1; i<3; i++){
            simpan = 1;
            one = true;
            for (j = 0; j < 3; j++){
                // ambil elemen pertama yang sudah pasti 1 pada tiap baris
                if (matriksGauss[i][j] == 1 && one == true){
                    for (k = 1; k <= i; k++){
                        simpan = matriksGauss[i-k][j]; // ambil elemen atasnya

                        one = false;

                        matriksGauss[i-k][j] -= simpan * matriksGauss[i][j];
                    }
                }
            }
        }
        printMatriks(matriksGauss,3,3);
    }
}