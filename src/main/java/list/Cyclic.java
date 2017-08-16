package list;

public interface Cyclic<T> {
    void addLast(T value);

    T get(int index);

    void setStartOnIndex(int n);

    public void remove(int n);
}
