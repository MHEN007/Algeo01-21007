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
        double matriksGauss[][] = {{1,1.6666666666666665,2.0,1.6666666666666665},{0,1,1.75,0.5},{0,0,1,0.281967213114754}};
        int m = matriksGauss.length; // baris
        int n = matriksGauss[0].length; // kolom
        double copyMatriks[][] = CopyMatriks(matriksGauss,m,n);
        printMatriks(matriksGauss,m,n);
        int i,j,k,l;
        double simpan;
        boolean one;

        for (i = 1; i<m; i++){
            simpan = 1;
            one = true;
            for (j = 0; j < n; j++){
                // ambil elemen pertama yang sudah pasti 1 pada tiap baris
                if (matriksGauss[i][j] == 1 && one == true){
                    for (k = 1; k <= i; k++){
                        simpan = matriksGauss[i-k][j]; // ambil elemen atasnya
                        one = false;
                        // harus loop di kolomnya
                        for (l = 0; l<n; l++){
                            matriksGauss[i-k][l] -= simpan * matriksGauss[i][l];
                        }
                    }
                }
            }
        }
        printMatriks(matriksGauss,m,n);
    }
}