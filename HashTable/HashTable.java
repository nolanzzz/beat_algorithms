package DataStructures.HashTable;/*
- Spell checkers
- Dictionaries
- Compilers

Collision:
- Chaining (linkedlist)
- Open Addressing
    - linear probing
    - quadratic probing
    - double hashing
 */

import java.util.LinkedList;

public class HashTable {
    private class Entry {
        private int key;
        private String value;
        private Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }
    private LinkedList<Entry>[] entries;
    public HashTable() {
        entries = new LinkedList[10];
    }
    private int hash(int key) {
        return Math.abs(key) % entries.length;
    }
    public void put(int key, String value) {
        int index = hash(key);
        if (entries[index] == null) {
            entries[index] = new LinkedList<>();
        }
        for (Entry entry : entries[index]) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }
        entries[index].add(new Entry(key, value));
    }
    public String get(int key) {
        int index = hash(key);
        if (entries[index] != null) {
            for (Entry entry : entries[index]) {
                if (entry.key == key) {
                    return entry.value;
                }
            }
        }
        return null;
    }
    public void remove(int key) {
        int index = hash(key);
        if (entries[index] == null) {
            throw new IllegalStateException();
        }
        for (Entry entry : entries[index]) {
            if (entry.key == key) {
                entries[index].remove(entry);
                return;
            }
        }
        throw new IllegalStateException();
    }
}
