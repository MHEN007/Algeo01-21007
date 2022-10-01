class Gauss{
    public static void main(String[] args){
        Matriks matriks = new Matriks();

        //INPUT MATRIKS
        int m = matriks.inputRow();
        int n = matriks.inputCol();
        double[][] matrix = matriks.makeMatrix(m,n);
        matriks.inputMatriks(matrix,m,n);

        //ELIMINASI GAUSS
        matriks.Gauss(matrix,m,n);

        matriks.printMatriks(matrix,m,n);

        // Ambil solusinya
        // ada 3 kemungkinan solusi
        // cek baris paling bawah dulu
        int countZero = 0;
        for (int j = 0; j < n; j++){
            if(matrix[m-1][j] == 0){
                countZero++;
            }
        }
        if (countZero == n || matriks.getRow(matrix) < (matriks.getCol(matrix)-1)){
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

        }else if (countZero == n-1){
            System.out.println("SPL ini tidak memiliki solusi");
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

            for (int i = 0; i < n-1; i++){
                System.out.println("x"+(i+1)+" = "+solusi[i]);
            }
        }
    }
}