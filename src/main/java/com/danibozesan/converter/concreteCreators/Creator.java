package com.danibozesan.converter.concreteCreators;


import com.danibozesan.converter.converters.Product;

import java.nio.file.Path;

public abstract class Creator {

    public void doTheJob(Path source, Path target)
    {
//      TargetFile targetFile= createTargetFile();
//      parse();
//      convert();
//      targetFile.writeFile();

        Product product = createTargetFile();
        product.parse(source,target);
    }

    public abstract Product createTargetFile();

}
