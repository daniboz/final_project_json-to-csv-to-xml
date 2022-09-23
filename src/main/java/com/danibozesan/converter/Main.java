package com.danibozesan.converter;

import com.danibozesan.converter.concreteCreators.*;
import com.google.common.io.Files;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class Main {

    private static Creator conversion;
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

        configure(sourceExtension,targetExtension);
        conversion.doTheJob(sourcePath,targetPath);

//        List<IConverters> allConverters = Arrays.asList(new JsonToCsv(), new CsvToJson(), new YamlToJson(), new JsonToYaml());
//
//        for (IConverters converter : allConverters) {
//            if(converter.getSource().equals(sourceExtension) && converter.getTarget().equals(targetExtension))
//               converter.convert(sourcePath,targetPath);
//        }

//        C:\\Users\\Dani\\Desktop\\tasks_hibyte\\json-to-csv-to-xml\\TASK\\test.json
//        C:\\Users\\Dani\\Desktop\\test1.json
//        C:\\Users\\Dani\\Desktop\\testxml.txt
//        C:\\Users\\Dani\\Desktop\\tasks_hibyte\\json-to-csv-to-xml\\final_project_json-to-csv-to-xml\\XMLData.txt
//        C:\Users\Dani\Desktop\jsonaux.json

    }
    static void configure(String sourceExtension, String targetExtension)
    {
        if(sourceExtension.equals("json") && targetExtension.equals("yaml")||sourceExtension.equals("json") && targetExtension.equals("yml"))
        {
            conversion = new Json2YamlCreate();
        }
        else if(sourceExtension.equals("json") && targetExtension.equals("csv"))
        {
            conversion = new Json2CsvCreate();
        }
        else if(sourceExtension.equals("csv") && targetExtension.equals("json"))
        {
            conversion = new Csv2JsonCreate();
        }
        else if(sourceExtension.equals("yaml") && targetExtension.equals("json")||sourceExtension.equals("yml") && targetExtension.equals("json"))
        {
            conversion = new Yaml2JsonCreate();
        }
    }

}
