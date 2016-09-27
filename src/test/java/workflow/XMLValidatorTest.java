package workflow;

import org.junit.Test;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

public class XMLValidatorTest {
    @Test
    public void validate(){

        final String SCHEMA_FILE_STRING = "XSD/constituencyResultXSD.xsd";

        Directory directory= new Directory("election-results/");

        try {

            File SCHEMA_FILE = new File(directory.getResource(SCHEMA_FILE_STRING));
            File validFile = new File(directory.getResource("election-results/result001.xml"));
            //Not valid to schema:
            File invalidFile = new File(directory.getResource("election-results/result041.xml"));
            //Not valid XML:
            File invalidXMLFile = new File(directory.getResource("election-results/result004.xml"));
            File emptyFile = new File(directory.getResource("election-results/result002.xml"));
            File validTxtFile = new File(directory.getResource("election-results/result003.txt"));



            XMLValidator XMLValidator = new XMLValidator();

            boolean isValidFileValid = XMLValidator.validate(validFile, SCHEMA_FILE);

            boolean isInvalidFileValid = XMLValidator.validate(invalidFile, SCHEMA_FILE);

            boolean isInvalidXMLFileValid = XMLValidator.validate(invalidXMLFile, SCHEMA_FILE);

            boolean isEmptyValid = XMLValidator.validate(emptyFile, SCHEMA_FILE);

            boolean isValidTxtValid = XMLValidator.validate(validTxtFile, SCHEMA_FILE);


            //System.out.printf("%s validation = %b.", XML_FILE, valid);

            //should pass
            assertEquals(true, isValidFileValid);
            //should not pass
            assertEquals(false, isInvalidFileValid);
            //should not pass
            assertEquals(false, isInvalidXMLFileValid);
            //should not pass, empty file
            assertEquals(false, isEmptyValid);
            //should not pass, wrong file type
            assertEquals(false, isValidTxtValid);



        }
        catch (IOException e){

        }








    }
}
