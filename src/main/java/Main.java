

import org.apache.log4j.BasicConfigurator;
import test.CSVWriter;
import test.JSONFlattener;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws Exception {

        List<Map<String, String>> flatJson;

        flatJson = JSONFlattener.parseJson(new File("test.json"), "UTF-8");

        Set<String> header = CSVWriter.collectOrderedHeaders(flatJson);

        CSVWriter.writeLargeFile(flatJson, ";", "test.csv", header);
        BasicConfigurator.configure();
    }

    private static String jsonString() {
        return  "[" +
                "    {" +
                "        \"studentName\": \"Foo\"," +
                "        \"Age\": \"12\"," +
                "        \"subjects\": [" +
                "            {" +
                "                \"name\": \"English\"," +
                "                \"marks\": \"40\"" +
                "            }," +
                "            {" +
                "                \"name\": \"History\"," +
                "                \"marks\": \"50\"" +
                "            }" +
                "        ]" +
                "    }" +
                "]";
    }
}
