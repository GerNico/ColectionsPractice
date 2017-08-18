package treeAVL;

class TreeNode<K extends Comparable<K>, V> {

    private K key;
    private V value;
    TreeNode<K, V> left;
    TreeNode<K, V> right;
    TreeNode<K, V> parent;

    private int balance;
    private int height;

    TreeNode(K key, V value, TreeNode<K, V> parent) {
        this.key = key;
        this.value = value;
        this.parent = parent;
        this.left = null;
        this.right = null;
        height = 0;
    }

    int getBalance() {
        return balance;
    }

    void setBalance(int balance) {
        this.balance = balance;
    }

    int getHeight() {
        return height;
    }

    void setHeight(int height) {
        this.height = height;
    }

    K getKey() {
        return key;
    }

    V getValue() {
        return value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }
}

