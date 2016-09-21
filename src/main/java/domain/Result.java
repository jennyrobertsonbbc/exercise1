package domain;

/**
 * Created by roberj78 on 20/09/2016.
 */
public class Result {
    @Override
    public String toString() {
        return "Result{" +
                "partyCode='" + partyCode + '\'' +
                ", votes=" + votes +
                ", share=" + share +
                '}';
    }

    private String partyCode;
    private int votes;
    private float share;

    public String getPartyCode() {
        return partyCode;
    }

    public void setPartyCode(String partyCode) {
        this.partyCode = partyCode;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public float getShare() {
        return share;
    }

    public void setShare(float share) {
        this.share = share;
    }
}
