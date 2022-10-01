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
    
    int inputRowPolynomial(){ // memasukkan jumlah koordinat untuk interpolasi polinom
        Scanner in = new Scanner (System.in);
        System.out.print("Masukkan jumlah koordinat: ");
        m = in.nextInt();
        this.m = m;
        return m;
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
                matriks[i][j] = in.nextDouble();
            }
        }
    }
    
    /* SELEKTOR */
    int getRow(double[][] matriks){
        // ambil baris
        return (matriks.length);
    }

    int getCol(double[][] matriks){
        // ambil kolom
        return (matriks[0].length);
    }
    
    boolean isSquare (double[][] matriks){ 
        //menentukan apakah sebuah matriks memiliki row dan col yang sama atau tidak
        return (getRow(matriks) == getCol(matriks));
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

    void swapBaris(int i1, int i2){ // fungsi swap baris
        for (int i = 0; i < n; i++) {
            double temp = matriks[i1][i];
            matriks[i1][i] = matriks[i2][i];
            matriks[i2][i] = temp;
        }
    }

    int cariIndex(int idx){
        boolean found = false;
        int i = 0;
        while (!(found) && (i<n)){
            if (matriks[idx][i] != 0){
                found = true;
            }
            else{
                i++;
            }
        }
        if (found==true){
            return i;
        }
        else{
            return n;
        }
    }

    int sortingMatrix(){
        int i,j;
        int p = 0;
        if (m > 1){
            for (i = 0; i < m; i++){
                int rowMax = i;
                for (j = i + 1; j < m; j++){
                    int foundIndexLead = cariIndex(j);
                    if (foundIndexLead < cariIndex(rowMax)){
                        rowMax=j;
                        p += 1;
                    }
                }
            swapBaris(i, rowMax);
            }
        }
        //System.out.print("Berapa kali switch? "+p+"\n");
        return p;
    }

    double[][] perkalian(double[][] matA, double[][] matB){
        // melakukan perkalian matriks
        double[][] hasil = makeMatrix(matA.length, matB[0].length);

        for (int i = 0; i < matA.length; i++){
            for (int j = 0; j < matB[0].length; j++){
                hasil[i][j] = 0;
                for (int k = 0; k < matB.length; k++){
                    hasil[i][j] += matA[i][k] * matB[k][j];
                }
            }
        }

        return hasil;
    }

    double[][] makeMinor (double[][] matriks, int m, int n, int b, int k){
        // menerima input matriks dan mengeluarkan minor dari indeks baris b dan kolom k
        double[][] kof = new double[m-1][n-1]; // membuat matriks kofaktor
        int bkof = 0; // baris dari matriks kofaktor
        for (int i = 0; i < m; i++){
            int kkof = 0; // kolom dari matriks kofaktor
            for (int j = 0; j < n; j++){
                if (i != b && j != k){
                    kof[bkof][kkof] = matriks[i][j];
                    kkof++;
                    if(kkof == n-1){
                        kkof = 0;
                        bkof++;
                    }
                }
            }
        }
        return kof;
    }

    /* SISTEM PERSAMAAN LINEAR */

    void Gauss(double[][] matriks, int m, int n){
        // Melakukan elminasi Gauss pada matriks inputan
        /* KAMUS LOKAL */
        int i,j,k,l;
        double rasio,simpan;
        boolean zero;

        sortingMatrix();

        /* ALGORITMA */
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

            //rasio = 1 / simpan;

            for (j = 0; j < n ; j++){
                matriks[i][j] /= simpan;
            }
        }
        // printMatriks(matriks, getRow(matriks), getCol(matriks));

        // buat copy matrix
        //double[][] copyMatriks = copyMatriks(matriks, m,n);
        // copy matrix sudah terdefinisi

        for (i = 1; i < m; i++){ // ulang untuk per baris
            for (k = 0; k < i; k++){ // ulang untuk k- kali
                rasio = 0;
                zero = true;
                for (j = 0; j < n ; j++){
                    if (matriks[k][j] != 0 && zero == true){
                        rasio = matriks[i][j]/matriks[k][j];
                        zero = false;
                    }
                    matriks[i][j] -= rasio * matriks[k][j]; // 1)

                    // if (matriks[i][j] != 0 && zero == true){
                    //     simpan = matriks[i][j];
                    //     zero = false;
                    // }

                    //matriks[i][j] *= 1 / simpan;

                    //copyMatriks[i][j] = matriks[i][j]; // copy hasil yang sudah dikurangi ke dalam copy matriks
                }
            }
        }

        // ALGORITMA MATTHEW SELESAI
        this.matriks = matriks;
    }

    void GaussJordan(double[][] matriks, int m, int n){
        // melakukan eliminasi gauss-jordan

        /* KAMUS LOKAL */
        int i,j,k,l;
        double simpan, rasio;
        boolean one;

        /* ALGORITMA */
        //Melalui eliminasi gauss terlebih dahulu
        Gauss(matriks,m,n);

        // Membuat elemen pertama bukan 0 pada tiap baris menjadi 1
        for (i = 0; i < m; i++){
            j = 0;
            simpan = 1;
            boolean zero = true;
            //ambil elemen pertama pada baris yang bukan 0
            while (j < n && zero == true){
                if (matriks[i][j] != 0){
                    simpan = matriks[i][j];
                    zero = false;
                }
                j++;
            }

            //rasio = 1 / simpan;

            for (j = 0; j < n ; j++){
                matriks[i][j] /= simpan;
            }
        }
        
        //Mulai eliminasi Gauss-Jordan
        for (i = 1; i < m; i++){
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

    String[] SPLInvers(double[][] matriks, int m, int n){
        double[][] matA = makeMatrix(m, n-1);
        double[][] matB = makeMatrix(m, 1);

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

        double[][] copyMatA = copyMatriks(matA, m, n-1);

        if(DeterminanKof(copyMatA,m,n-1) == 0){
            String[] solusi = new String[1];
            solusi[0] = "SPL ini tidak ada solusinya";
            return solusi;
        }else{
            // buat invers matA
            double[][] invMatA = InversAdj(matA,getRow(matA),getCol(matA));

            // hasil nya

            double[][] x = perkalian(invMatA, matB);

            String[] solusi = new String[getRow(x)];
            
            for (int l = 0; l <getRow(x); l++){
                solusi[l] = "x"+(l+1)+" = "+x[l][0];
            }

            return solusi;
        }
    }

    double Determinan(double[][] matriks, int m, int n){
        // mencari determinan dengan menggunakan reduksi baris
        /* KAMUS LOKAL */
        int i,j,k,l;
        double rasio, rasio1, simpan;
        boolean zero;
        int det = 1;
        double pembilang = 1;
        double penyebut = 1;
        
        int p = sortingMatrix();
        
        /* ALGORITMA */
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

            //rasio = 1 / simpan;

            for (j = 0; j < n ; j++){
                matriks[i][j] /= simpan;
            }
        }

        for (i = 1; i < m; i++){ // ulang untuk per baris
            for (k = 0; k < i; k++){ // ulang untuk k- kali
                rasio = 0;
                zero = true;
                for (j = 0; j < n ; j++){
                    if (matriks[k][j] != 0 && zero == true){
                        rasio = matriks[i][j]/matriks[k][j];
                        zero = false;
                    }
                    matriks[i][j] -= rasio * matriks[k][j]; // 1)
                }
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
        //printMatriks(matriks, getRow(matriks), getCol(matriks));

        return (Math.pow(-1,p) * pembilang/penyebut);
    }

    String[] SarrusCrammer(double[][] matriks, int m, int n){
        /* Melakukan proses sarrus-crammer untuk mendapatkan hasil dari 
        sebuah SPL */

        /* KAMUS LOKAL */
        double[][] copy = copyMatriks(matriks,m,n-1);
        double[][] matA = makeMatrix(m,n-1); // ukuran barisnya selalu kurang dari 1
        double[][] matB = makeMatrix(m,1); // hanya m baris x 1 kolom. diisi elemen paling ujung
        double det; // determinan dasar
        double detx; // determinan berikutnya
        String[] solusi = new String[n-1];


        /* ALGORITMA */
        //hitung determinan awalnya
        det = DeterminanKof(copy,getRow(copy), getCol(copy));
        if(det == 0){
            System.out.println("SPL ini tidak ada solusinya");
            solusi[0] = "SPL ini tidak ada solusinya";
            return solusi;
        }else{
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
                detx = DeterminanKof(matA, getRow(matA), getCol(matA)); // menghitung determinan dari matriks A
                System.out.println("x"+(i+1)+" = "+(detx/det));
                solusi[i] = "x"+(i+1)+" = "+(detx/det);
                matA = copyMatriks(matriks, m, n-1); // mengembalikan matriks A ke awal
            }
            return solusi;
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
    
    double[][] InversAdj (double[][] matrix, int m, int n){
        int i,j;
        double[][] copy = copyMatriks(matrix,m,n);
        double[][] kof = makeMatrix(m,n);

        double det = DeterminanKof(copy, m,n);

        for (i = 0; i < m; i++){
            for (j = 0; j < n ; j++){
                double[][] minor = makeMinor(matrix,m,n,i,j);
                kof[i][j] = Math.pow(-1,i+j+2) * DeterminanKof(minor, getRow(minor), getCol(minor));
            }
        }

        //printMatriks(kof,kof.length,kof[0].length);

        // transpose

        double[][] trans = copyMatriks(kof,getRow(kof),getCol(kof));

        for (i = 0; i<m; i++){
            for (j = 0; j < n; j++){
                trans[i][j] = kof[j][i]/det;
            }
        }

        return trans;
    }

    double[][] InversOBE (double[][] matriks, int m, int n){
        double[][] copydet = copyMatriks(matriks,m,n);
        double[][] identitas = makeIdentitas(m,n);
        int o = n*2;
        double[][] operasi = makeMatrix(m,o);
        double[][] hasil = makeMatrix(m,n);        
        int i,j,k;
 
        //masukkan matriks ditanya ke matriks operasi
        for (i=0;i<m;i++){
            for(j=0;j<n;j++){
                operasi[i][j] = matriks[i][j];
            }
        }
        
        for(i=0;i<m;i++){
            for (j=n;j<o;j++){
                operasi[i][j] = identitas[i][j-n];
            }
        }

        GaussJordan(operasi,m,o);

        for(i=0;i<m;i++){
            for (j=n;j<o;j++){
                hasil[i][j-n] = operasi[i][j];
            }
        }
        return hasil;
    }

    /* AMBIL SOLUSI DARI SPL */
    String[] getSolution(double[][] matrix){
        int m,n;
        m = getRow(matrix);
        n = getCol(matrix);
        // Ambil solusinya
        // ada 3 kemungkinan solusi
        // cek baris paling bawah dulu
        int countZero = 0;
        for (int j = 0; j < n; j++){
            if(matrix[m-1][j] == 0){
                countZero++;
            }
        }
        if (countZero == n || getRow(matrix) < (getCol(matrix)-1)){
            System.out.println("SPL ini memiliki banyak solusi");
            double[] solusi = new double[n-1];
            String[] output = new String[n-1];
            int[] state= new int[n-1];// jika 1 artinya sudah ditemukan; berkorespondensi dengan solusi
            int l = 1;

            GaussJordan(matrix,getRow(matrix),getCol(matrix));

            for (int i = m-1; i > 0; i--){
                double sum = 0;
                for (int j = 0; j < n-1; j++){
                    sum += (matrix[i][j] * solusi[j]);
                }
                for (int j = 0; j < (n-l); j++){
                    if(matrix[i][j] != 0 && state[j] == 0 & matrix[i][n-1] != 0){
                        solusi[j] = (matrix[i][n-1] - sum) / matrix[i][j];
                        output[j] = solusi[j] +"";
                        state[j] = 1;
                    }
                }
                l++;
            }
            // ganti dengan parameter utk hasil 2 .. n
            String param = "abcdefghijklmnopqrstuvwyz";
            int getidxparam = 0;
            for (int i = 1; i<solusi.length; i++){
                if (state[i] == 0){
                    output[i] = param.charAt(getidxparam)+"";
                    getidxparam++;
                }
            }

            // untuk x1
            if(matrix[0][0] == 0){
                output[0] = param.charAt(getidxparam)+"";
            }else{
                String temp = "";
                for (int i = 1; i < solusi.length; i++){
                    if(state[i]==0){
                        if (matrix[0][i] != 0){
                            temp += "-("+matrix[0][i] + output[i] + ")";
                        }
                    }
                }
                output[0] = matrix[0][n-1] + temp + "";
            }
            
            for (int i = 0; i < n-1; i++){
                System.out.println("x"+(i+1)+" = "+output[i]);
                output[i] = "x"+(i+1)+" = "+output[i];
            }
            return output;

        }else if (countZero == n-1){
            System.out.println("SPL ini tidak memiliki solusi");
            String[] output = new String[1];
            output[0] = "SPL ini tidak memiliki solusi";
            return output;
        }else{ // ada solusi
            double[] solusi = new double[n-1]; // jumlah variabel solusi adalah sejumlah kolomnya dikurangi 1
        
            // backward subs dimulai dari belakang
            for (int i = m-1; i >= 0; i--){
                double sum = 0.0;
                for (int j = 0; j < n-1; j++){
                    sum += matrix[i][j] * solusi[j];
                }
                solusi[i] = (matrix[i][n-1] - sum) / matrix[i][i];
            }
            String[] output = new String[n-1];
            for (int i = 0; i < n-1; i++){
                output[i] = "x"+(i+1)+" = "+solusi[i];
                System.out.println("x"+(i+1)+" = "+solusi[i]);
            }
            return output;
        }
    }
}
