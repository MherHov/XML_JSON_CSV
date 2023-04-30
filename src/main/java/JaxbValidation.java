import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;

public class JaxbValidation {
    public static void main(String[] args) throws Exception {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            File xsdFile = new File("/Users/goharikkirakosyan/Desktop/JAVA/json_xml_csv/src/students.xsd");
            Schema schema = schemaFactory.newSchema(xsdFile);
            unmarshaller.setSchema(schema);
            File xmlFile = new File("/Users/goharikkirakosyan/Desktop/JAVA/json_xml_csv/src/students.xml");
            Student student = (Student) unmarshaller.unmarshal(xmlFile);
            System.out.println("Validation successful");
        } catch (JAXBException e) {
            System.out.println("Validation failed: " + e.getMessage());
        }
    }
}
