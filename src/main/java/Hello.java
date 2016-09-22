import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import domain.ConstituencyResult;
//https://github.com/FasterXML/jackson-dataformat-xml
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hello {
    public static void main(String[] args) throws IOException {

        //create an instance of this class
        Hello obj = new Hello();

        //for every file in the election results directory
        for (File file : obj.getFilesInDirectory("election-results/").listFiles()) {
            //turn it into a pojo and print out
            System.out.println(obj.returnXmlFileAsPojo(file));
        }


    }

    public File getFilesInDirectory(String directory) {
        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File directoryFile = new File(classLoader.getResource(directory).getFile());

        return directoryFile;
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
                //Print it out
//                if(lineOfFile != null) {
//                    System.out.println(lineOfFile);
//                }
                //append the line to the string builder string
                xmlFileAsStringBuilder.append(lineOfFile);
            }
            while (lineOfFile != null);


            //stop reading the file
            bufferedReader.close();

            //make a new xmlMapper object called xmlMapper
            ObjectMapper xmlMapper = new XmlMapper();


            //make a list to hold constituencyResult
            //its contents are filled by using the xmlMapper object's readValue method...
            //which takes in the parameters: the xml file contents (as a string) and the constituency list?.

            List<ConstituencyResult> myResults = xmlMapper.readValue(xmlFileAsStringBuilder.toString(), new TypeReference<List<ConstituencyResult>>() {
            });

            return myResults;

            //the object 'my result' now has the values from the xml inside its properties

            //TEST



        } catch (IOException e) {
            //return empty list
            return new ArrayList<ConstituencyResult>();
        }



    }


}
