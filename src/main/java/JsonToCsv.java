import test.CSVWriter;
import test.JSONFlattener;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JsonToCsv {

    List<Map<String, String>> flatJson;
    String pathJson;
    String pathCsv;

    public JsonToCsv(String pathJson, String pathCsv) {
        this.pathJson = pathJson;
        this.pathCsv= pathCsv;
    }

    public void converterJsonToCsv ()
    {

        flatJson = JSONFlattener.parseJson(new File(pathJson), "UTF-8");

        Set<String> header = CSVWriter.collectOrderedHeaders(flatJson);

        CSVWriter.writeLargeFile(flatJson, ";", pathCsv, header);
    }

}
