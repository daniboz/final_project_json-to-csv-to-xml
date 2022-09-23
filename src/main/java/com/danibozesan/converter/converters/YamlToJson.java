package com.danibozesan.converter.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class YamlToJson implements Product {
//    @Override
//    public void convert(Path source, Path target) {
//        try {
//            ObjectMapper yamlReader = new ObjectMapper(new YAMLFactory());
//            Object obj = yamlReader.readValue(source.toFile(), Object.class);
//            ObjectMapper jsonWriter = new ObjectMapper();
//            //System.out.println(jsonWriter.writerWithDefaultPrettyPrinter().writeValueAsString(obj));
//
//            ObjectMapper mapper = new ObjectMapper();
//            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
//            writer.writeValue(target.toFile(), jsonWriter.writeValueAsString(obj).replace("\""," "));
//        } catch (JsonProcessingException ex) {
//            ex.printStackTrace();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }

    @Override
    public void parse(Path source, Path target) {
        ObjectMapper yamlReader = new ObjectMapper(new YAMLFactory());
        try {
            Object obj = yamlReader.readValue(source.toFile(), Object.class);
            writeFile(target.toFile(),obj);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void writeFile(File target, Object value) {
        ObjectMapper jsonWriter = new ObjectMapper();
        //System.out.println(jsonWriter.writerWithDefaultPrettyPrinter().writeValueAsString(obj));

        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        try {
            writer.writeValue(target, jsonWriter.writeValueAsString(value).replace("\""," "));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
