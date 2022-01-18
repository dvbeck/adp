package nl.han.adp.datastructures.hashtable;

public interface Dictionary<K extends Comparable<K>, V> {

    /** Reinitialize dictionary */
    public void clear();

    /** Insert a record
     @param key The key for the record being inserted.
     @param elem The record being inserted. */
    public void put(K key, V elem);

    /** Remove and return a record.
     @param key The key of the record to be removed.
     @return A maching record. If multiple records match
     "k", remove an arbitrary one. Return null if no record
     with key "k" exists. */
    public V remove(K key);

    /** Remove and return an arbitrary record from dictionary.
     @return the record removed, or null if none exists. */
    public V removeAny();

    /** @return A record matching "k" (null if none exists).
    If multiple records match, return an arbitrary one.
     @param key The key of the record to find */
    public V get(K key);

    /** @return The number of records in the dictionary. */
    public int size();
}