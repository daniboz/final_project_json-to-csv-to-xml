package com.danibozesan.converter.converters;

import com.danibozesan.converter.IConverters;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.danibozesan.converter.Constants.*;

public class JsonToXml implements IConverters {



    @Override
    public void convert(Path source, Path target) {
        String result;
        try {

            // read byte data from the Sample.json file and convert it into String
            result = new String(Files.readAllBytes(source));
            //Convert JSON to XML
            String xml = convertToXML(result, "root"); // This method converts json object to xml string

            // use try-catch to store XML data into file.
            FileWriter file = new FileWriter(target.toFile());

            // use write() method of File to write XML data into XMLData.txt
            file.write(xml);
            file.flush();
            file.close();

        } catch (
                IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    public static String convertToXML(String jsonString, String root) throws JSONException {    // handle JSONException

        try {
            JSONObject jsonObject = new JSONObject(jsonString);

            // use XML.toString() method to convert JSON into XML and store the result into a string
            return "<"+root+">" + XML.toString(jsonObject) + "</"+root+">";

        } catch (JSONException e) {
            JSONArray jsonArray = new JSONArray(jsonString);

            // use XML.toString() method to convert JSON into XML and store the result into a string
            return "<"+ root + ">" + XML.toString(jsonArray) + "</" + root + ">";
        }
    }
    @Override
    public String getSource() {
        return JSON;
    }

    @Override
    public String getTarget() {
        return TXT;
    }
}
