package com.danibozesan.converter.converters;

import java.io.File;
import java.nio.file.Path;

public interface Product {
    void writeFile(File target,Object value);

    void parse(Path source, Path target);
    //void convert();

}
