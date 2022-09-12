


import test.CSVWriter;
import test.JSONFlattener;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

public class Main {

    public static void main(String[] args) throws Exception {

        List<Map<String, String>> flatJson;

        flatJson = JSONFlattener.parseJson(new File("test.json"), "UTF-8");

        Set<String> header = CSVWriter.collectOrderedHeaders(flatJson);

        CSVWriter.writeLargeFile(flatJson, ";", "test.csv", header);

        // create variable loc that store location of the Sample.json file
        String loc = "C:\\Users\\Dani\\Desktop\\New Folder\\test.json";

        String result;
        try {

            // read byte data from the Sample.json file and convert it into String
            result = new String(Files.readAllBytes(Paths.get(loc)));
            //Convert JSON to XML
            String xml = convertToXML(result, "root"); // This method converts json object to xml string

            // use try-catch to store XML data into file.
            FileWriter file = new FileWriter("C:\\Users\\Dani\\Desktop\\XMLData.txt");

            // use write() method of File to write XML data into XMLData.txt
            file.write(xml);
            file.flush();
            System.out.println("Your XML data is successfully written into XMLData.txt");

            // close FileWriter
            file.close();

        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }
    public static String convertToXML(String jsonString, String root) throws JSONException {    // handle JSONException

        try {
            JSONObject jsonObject = new JSONObject(jsonString);

            // use XML.toString() method to convert JSON into XML and store the result into a string
            String xml = root+">" + XML.toString(jsonObject) + "</"+root+">";
            return xml;

        } catch (JSONException e) {
            JSONArray jsonArray = new JSONArray(jsonString);

            // use XML.toString() method to convert JSON into XML and store the result into a string
            String xml = root + ">" + XML.toString(jsonArray) + "</" + root + ">";
            return xml;
        }
    }


}
