package com.danibozesan.converter.concreteCreators;

import com.danibozesan.converter.converters.Product;
import com.danibozesan.converter.converters.JsonToYaml;

public class Json2YamlCreate extends Creator {
    @Override
    public Product createTargetFile() {
        return new JsonToYaml();
    }
}
