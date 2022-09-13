import com.google.common.io.Files;

public class TypeOfFile {
    String pathConverting;
    String pathConverted;
    String extension;
    String extensionConverted;

    public TypeOfFile(String pathConverting,String pathConverted) {
        this.pathConverting = pathConverting;
        this.pathConverted = pathConverted;
        this.extension= Files.getFileExtension(pathConverting);
        this.extensionConverted= Files.getFileExtension(pathConverted);
    }

    public void cases ()
    {
        switch (extension)
        {
            case "json":
                switch (extensionConverted) {
                    case "txt": {
                        JsonToXml jsontoxml = new JsonToXml(pathConverting, pathConverted);
                        jsontoxml.converterJsonToXml();
                        break;
                    }
                    case "csv": {
                        JsonToCsv jsontocsv = new JsonToCsv(pathConverting, pathConverted);
                        jsontocsv.converterJsonToCsv();
                        break;
                    }
                    default:
                        System.out.println("Incorrect path of converted file");
                }
                break;
            case "txt":
                switch (extensionConverted) {
                    case "json": {
                        XmlToJson xmltojson = new XmlToJson(pathConverting, pathConverted);
                        xmltojson.converterXmlToJson();
                        break;
                    }
                    case "csv": {
                        break;
                    }
                    default:
                        System.out.println("Incorrect path of converted file");
                }
                break;
            case "csv":
                switch (extensionConverted) {
                    case "json": {

                        break;
                    }
                    case "txt": {
                        break;
                    }
                    default:
                        System.out.println("Incorrect path of converted file");
                }
                break;

            default:
                System.out.println("Incorrect path of converting file");
        }
    }
}
