package domain;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

/**
 * Created by roberj78 on 20/09/2016.
 */

//@JacksonXmlRootElement
public class ConstituencyResult {

    @JacksonXmlProperty(localName = "constituencyName")
    private String constituencyName;
    @JacksonXmlProperty(localName = "consituencyId")//spelt wrong in xml :(
    private int constituencyId;
    @JacksonXmlProperty(isAttribute = true)
    private int seqNo;

    private List<Result> results;

    @Override
    public String toString() {
        return "ConstituencyResult{" +
                "constituencyName='" + constituencyName + '\'' +
                ", constituencyId=" + constituencyId +
                ", seqNum=" + seqNo +
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