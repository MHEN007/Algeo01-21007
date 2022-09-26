

class Invers{
    public static void main(String[] args){
        Matriks matriks = new Matriks();

        //INPUT MATRIKS
        int m = matriks.inputRow();
        int n = matriks.inputCol();
        double[][] matrix = matriks.makeMatrix(m,n);
        matriks.inputMatriks(matrix,m,n);
        double det=0;

        //mencari ekspansi kofaktor
        if (m == 2 && n==2){

            double[][] copymatriks = new double[m][n];
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n ; j++){
                    copymatriks[i][j] = matrix[i][j];
                }
            }

            det = matriks.Determinan(matrix,m,n);
            //Matriks kofaktor = new Matriks();
                // for (int i = 0; i < m; i++){
                //     for (int j = 0; j < n; j++){
                //         copyMatriks[i][j] = matrix[i][j];
                //     }
                // }
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    copymatriks[i][j] *= (1/det); //* matrix[i][j]
                    
                }
            }
            //matriks.printMatriks(copymatriks,m,n);

            double temp=0;
            //melakukan penukaran indeks [0][0] dan [i][i]
            temp = copymatriks[1][1];
            copymatriks[1][1] = copymatriks [0][0];
            copymatriks[0][0] = temp;
            //matriks.printMatriks(copymatriks,m,n);

            //mengalikan indeks [0][1] dan [1][0] dengan -1
            copymatriks[0][1] *= -1;
            copymatriks[1][0] *= -1;

        }

        else{// jika ukuran diatas 2X2
        double[][] copyMatriks = new double[m][n];
        int sign = 1;
        if (m == 1 && n ==1){ // basis rekursi
            matriks.printMatriks(matrix,0,0);
        }else{
            for (int i = 0; i < m; i++){
                double[][] kofaktor = new double[m-1][n-1];
                int row1,col1;
                int k,l;
                row1 = 0;
                for (k = 0; k < m; k++){
                    col1 = 0;
                    for (l = 0; l < n; l++){
                        if (l != i && k != 0){
                            kofaktor[row1][col1] = matrix[k][l];
                            col1 += 1;
                            if (col1 == n-1){
                                col1 = 0;
                                row1 += 1;
                            }
                            copyMatriks[k][l] = kofaktor[row1][col1];
                        }
                    }
                }
            }

            matriks.printMatriks(copyMatriks,m,n);
        }

        }
    }
}


        //matriks.printMatriks(copymatriks,m,n);





            // int o=(m-1),p=(m-1);
            // double[][] copymatriks = new double[m][n];
            // double[][] tempmatriks = new double[m-1][n-1];
            // for (int h=0; h<(n);h++){ //untuk perulangan
            //     for (int i = 0; i < m; i++){//untuk copymatriks
            //         for (int j = 0; j < n ; j++){//untuk copymatriks
            //                 if (i!=h || j!=h){
            //                 for (int k=0; k<o;k++){ //untuk matriks temp
            //                     for (int l=0; l<p;l++){ //untuk matriks temp
            //                     tempmatriks[k][l] = matrix[i][j];
            //                 }


            //                 //copymatriks[i][j] = matrix[i][j];
            //                         }
            //             }
            //         }
            //     }
            //            matriks.printMatriks(tempmatriks,o,p);
