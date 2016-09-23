package domain;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;


//@JacksonXmlRootElement
public class ConstituencyResult {


    @JacksonXmlProperty(localName = "constituencyName")
    private String constituencyName;
    @JacksonXmlProperty(localName = "consituencyId")//spelt wrong in xml :(
    private int constituencyId;
    @JacksonXmlProperty(isAttribute = true)
    private int seqNo;

    private List<Result> results;

    public void printAsTable() {
        //print out the heading
        System.out.println("\n" + constituencyName + "\n\n|Party|Votes|Share|");

        //loop through each result object and print it
        for (Result result : results)
            System.out.println(
                    "|" + result.getPartyCode() + "|"
                            + result.getVotes() + "|"
                            + result.getShare() + "|"

            );
        System.out.println("\n");
    }

    @Override
    public String toString() {
        return "ConstituencyResult{" +
                "constituencyName='" + constituencyName + '\'' +
                ", constituencyId=" + constituencyId +
                ", seqNo=" + seqNo +
                ", results=" + results +
                '}';
    }

    public String getConstituencyName() {
        return constituencyName;
    }

    public void setConstituencyName(String constituencyName) {
        this.constituencyName = constituencyName;
    }

    public int getConstituencyId() {
        return constituencyId;
    }

    public void setConstituencyId(int constituencyId) {
        this.constituencyId = constituencyId;
    }

    public int getSeqNum() {
        return seqNo;
    }

    public void setSeqNum(int seqNum) {
        this.seqNo = seqNum;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
