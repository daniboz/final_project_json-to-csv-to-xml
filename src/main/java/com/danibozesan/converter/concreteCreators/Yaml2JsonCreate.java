package com.danibozesan.converter.concreteCreators;

import com.danibozesan.converter.converters.Product;
import com.danibozesan.converter.converters.YamlToJson;

public class Yaml2JsonCreate extends Creator {
    @Override
    public Product createTargetFile() {
        return new YamlToJson();
    }
}
