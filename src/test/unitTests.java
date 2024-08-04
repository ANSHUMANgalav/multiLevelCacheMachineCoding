package test;
import model.Cache;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class unitTests {
    @Test
    public void testwriteAndRead() {
        Cache cache = new Cache(new int[]{3,3,3},3);
        cache.write("abc","ABC");
        cache.write("pqr","PQR");
        cache.write("xyz","XYZ");

        assertEquals("ABC", cache.readFromCache("abc"));
        assertEquals("PQR", cache.readFromCache("pqr"));
        assertEquals("XYZ", cache.readFromCache("xyz"));
    }

    @Test
    public void testRemoval() {
        Cache cache = new Cache(new int[]{1,3,3},3);
        cache.write("abc","ABC");
        cache.write("pqr","PQR");
        cache.write("xyz","XYZ");

        cache.delete("abc");
        assertNull(cache.readFromCache("abc"));
    }

}
