package Adapter;

import com.fasterxml.jackson.databind.ObjectMapper;
public class JsonConverter implements DataConverter {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convert(String data) {
        try {
            // Chuyển JSON từ String sang Object
            Object obj = objectMapper.readTree(data);
            // Chuyển Object về JSON chuẩn
            return objectMapper.writeValueAsString(obj); 
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}