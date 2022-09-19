import java.util. *;
public class Gauss{
    static void MetodeGauss(){

        // INPUT MATRIKS DULU
        Scanner in = new Scanner(System.in);
        int m,n,i,j,k;
        double rasio, rasio1, simpan;
        //input m
        System.out.print("Masukkan ukuran baris matriks (m): ");
        m = in.nextInt();

        //input n
        System.out.print("Masukkan ukuran kolom matriks (n): ");
        n = in.nextInt();

        //membuat matriks ukuran m x n
        double[][] matriks = new double[m][n]; // matriks ukuran m baris n kolom sudah terinisialisasi

        //prosedur memasukkan elemen ke matriks
        // memasukkan elemen harus dalam satu baris yang dipisahkan oleh satu buah spasi
        // contoh : 1 2 3
        for (i = 0; i < m; i++){
            for (j = 0; j < n; j++){
                matriks[i][j] = in.nextInt();
            }
        }


        // MULAI 
        rasio = 1 /  matriks[0][0]; // dipikirkan untuk 1/0
        for (i = 0; i < m ; i++){
            for (j = 0; j < n; j++){
                for (k = 0; k <= i; k++){
                    if (i == 0 && k == 0){ // untuk baris pertama saja
                        matriks[i][j] *= rasio;
                    }else{ // baris kedua dan selanjutnya
                        simpan = matriks[i][0];
                        if (k == 0){
                            matriks[i][j] = matriks[i][j] - simpan * matriks[0][j]; // matriks[0][j] musti diganti biar bisa ganti baris sampai baris skrg -1
                        }else{
                            if (matriks[i][i] != 0){ // harus dipikirkan kalo 1/0; solusinya musti switch sih ato ya dikorbankan :)
                                rasio1 = 1 / matriks[i][i];
                                matriks[i][j] *= rasio1;
                            }
                        }
                    }
                }
            }
        }


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