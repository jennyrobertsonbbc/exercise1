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

            File xmlFile = directory.getSingleFileFromDirectory(i);

            String fileAsString = directory.readFileInAsString(xmlFile);

            ConstituencyResult currentConstituencyResult = directory.returnXmlFileAsPojo(fileAsString);


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
