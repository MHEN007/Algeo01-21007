import java.io. *;
import java.util. *;
class Save{
    Save(){}
    
    void SaveFileString(String input){
        System.out.println("Apakah Anda ingin menyimpan hasil Anda? (1/0)");
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        switch(a){
            case 0:
                break;
            case 1:
                try{
                    System.out.print("Nama file Anda (dengan ext):  ");
                    String filename = in.next();
                    FileWriter f = new FileWriter("../test/"+filename);
                    f.write(input);
                    f.close();
                    System.out.println("Sukses menyimpan " +filename);
                }catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
                break;
        }
    }

    void SaveFileSPL(String[] hasil){
        System.out.println("Apakah Anda ingin menyimpan hasil Anda? (1/0)");
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        switch(a){
            case 0:
                break;
            case 1:
                try{
                    System.out.print("Nama file Anda (dengan ext):  ");
                    String filename = in.next();
                    FileWriter f = new FileWriter("../test/"+filename);
                    for (int i = 0; i < hasil.length; i++){
                        if(i!=hasil.length-1){
                            f.write(hasil[i]+"\n");
                        }else{
                            f.write(hasil[i]);
                        }
                    }
                    f.close();
                    System.out.println("Sukses menyimpan " +filename);
                }catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
                break;
        }
    }

    void SaveFileMatrix(double[][] mat){
        System.out.println("Apakah Anda ingin menyimpan hasil Anda? (1/0)");
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        switch(a){
            case 0:
                break;
            case 1:
                try{
                    //double[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
                    System.out.print("Nama file Anda (dengan ext):  ");
                    String filename = in.next();

                    FileWriter f = new FileWriter("../test/"+filename);
                    for (int i = 0; i < mat.length; i++){
                        for (int j = 0; j < mat[0].length; j++){
                            String isi = mat[i][j]+"";
                            if(j != mat[0].length-1){
                                f.write(isi + " ");
                            }else{
                                f.write(isi);
                            }
                        }
                        if (i != mat.length-1)
                            f.write("\n");
                    }
                    f.close();
                    System.out.println("Sukses menyimpan " +filename);
                }catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
                break;
        }
    }
}