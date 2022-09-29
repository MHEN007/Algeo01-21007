/* I.S. Matriks yang diterima merupakan matriks yang sudah mengalami transformasi Gauss 
   F.S. Terbentuk Matriks eselon baris tereduksi */

class GaussJordan{

    public static void main(String[] args){
        Matriks matriks = new Matriks();

        //INPUT MATRIKS
        int m = matriks.inputRow();
        int n = matriks.inputCol();
        double[][] matrix = matriks.makeMatrix(m,n);
        matriks.inputMatriks(matrix,m,n);

        //ELIMINASI GAUSS-JORDAN
        matriks.GaussJordan(matrix,m,n);

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
        if (countZero == n){
            System.out.println("SPL ini memiliki banyak solusi");
        }else if (countZero == n-1){
            System.out.println("SPL ini tidak memiliki solusi");
        }else{ // ada solusi
            double[] solusi = new double[m]; // jumlah variabel solusi adalah sejumlah barisnya
        
            // backward subs dimulai dari belakang
            for (int i = m-1; i >= 0; i--){
                double sum = 0.0;
                for (int j = 0; j < n-1; j++){
                    sum += matrix[i][j] * solusi[j];
                }
                solusi[i] = (matrix[i][n-1] - sum) / matrix[i][i];
            }

            for (int i = 0; i < m; i++){
                System.out.println("x"+(i+1)+" = "+solusi[i]);
            }
        }
    }

}