class InversAdj{
    public static void main(String[] args){
        Matriks matriks = new Matriks();
        int i,j;
        //input matriks
        // int m = matriks.inputRow();
        // int n = matriks.inputCol();
        // double[][] matrix = matriks.makeMatrix(m,n);
        // matriks.inputMatriks(matrix,m,n);
        double[][] matrix = {{0,1,2},{1,0,3},{4,-3,8}};


        double[][] inv = matriks.InversAdj(matrix,matriks.getRow(matrix),matriks.getCol(matrix));

        matriks.printMatriks(inv, matriks.getRow(inv),matriks.getCol(inv));
    }
}