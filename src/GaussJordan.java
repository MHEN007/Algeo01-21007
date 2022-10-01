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
        if (countZero == n || matriks.getRow(matrix) < (matriks.getCol(matrix)-1)){
            System.out.println("SPL ini memiliki banyak solusi");
        }else if (countZero == n-1){
            System.out.println("SPL ini tidak memiliki solusi");
        }else{ // ada solusi
            for (int i = 0; i < n-1; i++){
                System.out.println("x"+(i+1)+" = "+ matrix[i][n-1]);
            }
        }
    }

}