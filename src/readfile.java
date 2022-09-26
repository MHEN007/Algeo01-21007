import java.io.File;
import java.util.Scanner;

class readfile {
    public static void main(String[] args) throws Exception{
        File file = new File("D:\\JASON\\KULIAH ITB\\MATKUL\\SEMESTER 3\\Aljabar Linier & Geometri\\TUBES 1\\Algeo01-21007\\src\\matrix.txt");
        Scanner sc = new Scanner(file);
 
        while (sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }
    }
}

// Yang dari Matthew
// def load_file(args, file_name):
    // saveas = []
    // temp = ""
    // cc = []
    // with open (f'{args}/{file_name}.csv', "r") as file:
        // for row in file:
            // for char in row:
                // if char != ";" and char!="\n":
                    // temp += char
                // else:
                    // cc += [temp]
                    // temp = ""
            // saveas += [cc]
            // cc = []
    // file.close()
    // return(saveas)

// Kalo w coba terjemahin:
// class load_file(String [] args){
    // array saveas = [];
    // char temp = "";
    // array cc = [];
    // File file = new File (matrix.txt);
        // for (row in file){
            // for (char in row){
                // if (char != ";" && char != "\n"){
                    // temp += char;
                // }
                // else{
                    // temp = "";
                // }
            // }
            // saveas += [cc];
            // cc = [];
        // }
    // file.close();
    // return(saveas);
// }