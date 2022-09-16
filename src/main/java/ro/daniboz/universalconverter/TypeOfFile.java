package ro.daniboz.universalconverter;

import com.google.common.io.Files;

public class TypeOfFile {
    String pathConverting;
    String pathConverted;
    String extensionConverting;
    String extensionConverted;

    public TypeOfFile(String pathConverting,String pathConverted) {
        this.pathConverting = pathConverting;
        this.pathConverted = pathConverted;
        this.extensionConverting = Files.getFileExtension(pathConverting);
        this.extensionConverted= Files.getFileExtension(pathConverted);
    }

    public void cases ()
    {
        switch (extensionConverting) {
            case "json" -> {
                ExtensionConvertingCases jsonCase = new ExtensionConvertingCases(pathConverting, pathConverted);
                jsonCase.JsonCase();
            }
            case "txt" -> {
                ExtensionConvertingCases xmlCase = new ExtensionConvertingCases(pathConverting, pathConverted);
                xmlCase.XmlCase();
            }
            case "csv" -> {
                ExtensionConvertingCases csvCase = new ExtensionConvertingCases(pathConverting, pathConverted);
                csvCase.CsvCase();
            }
            default -> System.out.println("Incorrect path of converting file");
        }
    }
}
