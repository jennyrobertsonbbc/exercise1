package workflow;

import domain.ConstituencyResult;
import domain.Result;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertSame;


/**
 * Created by roberj78 on 26/09/2016.
 */
public class DirectoryTest {

    @Test
    public void returnXmlFileAsPojo(){

        String xmlFile = "<constituencyResults> <constituencyResult seqNo=\"1\"> <consituencyId>2</consituencyId> <constituencyName>Aberconwy</constituencyName> <results> <result> <partyCode>LAB</partyCode> <votes>8994</votes> <share>33.00</share> </result> <result> <partyCode>CON</partyCode> <votes>7924</votes> <share>29.10</share> </result> <result> <partyCode>LD</partyCode> <votes>5197</votes> <share>19.10</share> </result> <result> <partyCode>PC</partyCode> <votes>3818</votes> <share>14.00</share> </result> <result> <partyCode>OTH</partyCode> <votes>517</votes> <share>1.90</share> </result> <result> <partyCode>GRN</partyCode> <votes>512</votes> <share>1.90</share> </result> <result> <partyCode>UKIP</partyCode> <votes>296</votes> <share>1.10</share> </result> </results> </constituencyResult> </constituencyResults> ";



        Directory directory = new Directory("election-results/result001.xml");

        //add the values to the test object
        ConstituencyResult expectedPojo = new ConstituencyResult();
        expectedPojo.setConstituencyName("Aberconwy");
        expectedPojo.setConstituencyId(2);
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

        ConstituencyResult theResult = directory.returnXmlFileAsPojo(xmlFile);


        //test if the same
        assertEquals(theResult,expectedPojo);






    }


}
