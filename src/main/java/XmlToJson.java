import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class XmlToJson implements IConverters{

    String pathConverting;
    String pathConverted;
  //  public static String jsonStr;

    public XmlToJson(String pathConverting, String pathConverted) {
        this.pathConverting = pathConverting;
        this.pathConverted = pathConverted;
    }

    @Override
    public void converter()
    {
    String result;
        try {
        result= new String(Files.readAllBytes(Paths.get(pathConverting)));
        String json= convertToJSON(result);
    //    jsonStr=json;
        FileWriter file = new FileWriter(pathConverted);
        file.write(json);
        file.flush();
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
