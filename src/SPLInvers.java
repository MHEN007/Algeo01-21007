class SPLInvers{
    public static void main(String[] args){
        Matriks matriks = new Matriks();
        int m = matriks.inputRow();
        int n = matriks.inputCol();
        double[][] matrix = matriks.makeMatrix(m,n);
        matriks.inputMatriks(matrix,m,n);

        double[][] x = matriks.SPLInvers(matrix, m,n);
    }
}