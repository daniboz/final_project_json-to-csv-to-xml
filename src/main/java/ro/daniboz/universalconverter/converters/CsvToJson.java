package ro.daniboz.universalconverter.converters;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import ro.daniboz.universalconverter.IConverters;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import static ro.daniboz.universalconverter.Constants.CSV;
import static ro.daniboz.universalconverter.Constants.JSON;

public class CsvToJson implements IConverters {

    @Override
    public void convert(Path source, Path target) {
        try {
            CsvSchema csv = CsvSchema.emptySchema().withHeader();
            CsvMapper csvMapper = new CsvMapper();
            MappingIterator<Map<?, ?>> mappingIterator = csvMapper.reader().forType(Map.class).with(csv).readValues(source.toFile());
            List<Map<?, ?>> list = mappingIterator.readAll();
            //csvMapper.writeValue(Paths.get(pathJson).toFile(),list);
            ObjectMapper mapper = new ObjectMapper();
            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

            // convert book object to JSON file
            writer.writeValue(target.toFile(), list);
            // System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getSource() {
        return CSV;
    }

    @Override
    public String getTarget() {
        return JSON;
    }
}