import java.util. *;
public class Gauss{
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
        // SATU UTAMA SUDAH TERBENTUK

        // Switching posisi jika diperlukan
        // End Switching Posisi

        // MULAI MELAKUKAN ALGORITMA MATTHEW

        // Bagian Pengurangan Baris
        // Definisi algoritma seperti yg sudah dibahas oleh Kelompok
        // Langkah 1) Bn - B(n-1); 2) Bn * 1/Elm pertama Bn yang bukan 0; n adalah baris
        
        // Harus diperhatikan jika sudah terbentuk satu utama, maka tidak perlu lagi melakukan
        // pengurangan baris. Algoritma di bawah ini masih salah
        /*
        for (i = 1; i<m; i++){
            for (k = 1; k <= i; k++){
                for (j = 0; j < n ; j++){
                    matriks[i][j] -= matriks[i-k][j];
                    //ambil elemen pertama pada baris yang bukan 0
                    zero = true; l= 0; simpan=1;
                    while (l < n && zero == true){
                        if (matriks[i][l] != 0){
                            simpan = matriks[i][l];
                            zero = false;
                        }
                        l++;
                    }

                    rasio = 1 / simpan;
                    matriks[i][j] *= rasio;
                }
            }
        }
        */
        // Pengurangan Baris Selesai

        // ALGORITMA MATTHEW SELESAI

        //test cetak
        for (i = 0; i < m; i++){
            for (j = 0; j < n; j++){
                System.out.print(matriks[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        MetodeGauss();
    }
}