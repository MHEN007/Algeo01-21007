import java.util. *;
import java.io. *;

public class Menu{
    private static Matriks mat = new Matriks();
    private static ReadFile r = new ReadFile();
    private static Save s = new Save();
    private static Polynomial p = new Polynomial();
    private static Regresi reg = new Regresi();
    public static double[][] matriks;

    Menu(){}

    void menu(){
        Scanner in = new Scanner (System.in);
        // Start
        boolean state = true;
        while (state){
            System.out.println("===========================");
            System.out.println("MENU");
            System.out.println("1. Sistem Persamaan Linear");
            System.out.println("2. Determinan");
            System.out.println("3. Matriks balikan");
            System.out.println("4. Interpolasi Polinom");
            System.out.println("5. Interpolasi Bicubic");
            System.out.println("6. Regresi linear berganda");
            System.out.println("7. Keluar");
            int i;
            i = in.nextInt();
            if(i == 1){
                // masuk sub-menu SPL
                subMenu(1);
            }else if(i == 2){
                //masuk sub menu determinan
                subMenu(2);
            }else if(i == 3){
                //masuk matriks balikan
                subMenu(3);
            }else if (i == 4){
                //masuk interpolasi polinom
                s.SaveFileString(p.polynomial());
            }else if (i == 5){
                //masuk interpolasi bicubic
            }else if (i == 6){
                //masuk regresi linear berganda
                s.SaveFileString(reg.regresi());
            }else if (i == 7){
                state = false;
            }else{
                System.out.println("Input tidak valid! Silakan ulangi input");
            }
        }
    }

    void subMenu(int i){
        if (i == 1){
            System.out.println("===========================");
            System.out.println("SUB-MENU");
            System.out.println("1. Metode eliminasi Gauss");
            System.out.println("2. Metode eliminasi Gauss-Jordan");
            System.out.println("3. Matriks balikan");
            System.out.println("4. Kaidah Cramer");
            int j;
            boolean state = true;
            while (state){
                Scanner in = new Scanner (System.in);
                j = in.nextInt();
                if (j == 1){
                    // masuk metode elminasi gauss
                    matriks = insertMatSPL();
                    mat.Gauss(matriks, mat.getRow(matriks), mat.getCol(matriks));
                    //mat.printMatriks(matriks, mat.getRow(matriks), mat.getCol(matriks));
                    String[] solusi = mat.getSolution(matriks);
                    s.SaveFileSPL(solusi);
                    state = false;
                }else if (j == 2){
                    //masuk metode eliminasi  gauss -jordan
                    matriks = insertMatSPL();
                    mat.GaussJordan(matriks, mat.getRow(matriks), mat.getCol(matriks));
                    //mat.printMatriks(matriks, mat.getRow(matriks), mat.getCol(matriks));
                    String[] solusi = mat.getSolution(matriks);
                    s.SaveFileSPL(solusi);
                    state = false;
                }else if (j == 3){
                    // masuk metode matriks balikan
                    matriks = insertMatSPL();
                    String[] solusi = mat.SPLInvers(matriks, mat.getRow(matriks), mat.getCol(matriks));
                    for (int l = 0; l < solusi.length; l++){
                        System.out.println(solusi[l]);
                    }
                    s.SaveFileSPL(solusi);
                    state = false;
                }else if (j == 4){
                    // masuk metode kaidah cramer
                    matriks = insertMatSPL();
                    String[] solusi = mat.SarrusCrammer(matriks, mat.getRow(matriks), mat.getCol(matriks));
                    s.SaveFileSPL(solusi);
                    state = false;
                }else{
                    System.out.println("Input tidak valid! Silakan ulangi input");
                }
            }
        }else if (i == 2){
            System.out.println("===========================");
            System.out.println("SUB-MENU");
            System.out.println("1. Determinan Kofaktor");
            System.out.println("2. Determinan Reduksi");
            int j;
            boolean state = true;
            while (state){
                Scanner in = new Scanner (System.in);
                j = in.nextInt();
                if (j == 1){
                    // masuk metode determinan kofaktor
                    matriks = insertMat();
                    String det = mat.DeterminanKof(matriks, mat.getRow(matriks), mat.getCol(matriks))+"";
                    System.out.println("Determinan matriks yang diinput: " + det);
                    s.SaveFileString(det);
                    state = false;
                }else if (j == 2){
                    //masuk metode determinan OBE
                    matriks = insertMat();
                    String det = mat.Determinan(matriks, mat.getRow(matriks), mat.getCol(matriks))+"";
                    System.out.println("Determinan matriks yang diinput: " + det);
                    s.SaveFileString(det);
                    state = false;
                }else{
                    System.out.println("Input tidak valid! Silakan ulangi input");
                }
            }
        }else if (i == 3){
            System.out.println("===========================");
            System.out.println("SUB-MENU");
            System.out.println("1. Invers Adjoin");
            System.out.println("2. Invers OBE");
            int j;
            boolean state = true;
            while (state){
                Scanner in = new Scanner (System.in);
                j = in.nextInt();
                if (j == 1){
                    // masuk metode invers adjoin
                    matriks = insertMat();
                    if(mat.DeterminanKof(matriks, mat.getRow(matriks), mat.getCol(matriks))!=0){
                        double[][] inv = mat.InversAdj(matriks, mat.getRow(matriks), mat.getCol(matriks));
                        mat.printMatriks(inv, mat.getRow(inv), mat.getCol(inv));
                        s.SaveFileMatrix(inv);
                    }else{
                        System.out.println("Matriks ini tidak memiliki balikan");
                        s.SaveFileString("Matriks ini tidak memiliki balikan");
                    }
                    state = false;
                }else if (j == 2){
                    //masuk metode invers OBE
                    matriks = insertMat();
                    if(mat.DeterminanKof(matriks, mat.getRow(matriks), mat.getCol(matriks))!=0){
                        double[][] inv = mat.InversOBE(matriks, mat.getRow(matriks), mat.getCol(matriks));
                        mat.printMatriks(inv, mat.getRow(inv), mat.getCol(inv));
                        s.SaveFileMatrix(inv);
                    }else{
                        System.out.println("Matriks ini tidak memiliki balikan");
                        s.SaveFileString("Matriks ini tidak memiliki balikan");
                    }
                    state = false;
                }else{
                    System.out.println("Input tidak valid! Silakan ulangi input");
                }
            }
        }
    }

    public static double[][] insertMat(){
        Scanner in = new Scanner(System.in);
        String fname;
        System.out.println("==========================");
        System.out.println("Pilih Metode Input Matriks");
        System.out.println("1. Input melalui Keyboard");
        System.out.println("2. Input melalui File");
        int a = in.nextInt();
        switch (a){
            case 1:
                System.out.println("Masukkan ukuran matriks (n): ");
                int n = in.nextInt();
                matriks = mat.makeMatrix(n,n);
                mat.inputMatriks(matriks,n,n);
                break;
            case 2:
                System.out.print("Masukkan nama file: ");
                fname = in.next();
                matriks = r.readfile(fname);
                break;
        }
        return matriks;
    }

    public static double[][] insertMatSPL(){
        Scanner in = new Scanner(System.in);
        String fname;
        System.out.println("==========================");
        System.out.println("Pilih Metode Input Matriks");
        System.out.println("1. Input melalui Keyboard");
        System.out.println("2. Input melalui File");
        System.out.println("3. Menggunakan Matriks Hilbert n");
        int a = in.nextInt();
        switch (a){
            case 1:
                int m = mat.inputRow();
                int n = mat.inputCol();
                double[][] A = mat.makeMatrix(m,n-1);
                double[][] B = mat.makeMatrix(m,1);
                System.out.println("Masukkan matriks A");
                mat.inputMatriks(A,m,n-1);
                System.out.println("Masukkan matriks B");
                mat.inputMatriks(B,m,1);
                // gabung A dan B
                matriks = mat.makeMatrix(m,n);
                for (int i = 0; i < m; i++){
                    for (int j = 0; j < n-1; j++){
                        matriks[i][j] = A[i][j];
                    }
                    matriks[i][n-1] = B[i][0];
                }
                break;
            case 2:
                System.out.print("Masukkan nama file: ");
                fname = in.next();
                matriks = r.readfile(fname);
                break;
            case 3:
                System.out.print("Masukkan n untuk Matriks Hilbert: ");
                int nhib = in.nextInt();
                matriks = mat.matriksHilbert(nhib);
                break;
        }
        return matriks;
    }
}
