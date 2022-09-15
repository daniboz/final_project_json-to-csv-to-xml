import com.opencsv.CSVReader;
import com.thoughtworks.xstream.XStream;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;



public class CsvToXml implements  IConverters{

            String pathCsv;
            String pathXml;

        public CsvToXml(String pathCsv, String pathXml) {
            this.pathCsv = pathCsv;
            this.pathXml = pathXml;
        }

        @Override
        public void converter()
            {

            try {
                CSVReader reader = new CSVReader(new FileReader(pathCsv));
                String[] line = null;

                String[] header = reader.readNext();

                List out = new ArrayList();

                while((line = reader.readNext())!=null){
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

                xstream.toXML(out, new FileWriter(pathXml,false));

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

}
