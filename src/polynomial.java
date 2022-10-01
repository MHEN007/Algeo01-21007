import java.util. *;

public class Polynomial {
    Polynomial(){}

    Matriks matriks = new Matriks();
    Scanner in = new Scanner(System.in);
    ReadFile r = new ReadFile();
    int m;
    double[][] matrix;

    String polynomial(){
        System.out.println("==========================");
        System.out.println("Pilih Metode Input Matriks");
        System.out.println("1. Input melalui Keyboard");
        System.out.println("2. Input melalui File");
        int pil = in.nextInt();

        //INPUT MATRIKS
        switch(pil){
            case 1:
                this.m = matriks.inputRowPolynomial();
                this.matrix = matriks.makeMatrix(m,2);
                matriks.inputMatriks(matrix,m,2);
                break;
            case 2:
                System.out.print("Masukkan nama file: ");
                String fname = in.next();
                this.matrix = r.readfile(fname);
                this.m = matrix.length;
                break;
        }

        // Contoh Input: 
        // 2 2
        // 3 3

        // Dari input kemudian yang kolom 0 mau dibikin jadi Ax
        // Yang kolom ke 1 jadi B

        // Contohnya:
        // 2^0x1 + 2^1x2 = 2
        // 3^0x1 + 3^1x2 = 3
        
        // Bentuk matriksnya jadi:
        // 1 2 2
        // 1 3 3

        int o = m + 1;

        double[][] ubahMatrix = matriks.makeMatrix(m,o);
        int i;
        for (i = 0; i < m; i++){
            int j;
            for (j = 0; j < o; j++){
                ubahMatrix[i][j] = Math.pow(matrix[i][0],j); /* Loop untuk pemangkatannya (Kondisi Ax) */
            }
        }
            
        for (i = 0; i < m; i++) {
            ubahMatrix[i][m] = matrix[i][1]; /* Loop untuk kondisi B */

        }
        // System.out.print("\n");
        // System.out.print("Matriks setelah diubah:\n");
        // matriks.printMatriks(ubahMatrix,m,o); /*Cetak matriks*/
        // System.out.print("\n");
        matriks.Gauss(ubahMatrix,m,o); /*Lakukan Gauss*/
        // System.out.print("Matriks setelah digauss:\n");
        // matriks.printMatriks(ubahMatrix,m,o); /*Cetak matriks*/
        // System.out.print("\n");

        int countZero = 0;
        for (int j = 0; j < o; j++){
            if(ubahMatrix[m-1][j] == 0){
                countZero++;
            }
        }
    
        double[] solusi = new double[o-1]; // jumlah variabel solusi adalah sejumlah kolomnya dikurangi 1
        
        // backward subs dimulai dari belakang
        for (i = m-1; i >= 0; i--){
            double sum = 0.0;
            for (int j = 0; j < o-1; j++){
                sum += ubahMatrix[i][j] * solusi[j];
            }
            solusi[i] = (ubahMatrix[i][o-1] - sum) / ubahMatrix[i][i];
        }

        // for (i = 0; i < o-1; i++){
        //     System.out.println("a"+(i+1)+" = "+solusi[i]);
        // }

        System.out.print("\n");
        double a = matriks.inputEstimatePolynomial();
        double sumNilaiEstimasi = 0.0;

        for (i = 0 ; i < o-1; i++){
            sumNilaiEstimasi += (solusi[i] * Math.pow(a,i));
        }

        String output = "f(x) = ";
        
        for (i = 0; i < o-1; i++){
            output += "(" + solusi[i] + ")x^" + i;
            if (i != o-2){
                output += " + ";
            }else{
                output += "\n";
            }
        }

        output += "f(" + a + ") = " + sumNilaiEstimasi;
        
        System.out.println(output);
        return (output);
    }
}