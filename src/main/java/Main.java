
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path of the file you want to convert: ");
        String pathConverting = scanner.nextLine();
        System.out.println("Enter the path of the file where you want to get the converted outcome");
        String pathConverted = scanner.nextLine();

        TypeOfFile converter = new TypeOfFile(pathConverting, pathConverted);
        converter.cases();



//        C:\\Users\\Dani\\Desktop\\tasks_hibyte\\json-to-csv-to-xml\\TASK\\test.json
//        C:\\Users\\Dani\\Desktop\\test1.json
//        C:\\Users\\Dani\\Desktop\\testxml.txt
//        C:\\Users\\Dani\\Desktop\\tasks_hibyte\\json-to-csv-to-xml\\final_project_json-to-csv-to-xml\\XMLData.txt
//        C:\Users\Dani\Desktop\jsonaux.json

    }

}
