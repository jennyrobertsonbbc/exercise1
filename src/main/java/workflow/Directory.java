package workflow;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import domain.ConstituencyResult;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by roberj78 on 26/09/2016.
 */
public class Directory {

    private String directoryString;

    public Directory(String directory) {
        this.directoryString = directory;
    }


    public File getSingleFileFromDirectory(int index) {
        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File directoryFile = new File(classLoader.getResource(directoryString).getFile());


        File[] files = directoryFile.listFiles();

        return files[index];
    }


    public long getNumberOfFilesInDirectory() {

        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File directoryFile = new File(classLoader.getResource(directoryString).getFile());

        return directoryFile.listFiles().length;
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
