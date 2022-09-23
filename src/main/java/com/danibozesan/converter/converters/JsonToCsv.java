package com.danibozesan.converter.converters;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class JsonToCsv implements Product {

 JsonNode jsonTree;


// @Override
// public void convert(Path source, Path target) {
//
//  {
//   try {
//    jsonTree = new ObjectMapper().readTree(new File(source.toUri()));
//   } catch (IOException e) {
//    throw new RuntimeException(e);
//   }
//  }
//
//  CsvSchema.Builder csvSchemaBuilder = CsvSchema.builder();
//  JsonNode firstObject = jsonTree.elements().next();
//  firstObject.fieldNames().forEachRemaining(csvSchemaBuilder::addColumn);
//  CsvSchema csvSchema = csvSchemaBuilder.build().withHeader();
//
//  CsvMapper csvMapper = new CsvMapper();
//  try {
//   csvMapper.writerFor(JsonNode.class)
//           .with(csvSchema)
//           .writeValue(new File(target.toUri()), jsonTree);
//  } catch (IOException e) {
//   throw new RuntimeException(e);
//  }
//
//
// }

 @Override
 public void parse(Path source, Path target) {
  //JsonNode jsonTree;
  try {
   jsonTree = new ObjectMapper().readTree(new File(source.toUri()));
  } catch (IOException e) {
   throw new RuntimeException(e);
  }
  writeFile(target.toFile(),jsonTree);
 }

 @Override
 public void writeFile(File target, Object value) {
  //System.out.println(value);
//  CsvSchema.Builder csvSchemaBuilder = CsvSchema.builder();
//  JsonNode firstObject = value.elements().next();
//  firstObject.fieldNames().forEachRemaining(csvSchemaBuilder::addColumn);
//  CsvSchema csvSchema = csvSchemaBuilder.build().withHeader();
//  CsvMapper csvMapper = new CsvMapper();
//  try {
//   csvMapper.writerFor(JsonNode.class)
//           .with(csvSchema)
//           .writeValue(new File(target.toURI()), value);
//  } catch (IOException e) {
//   throw new RuntimeException(e);
//  }
  System.out.println("commented");
 }
}

