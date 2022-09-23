package com.danibozesan.converter.converters;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.dataformat.csv.*;

public class CsvToJson implements Product {

//    @Override
//    public void convert(Path source, Path target) {
//        try {
//            CsvSchema csv = CsvSchema.emptySchema().withHeader();
//            CsvMapper csvMapper = new CsvMapper();
//            MappingIterator<Map<?, ?>> mappingIterator = csvMapper.reader().forType(Map.class).with(csv).readValues(source.toFile());
//            List<Map<?, ?>> list = mappingIterator.readAll();
//            ObjectMapper mapper = new ObjectMapper();
//            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
//
//            // convert book object to JSON file
//            writer.writeValue(target.toFile(), list);
//            // System.out.println(list);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public void parse(Path source, Path target) {
        CsvSchema csv = CsvSchema.emptySchema().withHeader();
        CsvMapper csvMapper = new CsvMapper();
        MappingIterator<Map<?, ?>> mappingIterator = null;
        try {
            mappingIterator = csvMapper.reader().forType(Map.class).with(csv).readValues(source.toFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            List<Map<?, ?>> list = mappingIterator.readAll();
            writeFile(target.toFile(),list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeFile(File target, Object value) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        // convert book object to JSON file
        try {
            writer.writeValue(target, value);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}