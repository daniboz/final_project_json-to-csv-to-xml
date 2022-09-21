package com.danibozesan.converter.converters;

import com.danibozesan.converter.IConverters;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.danibozesan.converter.Constants.*;

public class XmlToJson implements IConverters {


    @Override
    public void convert(Path source, Path target) {
            String result;
            try {
                result = new String(Files.readAllBytes(source));
                String json = convertToJSON(result);
                //    jsonStr=json;
                FileWriter file = new FileWriter(target.toFile());
                file.write(json);
                file.flush();
                file.close();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
    }



            public static String convertToJSON (String xmlString){
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

            @Override
            public String getSource () {
            return TXT;
        }

            @Override
            public String getTarget () {
            return JSON;
        }

    }