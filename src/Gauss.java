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
            int l = 1;

            for (int i = m-1; i >= 0; i--){
                double sum = 0;
                for (int j = 0; j < n-1; j++){
                    sum += (matrix[i][j] * solusi[j]);
                }
                for (int j = 0; j < (n-l); j++){
                    if(matrix[i][j] != 0)
                        solusi[j] = (matrix[i][n-1] - sum) / matrix[i][j];
                }
                l++;
            }
            
            for (int i = 0; i < n-1; i++){
                System.out.println("x"+(i+1)+" = "+solusi[i]);
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