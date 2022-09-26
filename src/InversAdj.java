class InversAdj{
    public static void main(String[] args){
        Matriks matriks = new Matriks();
        int i,j;
        //input matriks
        int m = matriks.inputRow();
        int n = matriks.inputCol();
        double[][] matrix = matriks.makeMatrix(m,n);
        matriks.inputMatriks(matrix,m,n);

        matriks.InversAdj(matrix,m,n);
    }
}