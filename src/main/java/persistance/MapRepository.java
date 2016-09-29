package persistance;

import domain.ConstituencyResult;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by roberj78 on 29/09/2016.
 */
public class MapRepository implements ResultRepository{

    private final Map <Integer,ConstituencyResult> constituencyResultMap;

    public MapRepository() {
        constituencyResultMap = new ConcurrentHashMap<>();


    }

    @Override
    public boolean saveResult(ConstituencyResult constituencyResult) {

        constituencyResultMap.put(constituencyResult.getConstituencyId(),constituencyResult);

        return true;
    }

    @Override
    public ConstituencyResult getResult(int constituencyID) {

        ConstituencyResult constituencyResult = constituencyResultMap.get(constituencyID);
        return constituencyResult;
    }
}
