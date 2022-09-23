class Determinan{
    public static void main(String[] args){
        Matriks matriks = new Matriks();

        //INPUT MATRIKS
        int m = matriks.inputRow();
        int n = matriks.inputCol();
        double[][] matrix = matriks.makeMatrix(m,n);
        matriks.inputMatriks(matrix,m,n);

        matriks.printMatriks(matrix,m,n);
        System.out.println();

        System.out.println("Determinan matrix yang diinput adalah " + matriks.Determinan(matrix,m,n));
    }
}