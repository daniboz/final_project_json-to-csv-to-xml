package com.danibozesan.converter.converters;

import com.danibozesan.converter.IConverters;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static com.danibozesan.converter.Constants.CSV;
import static com.danibozesan.converter.Constants.TXT;

public class XmlToCsv implements IConverters {

    @Override
    public void convert(Path source, Path target) {
        Path auxiliarPath = Paths.get(ScannerXmlToCsv());
        XmlToJson xmlToJson=new XmlToJson();
        xmlToJson.convert(source,auxiliarPath);
        JsonToCsv jsonToCsv = new JsonToCsv();
        jsonToCsv.convert(auxiliarPath,target);

    }

    private static String ScannerXmlToCsv()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the path of an auxiliar json file: ");
        return scanner.nextLine();
    }

    @Override
    public String getSource() {
        return TXT;
    }

    @Override
    public String getTarget() {
        return CSV;
    }
}
