package com.danibozesan.converter;

import com.danibozesan.converter.converters.*;
import com.google.common.io.Files;

import java.nio.file.Path;
import java.nio.file.Paths;
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

        List<IConverters> allConverters = Arrays.asList(new JsonToCsv(),new JsonToXml(),new CsvToJson(), new CsvToXml(), new XmlToJson() ,new XmlToCsv());

        for (IConverters converter : allConverters) {
            if(converter.getSource().equals(sourceExtension) && converter.getTarget().equals(targetExtension))
               converter.convert(sourcePath,targetPath);
        }

//        com.danibozesan.converter.TypeOfFile casesOfFile = new com.danibozesan.converter.TypeOfFile(pathConverting,pathConverted);
//        casesOfFile.casesOfFiles();



//        C:\\Users\\Dani\\Desktop\\tasks_hibyte\\json-to-csv-to-xml\\TASK\\test.json
//        C:\\Users\\Dani\\Desktop\\test1.json
//        C:\\Users\\Dani\\Desktop\\testxml.txt
//        C:\\Users\\Dani\\Desktop\\tasks_hibyte\\json-to-csv-to-xml\\final_project_json-to-csv-to-xml\\XMLData.txt
//        C:\Users\Dani\Desktop\jsonaux.json

    }

}
