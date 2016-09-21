package domain;


import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * Created by roberj78 on 21/09/2016.
 */

public class ConstituencyResults {

    @JacksonXmlElementWrapper(localName = "constituencyResults")

    @JacksonXmlProperty(localName = "constituencyResult")
    private List<ConstituencyResult> constituencyResults;

    public List<ConstituencyResult> getConstituencyResults() {
        return constituencyResults;
    }

    public void setConstituencyResults(List<ConstituencyResult> constituencyResults) {
        this.constituencyResults = constituencyResults;
    }

    @Override
    public String toString() {
        return "ConstituencyResults{" +
                "constituencyResults=" + constituencyResults +
                '}';
    }
}
