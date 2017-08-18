package selfmadeHash;

public interface SelfmadeHashContract<K,V> {
    boolean delete(K key);
    boolean put(K key,V value);
    V take(K key);
}
