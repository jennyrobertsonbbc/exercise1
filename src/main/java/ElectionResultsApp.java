import domain.ConstituencyResult;
import workflow.Directory;
//https://github.com/FasterXML/jackson-dataformat-xml
import java.io.*;
import java.util.*;

public class ElectionResultsApp {
    //41 has an error
    public static void main(String[] args) throws IOException {

        Directory directory = new Directory("election-results/");

        //Create a list in which to store the list of constituency results
        List<ConstituencyResult> listOfConstituencyResults = new ArrayList<ConstituencyResult>();

        //loop through every file in the directory
        for (int i = 0; i < directory.getNumberOfFilesInDirectory(); i++) {

            File XmlFile = directory.getSingleFileFromDirectory(i);

            //It has to be in a list because of how the xml is laid it thinks there could be many constituency results
            List<ConstituencyResult> currentConstituencyResultAsList = directory.returnXmlFileAsPojo(XmlFile);
            //just get the first one in the list
            ConstituencyResult currentConstituencyResult = currentConstituencyResultAsList.get(0);

            //add to the list
            listOfConstituencyResults.add(currentConstituencyResult);

            //print the file
            listOfConstituencyResults.get(i).printAsTable();

            //wait 1 second
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }

        }

    }

}
