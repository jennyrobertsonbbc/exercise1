package workflow;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class XMLValidator {
//    public static final String XML_FILE = "election-results/result002.xml";
//    public static final String SCHEMA_FILE = "XSD/constituencyResultXSD.xsd";

//    public static void main(String[] args) {
//        XMLValidator XMLValidator = new XMLValidator();
//        boolean valid = XMLValidator.validate(XML_FILE, SCHEMA_FILE);
//
//        System.out.printf("%s validation = %b.", XML_FILE, valid);
//    }

    public boolean validate(File xmlFile, File schemaFile) {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            //See if it validates
            Schema schema = schemaFactory.newSchema(schemaFile);

            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xmlFile));

            return true;
            //if not catch the error
        } catch (SAXException | IOException e) {
            //e.printStackTrace();
            //System.out.println("Failed!");
            return false;
        }
    }

    private String getResource(String filename) throws FileNotFoundException {
        URL resource = getClass().getClassLoader().getResource(filename);
        Objects.requireNonNull(resource);

        return resource.getFile();
    }
}