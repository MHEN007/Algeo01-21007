import java.util. *;

public class menu{
    public static void main(String[] args){
        System.out.println("MENU");
        System.out.println("1. Sistem Persamaan Linear");
        System.out.println("2. Determinan");
        System.out.println("3. Matriks balikan");
        System.out.println("4. Interpolasi Polinom");
        System.out.println("5. Interpolasi Bicubic");
        System.out.println("6. Regresi linear berganda");
        System.out.println("7. Keluar");

        // input menunya
        
        boolean state = true;
        Scanner in = new Scanner (System.in);
        while (state){
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
            }else if (i == 5){
                //masuk interpolasi bicubic
            }else if (i == 6){
                //masuk regresi linear berganda
            }else if (i == 7){
                state = false;
            }else{
                System.out.println("Input tidak valid! Silakan ulangi input");
            }
        }
    }

    public static void subMenu(int i){
        Matriks matrixmethod = new Matriks();
        if (i == 1){
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
                    matrixmethod.Gauss();
                    state = false;
                }else if (j == 2){
                    //masuk metode eliminasi  gauss -jordan
                    matrixmethod.GaussJordan();
                    state = false;
                }else if (j == 3){
                    // masuk metode matriks balikan
                    matrixmethod.SPLInvers();
                    state = false;
                }else if (j == 4){
                    // masuk metode kaidah cramer
                    matrixmethod.SarrusCrammer();
                    state = false;
                }else{
                    System.out.println("Input tidak valid! Silakan ulangi input");
                }
            }
        }else if (i == 2){
            System.out.println("1. Determinan Kofaktor");
            System.out.println("2. Determinan Reduksi");
            int j;
            boolean state = true;
            while (state){
                Scanner in = new Scanner (System.in);
                j = in.nextInt();
                if (j == 1){
                    // masuk metode determinan kofaktor
                    matrixmethod.DeterminanKof();
                    state = false;
                }else if (j == 2){
                    //masuk metode determinan OBE
                    matrixmethod.Determinan();
                    state = false;
                }else{
                    System.out.println("Input tidak valid! Silakan ulangi input");
                }
            }
        }else if (i == 3){
            System.out.println("1. Invers Adjoin");
            System.out.println("2. Invers OBE");
            int j;
            boolean state = true;
            while (state){
                Scanner in = new Scanner (System.in);
                j = in.nextInt();
                if (j == 1){
                    // masuk metode invers adjoin
                    matrixmethod.InversAdj();
                    state = false;
                }else if (j == 2){
                    //masuk metode invers OBE
                    matrixmethod.InversOBE();
                    state = false;
                }else{
                    System.out.println("Input tidak valid! Silakan ulangi input");
                }
            }
        }
    }
}