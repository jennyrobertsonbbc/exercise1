package persistance;

import domain.ConstituencyResult;
import domain.Result;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertSame;

/**
 * Created by roberj78 on 29/09/2016.
 */
public class MapRepositoryTest {
    @Test
    public void saveAndGetResultTest(){

        //make new map repository
        ResultRepository resultRepository = new MapRepository();

        //make object to put into list
        ConstituencyResult objectPutIntoList = new ConstituencyResult();
        objectPutIntoList.setConstituencyName("Aberconwy");
        objectPutIntoList.setConstituencyId(2);
        objectPutIntoList.setSeqNum(1);
        List<Result> results = new ArrayList<>();
        results.add(new Result("LAB",8994,(float)33.0));
        results.add(new Result("CON",7924,(float)29.1));
        results.add(new Result("LD",5197,(float)19.1));
        results.add(new Result("PC",3818,(float)14.0));
        results.add(new Result("OTH",517,(float)1.9));
        results.add(new Result("GRN",512,(float)1.9));
        results.add(new Result("UKIP",296,(float)1.1));

        //make another one
        //make object to put into list
        ConstituencyResult objectPutIntoList2 = new ConstituencyResult();
        objectPutIntoList.setConstituencyName("Other");
        objectPutIntoList.setConstituencyId(3);
        objectPutIntoList.setSeqNum(4);
        List<Result> results2 = new ArrayList<>();
        results2.add(new Result("LAB",8994,(float)33.0));
        results2.add(new Result("CON",7924,(float)29.1));
        results2.add(new Result("LD",5197,(float)19.1));
        results2.add(new Result("PC",3818,(float)14.0));
        results2.add(new Result("OTH",517,(float)1.9));
        results2.add(new Result("GRN",512,(float)1.9));
        results2.add(new Result("UKIP",296,(float)1.1));

        //save the object in the list
        resultRepository.saveResult(objectPutIntoList);

        //get the object back from the list
        ConstituencyResult objectInList = resultRepository.getResult(objectPutIntoList.getConstituencyId());


        //test if the object saved and gotten back from the list is the same as the one we added in.
        assertSame(objectInList,objectPutIntoList);
    }

}
