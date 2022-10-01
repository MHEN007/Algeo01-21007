/*
DESKRIPSI : Program input matriks.
Menerima input baris m dan kolom n. Lalu dibuat matriks dengan ukuran tersebut.
Kemudian dilakukan input koefisien aij dan koefisien bij dalam bentuk matriks.
Semua input dilakukan melalui keyboard. Matriks dibuat dengan array dalam array
*/

class InputMatriks{
    public static void main(String[] args){
        Matriks matriks = new Matriks();
        int m = matriks.inputRow();
        int n = matriks.inputCol();
        double[][] matrix = matriks.makeMatrix(m,n);
        matriks.inputMatriks(matrix,m,n);
    }
}