package com.danibozesan.converter.converters;
import java.nio.file.Path;
import java.util.*;

import com.danibozesan.converter.IConverters;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.dataformat.csv.*;

import static com.danibozesan.converter.Constants.CSV;
import static com.danibozesan.converter.Constants.JSON;

public class CsvToJson implements IConverters {

    @Override
    public void convert(Path source, Path target) {
        try {
            CsvSchema csv = CsvSchema.emptySchema().withHeader();
            CsvMapper csvMapper = new CsvMapper();
            MappingIterator<Map<?, ?>> mappingIterator = csvMapper.reader().forType(Map.class).with(csv).readValues(source.toFile());
            List<Map<?, ?>> list = mappingIterator.readAll();
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