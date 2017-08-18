package selfmadeHash;

public class TableEntry<K,V> {
    private K key;
    private V value;

    TableEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    K getKey() {
        return key;
    }

    V getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TableEntry)) return false;

        TableEntry<?, ?> that = (TableEntry<?, ?>) o;

        return getKey().equals(that.getKey()) && (getValue() != null ?
                getValue().equals(that.getValue()) : that.getValue() == null);
    }

    @Override
    public int hashCode() {
        int result = getKey().hashCode();
        result = 31 * result + (getValue() != null ? getValue().hashCode() : 0);
        return result;
    }
}
