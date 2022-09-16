package ro.daniboz.universalconverter;

import com.google.common.io.Files;
import ro.daniboz.universalconverter.converters.CsvToJson;
import ro.daniboz.universalconverter.converters.JsonToCsv;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path of the file you want to convert: ");
        String source = scanner.nextLine();
        System.out.println("Enter the path of the file where you want to get the converted outcome");
        String target = scanner.nextLine();

        Path sourcePath = Paths.get(source);
        Path targetPath = Paths.get(target);

        String sourceExtension = Files.getFileExtension(source);
        String targetExtension = Files.getFileExtension(target);

//        TypeOfFile converter = new TypeOfFile(pathConverting, pathConverted);
//        converter.cases();
//new JsonToCsv(), new CsvToJson()

        List<IConverters> allConverters = Arrays.asList(new JsonToCsv(), new CsvToJson(), new XmlToTxt());

        for (IConverters converter : allConverters) {
            if(converter.getSource().equals(sourceExtension) && converter.getTarget().equals(targetExtension))
                converter.convert(sourcePath, targetPath);
        }


//        C:\\Users\\Dani\\Desktop\\tasks_hibyte\\json-to-csv-to-xml\\TASK\\test.json
//        C:\\Users\\Dani\\Desktop\\test1.json
//        C:\\Users\\Dani\\Desktop\\testxml.txt
//        C:\\Users\\Dani\\Desktop\\tasks_hibyte\\json-to-csv-to-xml\\final_project_json-to-csv-to-xml\\XMLData.txt
//        C:\Users\Dani\Desktop\jsonaux.json

    }

}
