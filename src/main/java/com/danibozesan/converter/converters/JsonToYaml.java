package com.danibozesan.converter.converters;

import com.danibozesan.converter.IConverters;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import static com.danibozesan.converter.Constants.JSON;
import static com.danibozesan.converter.Constants.YAML;

public class JsonToYaml implements IConverters {

    JsonNode jsonTree;

    @Override
    public void convert(Path source, Path target)  {
//        JsonNode jsonNodeTree = null;
//        try {
//            jsonNodeTree = new ObjectMapper().readTree(source.toFile());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        try {
                jsonTree = new ObjectMapper().readTree(new File(source.toUri()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        // save it as YAML
        String jsonAsYaml = null;
        try {
            jsonAsYaml = new YAMLMapper().writeValueAsString(jsonTree);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
       // System.out.println(jsonAsYaml);
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer();
        try {
            writer.writeValue(target.toFile(),jsonAsYaml);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getSource() {
        return JSON;
    }

    @Override
    public String getTarget() {
        return YAML;
    }
}
