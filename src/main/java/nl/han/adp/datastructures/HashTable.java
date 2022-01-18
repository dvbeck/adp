package nl.han.adp.datastructures;

import nl.han.adp.datastructures.hashtable.Dictionary;

public class HashTable<K extends Comparable<K>, V> implements Dictionary<K, V> {
    private static final int DEFAULT_SIZE = 10000;
    private final int size;

    private HashEntry<K, V>[] elements;
    private int numberOfElements;

    public HashTable() {
        this(DEFAULT_SIZE);
    }

    public HashTable(int size) {
        this.size = size;
        allocateSpace();
    }

    @SuppressWarnings("unchecked")
    private void allocateSpace() {
        elements = new HashEntry[size];
        numberOfElements = 0;
    }

    @Override
    public void clear() {
        allocateSpace();
    }

    @Override
    public void put(K key, V value) {
        int pos = getIndex(key);
        if (elements[pos] == null) {
            elements[pos] = new HashEntry<>(key, value);
        } else {
            var next = elements[pos];
            while (next.next != null && next.key.compareTo(key) != 0)
                next = next.next;
            if (next.key.compareTo(key) == 0) next.value = value;
            else next.next = new HashEntry<>(key, value);
        }

        numberOfElements++;
    }

    @Override
    public V get(K key) {
        int pos = getIndex(key);

        var next = elements[pos];
        while (next != null && next.key.compareTo(key) != 0)
            next = next.next;

        if (next == null) return null;
        else return next.value;
    }

    @Override
    public int size() {
        return numberOfElements;
    }

    @Override
    public V remove(K key) {
        int pos = getIndex(key);
        HashEntry<K, V> prev = null;
        var current = elements[pos];
        while (current != null && current.key.compareTo(key) != 0) {
            prev = current;
            current = current.next;
        }

        if (current == null) return null;

        if (prev == null && current.next == null) {
            elements[pos] = null;
        } else if (prev == null && current.next != null) {
            elements[pos] = current.next;
        } else if (prev != null) {
            prev.next = current.next;
        }
        numberOfElements--;
        return current.value;
    }

    @Override
    public V removeAny() {
        HashEntry<K, V> found = null;
        for(int i = 0; i < elements.length; i++) {
            if(elements[i] != null) {
                found = elements[i];
                elements[i] = found.next;
                numberOfElements--;
                return found.value;
            }
        }
        return null;
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % size;
    }

    private static class HashEntry<K extends Comparable<K>, V> {
        K key;
        V value;
        HashEntry<K, V> next;

        public HashEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}