class SarrusCrammer(){
    /* MEMANFAATKAN DETERMINAN UNTUK MENENTUKAN HASIL */
    public static void main(String[] args){
        /* Proses Input */
        int m = matriks.inputRow();
        int n = matriks.inputCol();
        double[][] matrix = matriks.makeMatrix(m,n);
        matriks.inputMatriks(matrix,m,n);
    }
}