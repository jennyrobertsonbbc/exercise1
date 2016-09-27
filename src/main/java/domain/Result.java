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

    public Result(String partyCode, int votes, float share) {
        this.partyCode = partyCode;
        this.votes = votes;
        this.share = share;
    }

    //no arg constuctor for jackson to use
    public Result(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Result result = (Result) o;

        if (votes != result.votes) return false;
        if (Float.compare(result.share, share) != 0) return false;
        return partyCode != null ? partyCode.equals(result.partyCode) : result.partyCode == null;

    }

    @Override
    public int hashCode() {
        int result = partyCode != null ? partyCode.hashCode() : 0;
        result = 31 * result + votes;
        result = 31 * result + (share != +0.0f ? Float.floatToIntBits(share) : 0);
        return result;
    }
}
