package domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by roberj78 on 26/09/2016.
 */
public class ConstituencyResultTest {
    @Test
    public void TestPrintAsTable(){


        String expectedPrintAsTable = "\nAberconwy1\n" +
                "\n" +
                "|Party|Votes|Share|\n" +
                "|LAB|8994|33.0|\n" +
                "|CON|7924|29.1|\n" +
                "|LD|5197|19.1|\n" +
                "|PC|3818|14.0|\n" +
                "|OTH|517|1.9|\n" +
                "|GRN|512|1.9|\n" +
                "|UKIP|296|1.1|\n";


        //add the values to the test object
        ConstituencyResult constituencyResult = new ConstituencyResult();
        constituencyResult.setConstituencyName("Aberconwy");
        constituencyResult.setSeqNum(1);

        //create a list of results to add to the test object
        List<Result> results = new ArrayList<>();

        results.add(new Result("LAB",8994,(float)33.0));
        results.add(new Result("CON",7924,(float)29.1));
        results.add(new Result("LD",5197,(float)19.1));
        results.add(new Result("PC",3818,(float)14.0));
        results.add(new Result("OTH",517,(float)1.9));
        results.add(new Result("GRN",512,(float)1.9));
        results.add(new Result("UKIP",296,(float)1.1));



        constituencyResult.setResults(results);


        assertEquals(expectedPrintAsTable,constituencyResult.printAsTable());

    }
}
