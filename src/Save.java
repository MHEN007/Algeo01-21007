import java.io. *;
import java.util. *;
class Save{
    Save(){}

    void SaveFile(double[][] mat){
        System.out.println("Apakah Anda ingin menyimpan hasil Anda? (1/0)");
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        switch(a){
            case 0:
                break;
            case 1:
                try{
                    //double[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
                    System.out.print("Nama file Anda: (dengan ext) ");
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
                }catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
        }
    }
}