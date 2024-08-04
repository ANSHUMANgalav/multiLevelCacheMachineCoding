package model;

import stratrgy.LRU;

import java.util.Map;

public class SingalLevelCache {
    private int capacity;
    private  LRU cache; // can have different type of cache.

    public SingalLevelCache(int capacity) {
        this.capacity = capacity;
        cache = new LRU(capacity);
    }

    public String read(String key) {
        return cache.getValForKey(key);
    }

    public void write(String key, String value) {
        cache.putKeyVal(key, value);
    }

    public void delete(String key) {
        cache.removeKeyVal(key);
    }

    public boolean containsKey(String key) {
        return cache.containsKey(key);
    }

    public Map<String, String> getCurrCache(){
        return cache.getCurrCache();
    }

    public String getLRUKey(String key) { // Maybe not a good idea ,if we want to change cache policy...
        return cache.getLRUKey();
    }
}
