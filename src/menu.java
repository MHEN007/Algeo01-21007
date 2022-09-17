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
                // masuk sub-menu
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
        if (i == 1 || i == 2 || i == 3){
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
                    state = false;
                }else if (j == 2){
                    //masuk metode eliminasi  gauss -jordan
                    state = false;
                }else if (j == 3){
                    // masuk metode matriks balikan
                    state = false;
                }else if (j == 4){
                    // masuk metode kaidah cramer
                    state = false;
                }else{
                    System.out.println("Input tidak valid! Silakan ulangi input");
                }
            }
        }
    }
}