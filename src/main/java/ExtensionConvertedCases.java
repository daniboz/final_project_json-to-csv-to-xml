import java.util.Scanner;

public class ExtensionConvertedCases extends ExtensionConvertingCases{

    public ExtensionConvertedCases(String pathConverting, String pathConverted) {
        super(pathConverting, pathConverted);
    }

    public void JsonToXmlCase()
    {
        JsonToXml jsontoxml = new JsonToXml(pathConverting, pathConverted);
        jsontoxml.converter();
        System.out.println("your data is succesfully converted from JSON to XML");
    }

    public void JsonToCsvCase()
    {
        JsonToCsv jsontocsv = new JsonToCsv(pathConverting, pathConverted);
        jsontocsv.converter();
        System.out.println("your data is succesfully converted from JSON to CSV");
    }

    public void JsonToCsvCase(String pathAuxiliar)
    {
        JsonToCsv jsontocsv = new JsonToCsv(pathAuxiliar, pathConverted);
        jsontocsv.converter();
    }

    public void XmlToJsonCase()
    {
        XmlToJson xmltojson = new XmlToJson(pathConverting, pathConverted);
        xmltojson.converter();
        System.out.println("your data is succesfully converted from XML to JSON");
    }

    public void XmlToJsonCase(String pathAuxiliar)
    {
        XmlToJson xmltojson = new XmlToJson(pathConverting, pathAuxiliar);
        xmltojson.converter();
    }

    public void XmlToCsvCase()
    {
        String pathAuxiliar = ScannerXmlToCsv();
        XmlToJsonCase(pathAuxiliar);
        JsonToCsvCase(pathAuxiliar);
        System.out.println("your data is succesfully converted from XML to CSV");
    }

    public void CsvToJsonCase()
    {
        CsvToJson csvtojson = new CsvToJson(pathConverting, pathConverted);
        csvtojson.converter();
        System.out.println("your data is succesfully converted from CSV to JSON");
    }

    public void CsvToXmlCase()
    {
        CsvToXml csvtoxml = new CsvToXml(pathConverting, pathConverted);
        csvtoxml.converter();
        System.out.println("your data is succesfully converted from CSV to XML");
    }

    private static String ScannerXmlToCsv()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the path of an auxiliar json file: ");
        return scanner.nextLine();
    }
}
