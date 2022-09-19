package com.danibozesan.converter.converters;

import com.danibozesan.converter.IConverters;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.nio.file.Path;

import static com.danibozesan.converter.Constants.JSON;
import static com.danibozesan.converter.Constants.YAML;

public class YamlToJson implements IConverters {
    @Override
    public void convert(Path source, Path target) {
        try {
            ObjectMapper yamlReader = new ObjectMapper(new YAMLFactory());
            Object obj = yamlReader.readValue(source.toFile(), Object.class);
            ObjectMapper jsonWriter = new ObjectMapper();
            //System.out.println(jsonWriter.writerWithDefaultPrettyPrinter().writeValueAsString(obj));

            ObjectMapper mapper = new ObjectMapper();
            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
            writer.writeValue(target.toFile(), jsonWriter.writeValueAsString(obj));
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String getSource() {
        return YAML;
    }

    @Override
    public String getTarget() {
        return JSON;
    }
}
