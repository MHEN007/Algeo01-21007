import java.io. *;
import java.util. *;

class ReadFile {
    /* I.S. Menerima suatu file .txt berisi matriks;
        F.S. Mengembalikan isi dari file .txt tsb dengan array matriks dg
        ukuran yang bersesuaian */
    ReadFile(){}
    double[][] matriks;
    double[][] readfile(String filename){
        Matriks m = new Matriks();
        try{
            int countRow = 0;
            int countCol = 1;
            String line = "";

            File file = new File("../test/"+filename);
            Scanner sc = new Scanner(file);        

            // hitung baris
            while (sc.hasNextLine()){
                line = sc.nextLine();
                countRow++;
            }

            // hitung kolom
            for (int i = 0; i < line.length() - 1; i++){
                if ((line.charAt(i) == ' ') && (line.charAt(i + 1) != ' ')){
                    countCol++;
                }
            }
            
            // inisialisasi matriks
            double[][] matriks = new double[countRow][countCol];

            // isi matriks
            Scanner sc1 = new Scanner(file);
            for (int i = 0; i < m.getRow(matriks); i++){
                for (int j = 0; j < m.getCol(matriks); j++){
                    matriks[i][j] = sc1.nextDouble();
                }
            }

            this.matriks = matriks;

            //m.printMatriks(matriks, m.getRow(matriks), m.getCol(matriks));

        } catch (FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return matriks;
    }
}