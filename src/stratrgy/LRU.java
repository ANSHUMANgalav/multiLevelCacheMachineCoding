package stratrgy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRU { // LRU using hashmap for values and linkedList for checking latset.
    private  int capacity;
    private Map<String, String> map;
    private LinkedList<String> recentList;

    public LRU(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<String, String>();
        this.recentList = new LinkedList<String>();
    }

    public boolean containsKey(String key){
        return map.containsKey(key);
    }

    public String getValForKey(String key){
        if(!map.containsKey(key)){
            return null; // not present in this level
        }
        recentList.remove(key);
        recentList.addFirst(key); // now it's most recent
        return map.get(key);
    }

    public void putKeyVal(String key, String value){
        if(map.size() == capacity){
            String old = recentList.removeLast(); // remove last item
            map.remove(old);
        }
        map.put(key, value);
        recentList.remove(key);
        recentList.addFirst(key);
    }

    public void removeKeyVal(String key) {
        map.remove(key);
        recentList.remove(key);
    }

    public Map<String, String> getCurrCache(){
        return map;
    }

    public String getLRUKey(){
        return recentList.getLast();
    }


}
