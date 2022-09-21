package com.danibozesan.converter.converters;

import com.danibozesan.converter.IConverters;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import static com.danibozesan.converter.Constants.JSON;
import static com.danibozesan.converter.Constants.YAML;

public class JsonToYaml implements IConverters {

    @Override
    public void convert(Path source, Path target)  {  //json file can't be a string ( starts/ends with "") && must be UTF-8

        ObjectMapper mapper = new ObjectMapper();

        try {

            // convert JSON string to Map
            var map = mapper.readValue(Paths.get(source.toUri()).toFile(), Object.class);

            var jsonAsYaml = new YAMLMapper().writeValueAsString(map);

            var writer = mapper.writer();
            try {
                writer.writeValue(target.toFile(),jsonAsYaml.replace("\n"," "));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            e.printStackTrace();
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
