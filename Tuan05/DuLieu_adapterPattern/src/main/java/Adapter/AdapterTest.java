package Adapter;

public class AdapterTest {
public static void main(String[] args) {
	 String xmlData = "<Book><title>Ngôi sao</title><author>Hữu Tiến</author></Book>";
     String jsonData = "{\"title\":\"Ngôi sao\",\"author\":\"Hữu Tiến\"}";

     // Chuyển từ XML sang JSON
     DataConverter xmlToJson = new XmlToJsonAdapter();
     System.out.println("Chuyển từ XML sang JSON: ");
     System.out.println(xmlToJson.convert(xmlData));

     // Chuyển từ JSON sang XML
     DataConverter jsonToXml = new XmlConverter();
     System.out.println("\nChuyển từ JSON sang XML: ");
     System.out.println(jsonToXml.convert(jsonData));

}
}
