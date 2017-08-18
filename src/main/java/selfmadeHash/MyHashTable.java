package selfmadeHash;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyHashTable<K, V> implements SelfmadeHashContract<K, V> {
    private int capacity = 16;
    private float loadFactor = 0.7f;
    private int recordsN;
    private ArrayList<Basked<K, V>> selfMadeTable = new ArrayList<>(capacity);

    public MyHashTable() {
        buildMe();
    }

    public MyHashTable(int capacity) {
        this.capacity = capacity;
        buildMe();
    }

    private void buildMe() {
        for (int i = 0; i < capacity; i++) {
            selfMadeTable.add(new Basked<>());
        }
    }

    @Override
    public boolean put(K key, V value) {
        recordsN++;
        if (recordsN < capacity * loadFactor) {
            int baskedNumber = key.hashCode() % capacity;
            if (baskedNumber < 0) baskedNumber = capacity + baskedNumber;
            return selfMadeTable.get(baskedNumber).insert(key, value);
        } else {
            MyHashTable<K, V> newHashTable = new MyHashTable<>(2 * capacity);
            for (TableEntry<K, V> entery : this.getAllEntry()) {
                newHashTable.put(entery.getKey(), entery.getValue());
            }
            this.selfMadeTable = newHashTable.selfMadeTable;
            this.capacity = newHashTable.capacity;
            return false;

        }
    }

    @Override
    public V take(K key) {
        int baskedNumber = key.hashCode() % capacity;
        if (baskedNumber < 0) baskedNumber = capacity + baskedNumber;
        return selfMadeTable.get(baskedNumber).getByKey(key);
    }

    @Override
    public boolean delete(K key) {
        int baskedNumber = key.hashCode() % capacity;
        if (baskedNumber < 0) baskedNumber = capacity + baskedNumber;
        return selfMadeTable.get(baskedNumber).remove(key);
    }

    LinkedList<TableEntry<K, V>> getAllEntry() {
        LinkedList<TableEntry<K, V>> listOfAll = new LinkedList<>();
        for (Basked<K, V> basked : this.selfMadeTable) {
            listOfAll.addAll(basked.getAll());
        }
        return listOfAll;
    }

    public boolean wherePut(K key, V value) {
        recordsN++;
        if (recordsN < capacity * loadFactor) {
            int baskedNumber = key.hashCode() % capacity;
            if (baskedNumber < 0) baskedNumber = capacity + baskedNumber;
            System.out.println(key + "\t\t put to \t" + baskedNumber + "\t box, hash \t" + key.hashCode());
            return selfMadeTable.get(baskedNumber).insert(key, value);
        } else {
            System.out.println("---------   rebuild    -----------");
            MyHashTable<K, V> newHashTable = new MyHashTable<>(2 * capacity);
            for (TableEntry<K, V> entery : this.getAllEntry()) {
                newHashTable.wherePut(entery.getKey(), entery.getValue());
            }
            this.selfMadeTable = newHashTable.selfMadeTable;
            this.capacity = newHashTable.capacity;
            return false;

        }
    }
}
