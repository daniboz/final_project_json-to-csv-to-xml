import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class XmlToJson {

    String pathXml;
    String pathJson;

    public XmlToJson(String pathXml, String pathJson) {
        this.pathXml = pathXml;
        this.pathJson = pathJson;
    }

    public void converterXmlToJson()
    {
    String result;
        try {
        result= new String(Files.readAllBytes(Paths.get(pathXml)));
        String json= convertToJSON(result);
        FileWriter file = new FileWriter(pathJson);
        file.write(json);
        file.flush();
        System.out.println("Your JSON data is successfully written in the converted file");
        file.close();
    } catch (IOException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }
}
    // create convertToXML() method for converting JSOn data into XML
    public static String convertToJSON(String xmlString) {
        JSONObject obj;
        String jsonString = "";
        try {
            // use XML.toJSONObject() method to convert XML data into JSON and store result into a variable of type JSONObject
            obj = XML.toJSONObject(xmlString);
            // get JSON string from JSON object and store it into a variable of type string
            jsonString = obj.toString();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // pass the JSON data to the main() method
        return jsonString;
    }
}
