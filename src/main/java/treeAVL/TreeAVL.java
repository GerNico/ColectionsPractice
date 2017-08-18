package treeAVL;

public class TreeAVL<K extends Comparable<K>, V> {
    private TreeNode<K, V> root;

    public boolean insert(K key, V value) {
        if (root == null)
            root = new TreeNode<>(key, value, null);
        else {
            TreeNode<K, V> n = root;
            TreeNode<K, V> parent;
            while (true) {
                if (n.getKey() == key)
                    return false;

                parent = n;

                boolean goLeft = (n.getKey().compareTo(key) > 0);
                n = goLeft ? n.left : n.right;

                if (n == null) {
                    if (goLeft) {
                        parent.left = new TreeNode<>(key, value, parent);
                    } else {
                        parent.right = new TreeNode<>(key, value, parent);
                    }
                    rebalance(parent);
                    break;
                }
            }
        }
        return true;
    }


    public V get(K key) {
        TreeNode<K, V> current = this.root;
        while (current != null) {
            if (current.getKey().equals(key)) return current.getValue();
            if (current.getKey().compareTo(key) > 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    TreeNode<K, V> minimumElement(TreeNode<K, V> root) {
        if (root.left == null)
            return root;
        else {
            return minimumElement(root.left);
        }
    }

    private boolean remove(TreeNode<K, V> root, TreeNode<K, V> node) {
        while (root != null) {
            if (root.getKey().equals(node.getKey())) {
                root = null;
                return true;
            }
            if (root.getKey().compareTo(node.getKey()) > 0) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return false;
    }

    public boolean remove(K key) {
        TreeNode<K, V> current = this.root;
        while (current != null) {
            if (current.getKey().equals(key)) {
                if (current.left != null && current.right != null) {
                    TreeNode<K, V> minNodeForRight = minimumElement(current.right);
                    current.setKey(minNodeForRight.getKey());
                    current.setValue(minNodeForRight.getValue());
                    if (minNodeForRight.parent.left == minNodeForRight) minNodeForRight.parent.left = null;
                    if (minNodeForRight.parent.right == minNodeForRight) minNodeForRight.parent.right = null;
                    minNodeForRight = null;
                    rebalance(current.parent);
                } else if (current.left != null) {
                    current = current.left;
                } else if (current.right != null) {
                    current = current.right;
                } else {
                    if (current.parent.left == current) current.parent.left = null;
                    if (current.parent.right == current) current.parent.right = null;
                    current = null;
                }
            }
            if (current != null) if (current.getKey().compareTo(key) > 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

    private void rebalance(TreeNode<K, V> n) {
        setBalance(n);

        if (n.getBalance() == -2) {
            if (height(n.left.left) >= height(n.left.right))
                n = rotateRight(n);
            else
                n = rotateLeftThenRight(n);

        } else if (n.getBalance() == 2) {
            if (height(n.right.right) >= height(n.right.left))
                n = rotateLeft(n);
            else
                n = rotateRightThenLeft(n);
        }

        if (n.parent != null) {
            rebalance(n.parent);
        } else {
            root = n;
        }
    }

    private TreeNode<K, V> rotateLeft(TreeNode<K, V> a) {

        TreeNode<K, V> b = a.right;
        b.parent = a.parent;

        a.right = b.left;

        if (a.right != null)
            a.right.parent = a;

        b.left = a;
        a.parent = b;

        if (b.parent != null) {
            if (b.parent.right == a) {
                b.parent.right = b;
            } else {
                b.parent.left = b;
            }
        }

        setBalance(a, b);

        return b;
    }

    private TreeNode<K, V> rotateRight(TreeNode<K, V> a) {

        TreeNode<K, V> b = a.left;
        b.parent = a.parent;

        a.left = b.right;

        if (a.left != null)
            a.left.parent = a;

        b.right = a;
        a.parent = b;

        if (b.parent != null) {
            if (b.parent.right == a) {
                b.parent.right = b;
            } else {
                b.parent.left = b;
            }
        }

        setBalance(a, b);

        return b;
    }

    private TreeNode<K, V> rotateLeftThenRight(TreeNode<K, V> n) {
        n.left = rotateLeft(n.left);
        return rotateRight(n);
    }

    private TreeNode<K, V> rotateRightThenLeft(TreeNode<K, V> n) {
        n.right = rotateRight(n.right);
        return rotateLeft(n);
    }

    private int height(TreeNode<K, V> n) {
        if (n == null)
            return -1;
        return n.getHeight();
    }

    @SafeVarargs
    private final void setBalance(TreeNode<K, V>... nodes) {
        for (TreeNode<K, V> n : nodes) {
            reheight(n);
            n.setBalance(height(n.right) - height(n.left));
        }
    }

    public void printBalance() {
        printBalance(root);
    }

    private void printBalance(TreeNode<K, V> n) {
        if (n != null) {
            printBalance(n.left);
            System.out.printf("%s ", n.getBalance());
            printBalance(n.right);
        }
    }

    private void reheight(TreeNode<K, V> node) {
        if (node != null) {
            node.setHeight(1 + Math.max(height(node.left), height(node.right)));
        }
    }
}
