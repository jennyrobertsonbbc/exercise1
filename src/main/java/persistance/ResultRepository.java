package persistance;

import domain.ConstituencyResult;

/**
 * Created by roberj78 on 29/09/2016.
 */
public interface ResultRepository {

    boolean saveResult(ConstituencyResult constituencyResult);

    ConstituencyResult getResult(int constituencyID);
}
