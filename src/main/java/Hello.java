import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import domain.ConstituencyResult;
import domain.ConstituencyResults;
//https://github.com/FasterXML/jackson-dataformat-xml
import java.io.*;
import java.util.List;

/**
 * Created by roberj78 on 20/09/2016.
 */
public class Hello {
    public static void main(String[] args)
    throws IOException
    {
        System.out.println("hello jenny");


        //stream of raw bites
        InputStream initialStream = new FileInputStream(new File("/Users/roberj78/dev/source/exercise1/src/main/resources/election-results/result071.xml"));
        //wrap around, decide on format
        InputStreamReader reader = new InputStreamReader(initialStream);

        //make a buffer object for use later. A buffered reader reads it in bit by bit using a buffer instead of all at once.
        BufferedReader bufferedReader = new BufferedReader(reader);

        //String to hold each line.
        String lineOfFile = null;

        //Create string builder object to make the string
        StringBuilder xmlFileAsStringBuilder = new StringBuilder();


        do{
            //save the line of the file as 'LineOfFile'
            lineOfFile = bufferedReader.readLine();
            //Print it out
            System.out.println(lineOfFile);
            //append the line to the string builder string
            xmlFileAsStringBuilder.append(lineOfFile);
        }
        while(lineOfFile != null);


        //stop reading the file
        bufferedReader.close();

        //make a new xmlMapper object called xmlMapper
        ObjectMapper xmlMapper = new XmlMapper();

        //make a new constituency result object...
        //its contents are filled by using the xmlMapper object's readValue method...
        //which takes in the parameters: the xml file contents (as a string) and the constitucency class.
        List<ConstituencyResult> myResults = xmlMapper.readValue(xmlFileAsStringBuilder.toString(), new TypeReference<List <ConstituencyResult>>(){});

        //the object 'my result' now has the values from the xml inside its properties

        System.out.println(myResults.toString());

    }

}
