package com.danibozesan.converter.concreteCreators;


import com.danibozesan.converter.converters.Product;
import com.danibozesan.converter.converters.JsonToCsv;

public class Json2CsvCreate extends Creator {
    @Override
    public Product createTargetFile() {
        return new JsonToCsv();
    }
}
