class SarrusCrammer{
    /* MEMANFAATKAN DETERMINAN UNTUK MENENTUKAN HASIL */
    public static void main(String[] args){
        Matriks matriks = new Matriks();
        /* Proses Input */
        int m = matriks.inputRow();
        int n = matriks.inputCol();
        double[][] matrix = matriks.makeMatrix(m,n);
        matriks.inputMatriks(matrix,m,n);
        matriks.SarrusCrammer(matrix,m,n);
    }
}