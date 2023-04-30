import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XmlValidation {
    public static void main(String[] args) throws Exception {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        File xsdFile = new File("/Users/goharikkirakosyan/Desktop/JAVA/json_xml_csv/src/students.xsd");
        Schema schema = schemaFactory.newSchema(xsdFile);
        Validator validator = schema.newValidator();
        File xmlFile = new File("/Users/goharikkirakosyan/Desktop/JAVA/json_xml_csv/src/students.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(xmlFile);
        DOMSource source = new DOMSource(document);
        try {
            validator.validate(source);
            System.out.println("Validation successful");
        } catch (SAXException e) {
            System.out.println("Validation failed: " + e.getMessage());
        }
    }
}

