package com.danibozesan.converter.converters;

import com.danibozesan.converter.IConverters;
import com.danibozesan.converter.utilities.CSVWriter;
import com.danibozesan.converter.utilities.JSONFlattener;

import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.danibozesan.converter.Constants.CSV;
import static com.danibozesan.converter.Constants.JSON;

public class JsonToCsv implements IConverters {

    List<Map<String, String>> flatJson;

    @Override
    public void convert(Path source, Path target) {
        flatJson = JSONFlattener.parseJson(new File(source.toFile().toURI()), "UTF-8");

        Set<String> header = CSVWriter.collectOrderedHeaders(flatJson);

        CSVWriter.writeLargeFile(flatJson, ";", String.valueOf(target), header);
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
