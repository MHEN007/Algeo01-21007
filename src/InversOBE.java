class InversOBE{
    public static void main(String[] args){
        Matriks m = new Matriks();
        double[][] matriks = {{4,5,1},{3,4,3},{1,2,1}};
        double[][] invers = m.InversOBE(matriks, m.getRow(matriks), m.getCol(matriks));
        m.printMatriks(invers, m.getRow(invers), m.getCol(invers));
    }
}