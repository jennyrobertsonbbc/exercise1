package workflow;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class XMLValidatorTest {
    @Test
    public void validate(){

        final String SCHEMA_FILE = "XSD/constituencyResultXSD.xsd";

        XMLValidator XMLValidator = new XMLValidator();

        boolean isValidFileValid = XMLValidator.validate("election-results/result001.xml", SCHEMA_FILE);

        boolean isInvalidFileValid = XMLValidator.validate("election-results/result041.xml", SCHEMA_FILE);

        boolean isEmptyValid = XMLValidator.validate("election-results/result002.xml", SCHEMA_FILE);

        boolean isWrongFileTypeValid = XMLValidator.validate("election-results/result041.xml", SCHEMA_FILE);

        //System.out.printf("%s validation = %b.", XML_FILE, valid);

        //should pass
        assertEquals(true, isValidFileValid);
        //should not pass
        assertEquals(false, isInvalidFileValid);
        //should not pass, empty file
        assertEquals(false, isEmptyValid);
        //should not pass, wrong file type
        assertEquals(false, isWrongFileTypeValid);


    }
}
