package Adapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlToJsonAdapter implements DataConverter {
    private XmlMapper xmlMapper = new XmlMapper();
    private ObjectMapper jsonMapper = new ObjectMapper();

    @Override
    public String convert(String xmlData) {
        try {
            // Chuyển XML thành Object
            Object obj = xmlMapper.readTree(xmlData);
            // Chuyển Object sang JSON
            return jsonMapper.writeValueAsString(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}