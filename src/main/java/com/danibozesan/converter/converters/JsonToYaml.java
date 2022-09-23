package com.danibozesan.converter.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonToYaml implements Product {

    ObjectMapper mapper = new ObjectMapper();

//    @Override
//    public void convert(Path source, Path target)  {  //json file can't be a string ( starts/ends with "") && must be UTF-8
//
//        ObjectMapper mapper = new ObjectMapper();
//
//        try {
//
//            // convert JSON string to Map
//            var map = mapper.readValue(Paths.get(source.toUri()).toFile(), Object.class);
//
//            var jsonAsYaml = new YAMLMapper().writeValueAsString(map);
//
//            var writer = mapper.writer();
//            try {
//                writer.writeValue(target.toFile(),jsonAsYaml.replace("\n"," "));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public void parse(Path source, Path target) {
        Object map = null;
        try {
            map = mapper.readValue(Paths.get(source.toUri()).toFile(), Object.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        writeFile(target.toFile(),map);
    }

    @Override
    public void writeFile(File target, Object value) {
        String jsonAsYaml = null;
        try {
            jsonAsYaml = new YAMLMapper().writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        var writer = mapper.writer();
        try {
            writer.writeValue(target,jsonAsYaml.replace("\n"," "));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
