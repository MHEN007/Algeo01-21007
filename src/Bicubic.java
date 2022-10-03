import java.util. *;
import java.io. *;
class Bicubic{
    Bicubic(){}
    
    int i,j,k,l;
    double x,y;
    double[][] input;

    private static Matriks m = new Matriks();
    private static Scanner scan = new Scanner(System.in);

    String bicubic(){
        System.out.println("==========================");
        System.out.println("Pilih Metode Input Matriks");
        System.out.println("1. Input melalui Keyboard");
        System.out.println("2. Input melalui File");
        int pil = scan.nextInt();

        switch (pil){
            case 1:
                System.out.println("Masukkan nilai f(x,y) dalam bentuk matriks 4x4");
                this.input = new double[16][1];
                for (i = 0; i < 16;i++){
                    this.input[i][0] = scan.nextDouble();
                }
                // masukkan nilai x dan y yang akan dicari
                System.out.print("Input nilai x: ");
                this.x = scan.nextDouble();

                System.out.print("Input nilai y: ");
                this.y= scan.nextDouble();
                break;
            case 2:
                try{
                    int countRow = 0;
                    String line = "";
                    System.out.print("Masukkan nama file: ");
                    String filename = scan.next();

                    File file = new File("../test/"+filename);
                    Scanner sc = new Scanner(file);        

                    ArrayList<ArrayList<Double>> tempmatrix = new ArrayList<ArrayList<Double>>();
                    ArrayList<Double> tempxk = new ArrayList<Double>();

                    i = 0;
                    while(sc.hasNextLine()){
                        countRow++;
                        line = sc.nextLine();
                        Scanner sc1 = new Scanner(line);
                        tempmatrix.add(new ArrayList<Double>());
                        while(sc1.hasNextDouble()){
                            tempmatrix.get(i).add(sc1.nextDouble());
                        }
                        i++;
                    }

                    // ambil xk di baris paling bawah
                    for (j = 0; j < tempmatrix.get(tempmatrix.size()-1).size(); j++){
                        tempxk.add(tempmatrix.get(tempmatrix.size()-1).get(j));
                    }
                    tempmatrix.remove(tempmatrix.size()-1);

                    // for (i = 0; i < tempxk.size(); i++){
                    //     System.out.print(tempxk.get(i) + " ");
                    // }

                    // masukkan ke matrix
                    //this.matrix = new double[tempmatrix.size()][tempmatrix.get(0).size()];
                    this.input = new double[tempmatrix.size()*tempmatrix.size()][1];
                    int idxinput = 0;
                    for (i = 0; i < tempmatrix.size(); i++){
                        for (j = 0; j < tempmatrix.get(0).size();j++){
                            this.input[idxinput][0] = tempmatrix.get(i).get(j);
                            idxinput++;
                        }
                    }

                    // masukkan ke xk
                    this.x = tempxk.get(0);
                    this.y = tempxk.get(1);

                }catch (FileNotFoundException e){
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
                break;
        }


        ArrayList<ArrayList<Double>> Xtemp = new ArrayList<ArrayList<Double>>();

        //ALGORITMA
        /* BUAT Matriks 16x16 (Matriks X) */
        int baris = 0;
        for (k = 0; k < 4; k++){
            for (l = 0; l < 4; l++){
                Xtemp.add(new ArrayList<Double>());

                for (i = 0; i < 4; i++){
                    for (j = 0; j < 4; j++){
                        //System.out.print(Math.pow(k-1,i) * Math.pow(l-1,j) + " ");
                        Xtemp.get(baris).add(Math.pow(k-1,i) * Math.pow(l-1,j));
                    }
                }
                baris++;
            }
        }

        double[][] X = new double[Xtemp.size()][Xtemp.get(0).size()];

        for (i = 0; i < Xtemp.size(); i++){
            for (j = 0; j < Xtemp.get(0).size(); j++){
                X[i][j] = Xtemp.get(i).get(j);
            }
        }

        /* Matriks X sudah terbentuk */
        //m.printMatriks(X, m.getRow(X), m.getCol(X));
        
        /* Lakukan Invers thd X */
        double[][] inv = m.InversOBE(X, m.getRow(X), m.getCol(X));
        //m.printMatriks(inv, m.getRow(inv), m.getCol(inv));
        
        /* Kalikan X^-1 dengan input */
        double[][] vekA = m.perkalian(inv,input);
        //.printMatriks(vekA, m.getRow(vekA), m.getCol(vekA));

        // CARI F(X,Y) dengan X dan Y
        double sum = 0;
        
        baris = 0;
        for (i = 0; i < 4; i++){
            for (j = 0; j < 4 ; j++){
                sum += vekA[baris][0] * Math.pow(x,j) * Math.pow(y,i);
                baris++;
            }
        }
        
        System.out.println("f("+x+","+y+") = "+sum);
        return ("f("+x+","+y+") = "+sum);
    }
}