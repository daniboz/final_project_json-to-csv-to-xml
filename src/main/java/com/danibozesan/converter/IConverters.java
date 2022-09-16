package com.danibozesan.converter;

import java.nio.file.Path;

public interface IConverters {

    void convert(Path source, Path target);
    String getSource();
    String getTarget();


}
