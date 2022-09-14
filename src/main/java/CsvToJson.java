//import org.json.CDL;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.util.Objects;
//import java.util.stream.Collectors;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.dataformat.csv.*;

public class CsvToJson {

        String pathCsv;
        String pathJson;

    public CsvToJson(String pathCsv, String pathJson) {
        this.pathCsv = pathCsv;
        this.pathJson = pathJson;
    }

    public void converterCsvToJson() {

        File input = new File(pathCsv);
        try {
            CsvSchema csv = CsvSchema.emptySchema().withHeader();
            CsvMapper csvMapper = new CsvMapper();
            MappingIterator<Map<?, ?>> mappingIterator =  csvMapper.reader().forType(Map.class).with(csv).readValues(input);
            List<Map<?, ?>> list = mappingIterator.readAll();
            //csvMapper.writeValue(Paths.get(pathJson).toFile(),list);
            ObjectMapper mapper = new ObjectMapper();
            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

            // convert book object to JSON file
            writer.writeValue(Paths.get(pathJson).toFile(), list);
           // System.out.println(list);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}