package domain;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by roberj78 on 26/09/2016.
 */
public class ResultTest {

    @Test
    public void testToString(){
        Result result = new Result();
        result.setPartyCode("LAB");
        result.setVotes(600);
        result.setShare(50);

        String resultToString = result.toString();
        String expectedResultToString = "Result{partyCode='LAB', votes=600, share=50.0}";

        assertEquals(expectedResultToString, resultToString);

    }

}
