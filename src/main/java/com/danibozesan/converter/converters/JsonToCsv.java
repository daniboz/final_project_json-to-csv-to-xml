package com.danibozesan.converter.converters;

import com.danibozesan.converter.IConverters;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import static com.danibozesan.converter.Constants.CSV;
import static com.danibozesan.converter.Constants.JSON;

public class JsonToCsv implements IConverters {

 JsonNode jsonTree;


 @Override
 public void convert(Path source, Path target) {

  {
   try {
    jsonTree = new ObjectMapper().readTree(new File(source.toUri()));
   } catch (IOException e) {
    throw new RuntimeException(e);
   }
  }

  CsvSchema.Builder csvSchemaBuilder = CsvSchema.builder();
  JsonNode firstObject = jsonTree.elements().next();
  firstObject.fieldNames().forEachRemaining(fieldName -> {csvSchemaBuilder.addColumn(fieldName);} );
  CsvSchema csvSchema = csvSchemaBuilder.build().withHeader();

  CsvMapper csvMapper = new CsvMapper();
  try {
   csvMapper.writerFor(JsonNode.class)
           .with(csvSchema)
           .writeValue(new File(target.toUri()), jsonTree);
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
  return CSV;
 }
}

