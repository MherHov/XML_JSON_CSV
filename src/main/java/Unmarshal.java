import java.io.File;
import java.util.List;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;

public class Unmarshal {
    public static void main(String[] args) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        File xsdFile = new File("/Users/goharikkirakosyan/Desktop/JAVA/json_xml_csv/src/students.xsd");
        Schema schema = schemaFactory.newSchema(xsdFile);
        unmarshaller.setSchema(schema);
        File xmlFile = new File("/Users/goharikkirakosyan/Desktop/JAVA/json_xml_csv/src/students.xml");
        JAXBElement<Student> studentsElement = (JAXBElement<Student>) unmarshaller.unmarshal(xmlFile);
        Student students = studentsElement.getValue();
        List<Student> studentList = students.getStudent();
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}
