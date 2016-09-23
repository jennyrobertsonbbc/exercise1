import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import domain.ConstituencyResult;
//https://github.com/FasterXML/jackson-dataformat-xml
import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Hello {


    public static void main(String[] args) throws IOException {

        //Create an instance of this class
        Hello obj = new Hello();

        //Create a list in which to store the list of constituency results
        List<ConstituencyResult> listOfConstituencyResults = new ArrayList<ConstituencyResult>();

        //loop through every file in the directory
        for (int i = 0; i < obj.getNumberOfFilesInDirectory(obj.getDirectoryAsFile("election-results/")); i++) {

            //turn file into POJO and add it to list
            listOfConstituencyResults.add(obj.returnXmlFileAsPojo(obj.getSingleFileFromDirectory("election-results/", i)).get(0));

            //print the file
            listOfConstituencyResults.get(i).printAsTable();

            //wait 1 second
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

        }

        //print each object in the list as a table
        for (ConstituencyResult result : listOfConstituencyResults) {
            result.printAsTable();
        }


    }


    public File getSingleFileFromDirectory(String directory, int index) {
        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File directoryFile = new File(classLoader.getResource(directory).getFile());


        File[] files = directoryFile.listFiles();

        return files[index];
    }

    public File getDirectoryAsFile(String directory) {
        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File directoryFile = new File(classLoader.getResource(directory).getFile());

        return directoryFile;
    }

    public long getNumberOfFilesInDirectory(File directory) {
        return directory.listFiles().length;
    }

    public List<ConstituencyResult> returnXmlFileAsPojo(File file) {

        try {


            //stream of raw bites
            InputStream initialStream = new FileInputStream(file);
            //wrap around, decide on format
            InputStreamReader reader = new InputStreamReader(initialStream);

            //make a buffer object for use later. A buffered reader reads it in bit by bit using a buffer instead of all at once.
            BufferedReader bufferedReader = new BufferedReader(reader);

            //String to hold each line.
            String lineOfFile = null;

            //Create string builder object to make the string
            StringBuilder xmlFileAsStringBuilder = new StringBuilder();


            do {
                //save the line of the file as 'LineOfFile'
                lineOfFile = bufferedReader.readLine();
                //append the line to the string builder string
                xmlFileAsStringBuilder.append(lineOfFile);
            }
            while (lineOfFile != null);


            //stop reading the file
            bufferedReader.close();

            //make a new xmlMapper object called xmlMapper
            ObjectMapper xmlMapper = new XmlMapper();


            //make a list to hold constituencyResult
            //which takes in the parameters: the xml file contents (as a string) and the constituency list?.

            List<ConstituencyResult> myResults = xmlMapper.readValue(xmlFileAsStringBuilder.toString(), new TypeReference<List<ConstituencyResult>>() {
            });

            return myResults;

            //the object 'my result' now has the values from the xml inside its properties


        } catch (IOException e) {
            //return empty list
            return new ArrayList<ConstituencyResult>();
        }


    }


}
