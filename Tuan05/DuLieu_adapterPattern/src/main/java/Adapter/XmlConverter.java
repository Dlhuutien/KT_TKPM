package Adapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlConverter implements DataConverter {
    private XmlMapper xmlMapper = new XmlMapper();

    @Override
    public String convert(String data) {
        try {
            // Đọc JSON thành Object trước
            Object obj = new ObjectMapper().readTree(data);
            // Chuyển Object sang XML
            return xmlMapper.writeValueAsString(obj); 
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}