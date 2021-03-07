package ex1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.provider.CsvSource;

class HashTableTest {

    @org.junit.jupiter.api.Test
    @CsvSource({"20", "30", "40", "500"})
    void count(int inserts) {
        HashTable hashTable = new HashTable();
        for (int i = 0; i < inserts; i++) {
            hashTable.put(String.valueOf(inserts), String.valueOf(inserts));
        }
        Assertions.assertEquals(inserts, hashTable.count());
    }

    @org.junit.jupiter.api.Test
    void size() {
        HashTable hashTable = new HashTable();
        Assertions.assertEquals(16, hashTable.size());
    }

    @org.junit.jupiter.api.Test
    @CsvSource({"a,1", "b,2", "c.2"})
    void put(String value, String key) {
        HashTable hashTable = new HashTable();
        for (String key1 : hashTable.getCollisionsForKey(key, 5)) {
            hashTable.put(key1, value);
            Assertions.assertEquals(value, hashTable.get(key1));
        }
    }

    @org.junit.jupiter.api.Test
    void get() {
        String value = "a";
        String key = "1";
        HashTable hashTable = new HashTable();
        hashTable.put(key,value);
        Assertions.assertEquals(value, hashTable.get(key));
    }

    @org.junit.jupiter.api.Test
    void drop(String value, String key) {
        HashTable hashTable = new HashTable();
        for (String key1 : hashTable.getCollisionsForKey(key, 5)) {
            hashTable.put(key1, value);
            hashTable.drop(key1);
            Assertions.assertEquals(null, hashTable.get(key1));
        }

    }

}