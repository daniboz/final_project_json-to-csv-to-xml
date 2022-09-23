package com.danibozesan.converter.concreteCreators;

import com.danibozesan.converter.converters.Product;
import com.danibozesan.converter.converters.CsvToJson;

public class Csv2JsonCreate extends Creator {
    @Override
    public Product createTargetFile() {
        return new CsvToJson();
    }
}
