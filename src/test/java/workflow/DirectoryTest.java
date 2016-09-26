package workflow;

import domain.ConstituencyResult;
import domain.Result;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;


/**
 * Created by roberj78 on 26/09/2016.
 */
public class DirectoryTest {

    @Test
    public void returnXmlFileAsPojo(){



        Directory directory = new Directory("election-results/result001.xml");

        //add the values to the test object
        ConstituencyResult expectedPojo = new ConstituencyResult();
        expectedPojo.setConstituencyName("Aberconwy");
        expectedPojo.setSeqNum(1);

        //create a list of results to add to the test object
        List<Result> results = new ArrayList<>();

        results.add(new Result("LAB",8994,(float)33.0));
        results.add(new Result("CON",7924,(float)29.1));
        results.add(new Result("LD",5197,(float)19.1));
        results.add(new Result("PC",3818,(float)14.0));
        results.add(new Result("OTH",517,(float)1.9));
        results.add(new Result("GRN",512,(float)1.9));
        results.add(new Result("UKIP",296,(float)1.1));

        //add the results to the object
        expectedPojo.setResults(results);

        File xmlFile = directory.getSingleFileFromDirectory(0);

        //test if the same
        assertEquals(directory.returnXmlFileAsPojo(xmlFile).get(0),expectedPojo);



    }


}
