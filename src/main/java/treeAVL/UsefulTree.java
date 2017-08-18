package treeAVL;

public interface UsefulTree<K, V> {

    boolean insert(K key, V value);

    V get(K key);

    boolean remove(K key);

}
