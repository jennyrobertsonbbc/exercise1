package workflow;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import domain.ConstituencyResult;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public String getResource(String filename) throws FileNotFoundException {

        URL resource = getClass().getClassLoader().getResource(filename);
        Objects.requireNonNull(resource);

        return resource.getFile();
    }

    public String readFileInAsString(File file) {

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

            return xmlFileAsStringBuilder.toString();


        } catch (IOException e) {
            return "";
        }


    }

    public ConstituencyResult returnXmlFileAsPojo(String xmlAsString) {

        //make a new xmlMapper object called xmlMapper
        ObjectMapper xmlMapper = new XmlMapper();

        try {
            //feed the xml file as a string and the constituency result object we want in.
            List<ConstituencyResult> constituencyResult = xmlMapper.readValue(xmlAsString, new TypeReference<List<ConstituencyResult>>() {
            });

            //return the object
            return constituencyResult.get(0);

        } catch (IOException e) {
            //return empty
            return new ConstituencyResult();
        }


    }
}
