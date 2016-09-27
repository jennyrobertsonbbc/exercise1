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

    public String printAsTable() {
        //print out the heading

        StringBuilder printedTable = new StringBuilder();

        printedTable.append("\n" + constituencyName + seqNo + "\n\n|Party|Votes|Share|");

        //loop through each result object and print it
        for (Result result : results)
            printedTable.append(
                    "\n|" + result.getPartyCode() + "|"
                            + result.getVotes() + "|"
                            + result.getShare() + "|"

            );

        printedTable.append("\n");
        System.out.println(printedTable.toString());
        return printedTable.toString();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConstituencyResult that = (ConstituencyResult) o;

        if (constituencyId != that.constituencyId) return false;
        if (seqNo != that.seqNo) return false;
        if (constituencyName != null ? !constituencyName.equals(that.constituencyName) : that.constituencyName != null)
            return false;
        return results != null ? results.equals(that.results) : that.results == null;

    }

    @Override
    public int hashCode() {
        int result = constituencyName != null ? constituencyName.hashCode() : 0;
        result = 31 * result + constituencyId;
        result = 31 * result + seqNo;
        result = 31 * result + (results != null ? results.hashCode() : 0);
        return result;
    }
}
