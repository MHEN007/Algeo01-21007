import java.util. *;

class Matriks{
    /* 
    BERISI PRIMITIF-PRIMITIF DARI MATRIKS
    - INPUT DAN OUTPUT MATRIKS
    - COPY MATRIKS
    - SWAP BARIS
    */
    
    /* KAMUS LOKAL */
    int i,j,m,n;
    double[][] matriks;

    /* KONSTRUKTOR MATRIKS */
    Matriks(){}

    /* PRIMITIF INPUT MATRIKS */
    int inputRow(){ // memasukkan baris dari matriks
        Scanner in = new Scanner (System.in);
        System.out.print("Masukkan baris (m): ");
        m = in.nextInt();
        this.m = m;
        return m;
    }

    int inputCol(){ // memasukkan kolom dari matriks
        Scanner in = new Scanner (System.in);
        System.out.print("Masukkan kolom (n): ");
        n = in.nextInt();
        this.n = n;
        return n;
    }


    double[][] makeMatrix(int m, int n){ // membuat matriks sembarang dan mengembalikannya
        double[][] matriks = new double[m][n];
        this.matriks = matriks;
        return matriks;
    }

    void inputMatriks (double[][] matriks, int m, int n){ // memasukkan nilai-nilai matriks
        Scanner in = new Scanner (System.in); 
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                matriks[i][j] = in.nextInt();
            }
        }
    }
    
    /* PRIMITIF OUTPUT MATRIKS */

    void printMatriks(double[][] matriks, int m, int n){ // mencetak matriks matriks
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                System.out.print(matriks[i][j] + " ");
            }
            System.out.println();
        }
    }

    /* PRIMITIF COPY MATRIKS */
    double[][] copyMatriks(double[][] matriks, int m, int n){ // membuat copy dari matriks masukkan
        double[][] copymatriks = new double[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n ; j++){
                copymatriks[i][j] = matriks[i][j];
            }
        }
        return copymatriks;
    }

    /* OPERASI-OPERASI MATRIKS */
    double[][] makeIdentitas (int m, int n){
        // membuat matriks identitas dg ukuran m x n
        double[][] identitas = makeMatrix(m,n);
        for (int i = 0 ; i < m; i++){
            for (int j = 0; j < n; j++){
                if ( i == j){
                    identitas[i][j] = 1;
                }else{
                    identitas[i][j] = 0;
                }
            }
        }
        return identitas;
    }

    boolean checkIdentitas(double[][] identitas, int m, int n){
        boolean isIdentitas = true;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n ; j++){
                if (i == j){
                    if (identitas[i][j] != 1){
                        isIdentitas = false;
                    }
                }else{
                    if (identitas[i][j] != 0){
                        isIdentitas = false;
                    }
                }
            }
        }
        return isIdentitas;
    }

    double[][] swapBaris(double[][] matriks, int i, int j){ // fungsi swap baris
        double temp;
        int numColumns = matriks[0].length;
        for (int k = 0; k < numColumns; k++){
            temp = matriks[i][k];
            matriks[i][k] = matriks[j][k];
            matriks[j][k] = temp;
        }
        this.matriks = matriks;
        return matriks;
        
    }

    void Gauss(double[][] matriks, int m, int n){
        // Melakukan elminasi Gauss pada matriks inputan
        /* KAMUS LOKAL */
        int i,j,k,l;
        double rasio, rasio1, simpan;
        boolean zero;

        /* ALGORITMA */
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

        // Swap Baris
        int var = 0; 
        int jumlahBaris = matriks.length; //menghitung panjang baris matriks
        int jumlahKolom = matriks[0].length; //menghitung panjang kolom matriks

        for(k = 0; k < jumlahBaris; k++){
            if (jumlahBaris <= var){  //panjang baris kurang dari 0
                break;
            }
            i = k;
            while(matriks[i][var] == 0){ //kondisi pengecekan kolom apakah ada 0 atau tidak
                i++;
                if(jumlahBaris == i){ 
                    i = k;
                    var++;
                    if(jumlahKolom == var){ //ketika jumlah kolom semua sudah dicek
                        break;
                    }
                }

            }
            matriks = swapBaris(matriks, i, k); //menukar baris pada matriks
        }

        // buat copy matrix
        double[][] copyMatriks = copyMatriks(matriks, m,n);
        // copy matrix sudah terdefinisi
        
        System.out.print("Matriks setelah diswitch:\n");
        printMatriks(matriks, m, n);
        System.out.print("\n");

        // SATU UTAMA SUDAH TERBENTUK

        // MULAI MELAKUKAN ALGORITMA MATTHEW

        // Bagian Pengurangan Baris
        // Definisi algoritma seperti yg sudah dibahas oleh Kelompok
        // Langkah 1) Bn - B(n-1); 2) Bn * 1/Elm pertama Bn yang bukan 0; n adalah baris
        
        for (i = 1; i < m; i++){ // ulang untuk per baris
            // jika baris sudah memenuhi syarat utama maka tidak perlu melakukan OBE
            int countSatuUtama = 0;
            j = 0;
            while(j <= i-1){
                if (matriks[i][j] == 0){
                    countSatuUtama++;
                }
                j++;
            }

            if(countSatuUtama <= i-1){ // belum satu utama lakukan OBE
                for (k = 0; k < i; k++){ // ulang untuk k- kali
                    simpan = 1;
                    zero = true;
                    for (j = 0; j < n ; j++){
                        if (matriks[i][j] != 0){
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
            }
            
        }
        
        // Pengurangan Baris Selesai

        // ALGORITMA MATTHEW SELESAI
        this.matriks = matriks;
    }

    void GaussJordan(double[][] matriks, int m, int n){
        // melakukan eliminasi gauss-jordan

        /* KAMUS LOKAL */
        int i,j,k,l;
        double simpan;
        boolean one;

        /* ALGORITMA */
        //Melalui eliminasi gauss terlebih dahulu
        Gauss(matriks,m,n);
        
        //Mulai eliminasi Gauss-Jordan
        for (i = 1; i<m; i++){
            simpan = 1;
            one = true;
            for (j = 0; j < n; j++){
                // ambil elemen pertama yang sudah pasti 1 pada tiap baris
                if (matriks[i][j] == 1 && one == true){
                    for (k = 1; k <= i; k++){
                        simpan = matriks[i-k][j]; // ambil elemen atasnya
                        one = false;
                        // harus loop di kolomnya
                        for (l = 0; l<n; l++){
                            matriks[i-k][l] -= simpan * matriks[i][l];
                        }
                    }
                }
            }
        }
        this.matriks = matriks;
    }

    double Determinan(double[][] matriks, int m, int n){
        // mencari determinan dengan menggunakan reduksi baris
        /* KAMUS LOKAL */
        int i,j,k,l;
        double rasio, rasio1, simpan;
        boolean zero;
        double pembilang = 1;
        double penyebut = 1;
        int p = 0; //jumlah switch yang terjadi
        
        /* ALGORITMA */
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
                    penyebut *= 1/simpan;
                    zero = false;
                }
                j++;
            }

            rasio = 1 / simpan;

            for (j = 0; j < n ; j++){
                matriks[i][j] *= rasio;
            }
        }

        // Swap Baris
        int var = 0; 
        int jumlahBaris = matriks.length; //menghitung panjang baris matriks
        int jumlahKolom = matriks[0].length; //menghitung panjang kolom matriks

        for(k = 0; k < jumlahBaris; k++){
            if (jumlahBaris <= var){  //panjang baris kurang dari 0
                break;
            }
            i = k;
            while(matriks[i][var] == 0){ //kondisi pengecekan kolom apakah ada 0 atau tidak
                i++;
                if(jumlahBaris == i){ 
                    i = k;
                    var++;
                    if(jumlahKolom == var){ //ketika jumlah kolom semua sudah dicek
                        break;
                    }
                }

            }
            matriks = swapBaris(matriks, i, k); //menukar baris pada matriks
            p++;
        }

        // buat copy matrix
        double[][] copyMatriks = copyMatriks(matriks, m,n);
        // copy matrix sudah terdefinisi

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
                penyebut *= 1/simpan;
            }
        }
        
        // Pengurangan Baris Selesai

        // ALGORITMA MATTHEW SELESAI

        for (i = 0; i < m; i++){
            for (j = 0; j < n; j++){
                if (i == j){
                    pembilang *= matriks[i][j];
                }
            }
        }

        return (Math.pow(-1,p) * pembilang/penyebut);
    }

    void SarrusCrammer(double[][] matriks, int m, int n){
        /* Melakukan proses sarrus-crammer untuk mendapatkan hasil dari 
        sebuah SPL */

        /* KAMUS LOKAL */
        double[][] copy = copyMatriks(matriks,m,n);
        double[][] matA = copyMatriks(matriks, m, n-1); // ukuran barisnya selalu kurang dari 1
        double[][] matB = copyMatriks(matriks, m, 1); // hanya m baris x 1 kolom. diisi elemen paling ujung
        double det; // determinan dasar
        double detx; // determinan berikutnya


        /* ALGORITMA */
        //hitung determinan awalnya
        det = Determinan(copy,m,n);

        //isi matriks A
        for(int i = 0; i < m; i++){
            for (int j = 0; j < n-1; j++){
                matA[i][j] = matriks[i][j];
            }
        }

        //isi matriks B
        for(i = 0; i < m; i++){
            matB[i][0] = matriks[i][n-1];
        }
        
        //proses tukar tempat dan cari nilai x1..xN
        //dilakukan dalam suatu loop selama N kali dengan N maks adalah jumlah baris-1
        for (i = 0; i < n-1; i++){
            for (j = 0; j < m; j++){
                matA[j][i] = matB[j][0]; // menukar kolom ke N dengan matriks B
            }
            detx = Determinan(matA, matA.length, matA[0].length); // menghitung determinan dari matriks A
            System.out.println("Nilai x"+(i+1)+" adalah "+(detx/det));
            matA = copyMatriks(matriks, m, n-1); // mengembalikan matriks A ke awal
        }
    }

    double DeterminanKof(double[][] matrix,int m,int n){
        //menghitung determinan dengan melakukan ekspansi kofaktor
        // melakukan rekursi
        /* KAMUS LOKAL */
        int sign = 1;
        double det = 0;
        if (m == 1 && n ==1){ // basis rekursi
            return (matrix[0][0]);
        }else{
            for (int i = 0; i < m; i++){
                double[][] kofaktor = new double[m-1][n-1];
                int row1,col1;
                int k,l;
                row1 = 0;
                for (k = 0; k < m; k++){
                    col1 = 0;
                    for (l = 0; l < n; l++){
                        if (l != i && k != 0){
                            kofaktor[row1][col1] = matrix[k][l];
                            col1 += 1;
                            if (col1 == n-1){
                                col1 = 0;
                                row1 += 1;
                            }
                        }
                    }
                }
                det += (sign * matrix[0][i] * DeterminanKof(kofaktor,kofaktor.length,kofaktor[0].length));
                sign *= -1;
            }
        }
        return det;
    }
}