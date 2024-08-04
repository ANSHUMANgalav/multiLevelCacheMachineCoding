package model;

import java.util.ArrayList;
import java.util.List;

public class Cache {
    private int maxLevels;
    private int[] capacities;
    private List<SingalLevelCache> cacheList;

    public Cache(int[] capacities, int maxLevels) {
        this.capacities = capacities;
        this.maxLevels = maxLevels;
        this.cacheList = new ArrayList<>();

        addLevel();
    }

    private void addLevel() {
        if (cacheList.size() < maxLevels) {
            cacheList.add(new SingalLevelCache(capacities[cacheList.size()]));
        }
    }
    public String readFromCache(String key) {
        for (SingalLevelCache levelCache : cacheList) {
            String value = levelCache.read(key);
            if (value != null) {
                writeDeepInCache(key, value, 0); // put in first level cache.
                return value; // return value if fund
            }
        }
        return null; // if not found
    }


    public void write(String key, String value) {
        writeDeepInCache(key, value,0);
    }

    public void delete(String key) {
        for (SingalLevelCache level : cacheList) {
            level.delete(key);
        }
    }

    private void writeDeepInCache(String key, String value, int index) {
        if (index >= cacheList.size()) {
            if (cacheList.size() < maxLevels) {
                addLevel();
            } else {
                return; // should throw error (Maybe) !!
            }
        }

        SingalLevelCache currentLevel = cacheList.get(index);

        if (currentLevel.getCurrCache().size() < capacities[index] || currentLevel.containsKey(key)) {
            currentLevel.write(key, value);
        } else {
            String outKey = currentLevel.getLRUKey(key);
            String outValue = currentLevel.getCurrCache().get(outKey);
            currentLevel.delete(outKey);
            currentLevel.write(key, value);
            writeDeepInCache(outKey, outValue, index+1);
        }
    }

}
