class InversOBE{
    public static void main(String[] args){
        Matriks matriks = new Matriks();

        int m = matriks.inputRow();
        int n = matriks.inputCol();
        double[][] matrix = matriks.makeMatrix(m,n);
        matriks.inputMatriks(matrix,m,n);

        double[][] copydet = matriks.copyMatriks(matrix,m,n);
        double[][] identitas = matriks.makeIdentitas(m,n);

        if (matriks.Determinan(copydet,m,n) == 0){
            System.out.print("Tidak dapat menemukan matriks karena determinan bernilai 0!");
        }

        else{
        int o = n*2;
        double[][] operasi = matriks.makeMatrix(m,o);
        int i,j,k;
        //masukkan matriks ditanya ke matriks operasi
        for (i=0;i<m;i++){
            for(j=0;j<n;j++){
                operasi[i][j] = matrix[i][j];
            }
        }
        
        for(i=0;i<m;i++){
            for (j=n;j<o;j++){
                operasi[i][j] = identitas[i][j-n];
            }
        }
                matriks.printMatriks(operasi,m,o);

        matriks.GaussJordan(operasi,m,o);
        matriks.printMatriks(operasi,m,o);

        double[][] hasil = matriks.makeMatrix(m,n);
        for(i=0;i<m;i++){
            for (j=n;j<o;j++){
                hasil[i][j-n] = operasi[i][j];
            }
        }

        matriks.printMatriks(hasil,m,n);
        }

    }
}