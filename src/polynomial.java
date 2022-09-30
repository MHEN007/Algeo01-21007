public class polynomial {
    public static void main(String[] args){
        Matriks matriks = new Matriks();

        //INPUT MATRIKS
        int m = matriks.inputRowPolynomial();
        double[][] matrix = matriks.makeMatrix(m,2);
        matriks.inputMatriks(matrix,m,2);
        matriks.printMatriks(matrix,m,2); /*input absis dan ordinat dengan matriks 2x2 */
    }

    // Contoh Input: 
    // 2 2
    // 3 3

    // Dari input kemudian yang kolom 0 mau dibikin jadi Ax
    // Yang kolom ke 1 jadi B

    // Cpntohnya:
    // 2^0x1 + 2^1x2 = 2
    // 3^0x1 + 3^1x2 = 3
    
    // Bentuk matriksnya jadi:
    // 1 2 2
    // 1 3 3
    
    int i;
    for (i = 0; i < m; i++){
        int j;
        for (j=0; j < (n-1); j++){
            Matriks[i][j] = Math.pow(Matriks[i][0],j); /* Loop untuk pemangkatannya (Kondisi Ax) */
        }
    
    for (i = 0; i <= m; i++) {
        Matriks[i][n] = Matriks[i][1]; /* Loop untuk kondisi B */

    matriks.Gauss(matrix,m,n); /*Lakukan Gauss*/
    matriks.printMatriks(matrix,m,n); /*Cetak matriks*/

}
