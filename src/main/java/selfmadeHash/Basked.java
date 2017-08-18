package selfmadeHash;

import java.util.Iterator;
import java.util.LinkedList;

public class Basked<K, V> {
    private LinkedList<TableEntry<K, V>> listOfEntry = new LinkedList<>();

    public V getByKey(K key) {
        TableEntry<K, V> currentEntry;
        for (TableEntry<K, V> aListOfEntry : listOfEntry) {
            currentEntry = aListOfEntry;
            if (currentEntry.getKey().equals(key)) return currentEntry.getValue();
        }
        return null;
    }

    public boolean insert(K key, V value) {
        TableEntry<K, V> entry = new TableEntry<>(key, value);
        for (TableEntry<K, V> some : listOfEntry) {
            if (some.getKey().equals(key)) return false;
        }
        if (key != null) {
            listOfEntry.add(entry);
            return true;
        }
        return false;
    }

    public boolean remove(K key) {
        Iterator<TableEntry<K, V>> iterator = listOfEntry.iterator();
        TableEntry<K, V> current;
        while (iterator.hasNext()) {
            current = iterator.next();
            if (current.getKey().equals(key)) iterator.remove();
        }
        return true;
    }

    public LinkedList<TableEntry<K, V>> getAll() {
        return listOfEntry;
    }
}
