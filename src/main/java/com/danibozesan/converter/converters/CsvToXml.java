package com.danibozesan.converter.converters;

import com.danibozesan.converter.IConverters;
import com.opencsv.CSVReader;
import com.thoughtworks.xstream.XStream;

import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static com.danibozesan.converter.Constants.*;


public class CsvToXml implements IConverters {


    @Override
    public void convert(Path source, Path target) {

        try {
            CSVReader reader = new CSVReader(new FileReader(source.toFile()));
            String[] line = null;

            String[] header = reader.readNext();

            List out = new ArrayList();

            while ((line = reader.readNext()) != null) {
                List<String[]> item = new ArrayList<>();
                for (int i = 0; i < header.length; i++) {
                    String[] keyVal = new String[2];
                    String string = header[i];
                    String val = line[i];
                    keyVal[0] = string;
                    keyVal[1] = val;
                    item.add(keyVal);
                }
                out.add(item);
            }

            XStream xstream = new XStream();

            xstream.toXML(out, new FileWriter(target.toFile(), false));

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public String getSource() {
        return CSV;
    }

    @Override
    public String getTarget() {
        return TXT;
    }
}
