import java.util. *;
public class Gauss{
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

    static void swapbaris(Integer[][] matriks, int m, int n){
        int i,j;
        int temp=1;
        for (i = 0;i < m; i++){
            for (j = 0; j < n; j++){
                if (matriks[0][j]==0){  /* mengecek apakah angka 0 ada dalam baris sebelah kiri*/
                    for (i = 0;i < m; i++){
                        int newLine=matriks[temp][i];
                        matriks[temp][i]=matriks[0][i];
                        matriks[0][i]=newLine; 
                    }
                }
            }
        }
    }

    static void MetodeGauss(){
        // INPUT MATRIKS DULU
        Scanner in = new Scanner(System.in);
        int m,n,i,j,k,l;
        double rasio, rasio1, simpan;
        boolean zero;
        //input m
        System.out.print("Masukkan ukuran baris matriks (m): ");
        m = in.nextInt();

        //input n
        System.out.print("Masukkan ukuran kolom matriks (n): ");
        n = in.nextInt();

        //membuat matriks ukuran m x ns
        double[][] matriks = new double[m][n]; // matriks ukuran m baris n kolom sudah terinisialisasi

        //prosedur memasukkan elemen ke matriks
        // memasukkan elemen harus dalam satu baris yang dipisahkan oleh satu buah spasi
        // contoh : 1 2 3
        for (i = 0; i < m; i++){
            for (j = 0; j < n; j++){
                matriks[i][j] = in.nextInt();
            }
        } 

        // MULAI MEMBUAT SATU UTAMA
        // Membuat elemen pertama bukan 0 pada tiap baris menjadi 1
        for (i = 0; i < m; i++){
            j = 0;
            simpan = 1;
            zero = true;
            //ambil elemen pertama pada baris yang bukan 0
            while (j < n && zero == true){
                if (matriks[i][j] != 0){
                    simpan = matriks[i][j];
                    zero = false;
                }
                j++;
            }

            rasio = 1 / simpan;

            for (j = 0; j < n ; j++){
                matriks[i][j] *= rasio;
            }
        }
        
        // buat copy matrix
        double[][] copyMatriks = CopyMatriks(matriks, m,n);
        // copy matrix sudah terdefinisi
        
        System.out.print("Matriks sebelum diputar:\n");
        printMatriks(matriks, m, n);
        System.out.print("\n");

        int temp=1;
        for (i = 0;i < m; i++){
            for (j = 0; j < n; j++){
                if (matriks[0][0]==0){  /* mengecek apakah angka 0 ada dalam baris sebelah kiri*/
                    for (i = 0;i < m; i++){
                        Double newLine=matriks[temp][i];
                        matriks[temp][i]=matriks[0][i];
                        matriks[0][i]=newLine; 
                    }
                }
            }
        }

        System.out.print("Matriks setelah diputar:\n");
        printMatriks(matriks, m, n);
        System.out.print("\n");

        // Switching posisi jika diperlukan
        // Tolong dibuat. Switching terhadap copyMatriks dan matriks
        // End Switching Posisi

        // SATU UTAMA SUDAH TERBENTUK

        // MULAI MELAKUKAN ALGORITMA MATTHEW

        // Bagian Pengurangan Baris
        // Definisi algoritma seperti yg sudah dibahas oleh Kelompok
        // Langkah 1) Bn - B(n-1); 2) Bn * 1/Elm pertama Bn yang bukan 0; n adalah baris
        
        for (i = 1; i < m; i++){ // ulang untuk per baris
            for (k = 0; k < i; k++){ // ulang untuk k- kali
                simpan = 1;
                zero = true;
                for (j = 0; j < n ; j++){
                    matriks[i][j] -= copyMatriks[k][j]; // 1)

                    if (matriks[i][j] != 0 && zero == true){
                        simpan = matriks[i][j];
                        zero = false;
                    }

                    matriks[i][j] *= 1 / simpan;

                    copyMatriks[i][j] = matriks[i][j]; // copy hasil yang sudah dikurangi ke dalam copy matriks
                }
            }
        }
        
        // Pengurangan Baris Selesai

        // ALGORITMA MATTHEW SELESAI

        //test cetak
        printMatriks(matriks, m, n);
    }

    public static void main(String[] args){
        MetodeGauss();
    }
}