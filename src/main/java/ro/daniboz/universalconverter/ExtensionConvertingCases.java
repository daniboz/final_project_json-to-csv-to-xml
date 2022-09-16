package ro.daniboz.universalconverter;

public class ExtensionConvertingCases extends TypeOfFile{

    public ExtensionConvertingCases(String pathConverting, String pathConverted) {
        super(pathConverting, pathConverted);
    }

    public void JsonCase(){
        switch (extensionConverted) {
            case "txt" -> {
                ExtensionConvertedCases jsonToXmlCase = new ExtensionConvertedCases(pathConverting,pathConverted);
                jsonToXmlCase.JsonToXmlCase();
            }
            case "csv" -> {
                ExtensionConvertedCases jsonToCsvCase = new ExtensionConvertedCases(pathConverting,pathConverted);
                jsonToCsvCase.JsonToCsvCase();
            }
            default -> System.out.println("Incorrect path of converted file");
        }
    }

    public void XmlCase(){
        switch (extensionConverted) {
            case "json" -> {
               ExtensionConvertedCases xmlToJsonCase = new ExtensionConvertedCases(pathConverting,pathConverted);
               xmlToJsonCase.XmlToJsonCase();
            }
            case "csv" -> {
               ExtensionConvertedCases xmlToCsvCase = new ExtensionConvertedCases(pathConverting,pathConverted);
               xmlToCsvCase.XmlToCsvCase();
            }
            default -> System.out.println("Incorrect path of converted file");
        }
    }

    public void CsvCase(){
        switch (extensionConverted) {
            case "json" -> {
              ExtensionConvertedCases csvToJsonCase = new ExtensionConvertedCases(pathConverting,pathConverted);
              csvToJsonCase.CsvToJsonCase();
            }
            case "txt" -> {
              ExtensionConvertedCases csvToXmlCase = new ExtensionConvertedCases(pathConverting,pathConverted);
              csvToXmlCase.CsvToXmlCase();
            }
            default -> System.out.println("Incorrect path of converted file");
        }
    }
}
