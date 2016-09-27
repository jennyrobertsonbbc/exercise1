import domain.ConstituencyResult;
import workflow.Directory;
import workflow.XMLValidator;
//https://github.com/FasterXML/jackson-dataformat-xml
import java.io.*;
import java.util.*;

import static java.lang.String.format;

public class ElectionResultsApp {
    //41 has an error
    public static void main(String[] args) throws IOException {

        Directory directory = new Directory("election-results/");
        Directory XSDdirectory = new Directory("XSD/");
        final String SCHEMA_FILE_STRING = "XSD/constituencyResultXSD.xsd";

        //Create a list in which to store the list of constituency results
        List<ConstituencyResult> listOfConstituencyResults = new ArrayList<ConstituencyResult>();

        //loop through every file in the directory
        for (int i = 0; i < directory.getNumberOfFilesInDirectory(); i++) {

            File xmlFile = directory.getSingleFileFromDirectory(i);

            //VALIDATE

            XMLValidator XMLValidator = new XMLValidator();

            boolean valid;


            valid = XMLValidator.validate(xmlFile, XSDdirectory.getSingleFileFromDirectory(0));


            if (!valid) {
                System.out.println(format("%s is invalid xml, skipped. ", xmlFile.getName()));

                continue;
            }



            //System.out.printf("%s validation = %b.", XML_FILE, valid);

            String fileAsString = directory.readFileInAsString(xmlFile);

            ConstituencyResult currentConstituencyResult = directory.returnXmlFileAsPojo(fileAsString);


            //add to the list
            listOfConstituencyResults.add(currentConstituencyResult);


            //print the file
          currentConstituencyResult.printAsTable();

            //wait 1 second
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
            }

        }

    }

}
