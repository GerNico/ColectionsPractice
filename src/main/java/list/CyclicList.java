package list;

class CyclicList<T> implements Cyclic<T> {
    private ListNode<T> firstNode;
    private ListNode<T> lastNode;
    private int length;

    CyclicList(T value) {
        ListNode<T> inserting = new ListNode<>(value);
        this.firstNode = inserting;
        this.lastNode = inserting;
        this.length = 1;
    }

    @Override
    public void addLast(T value) {
        if (length == 0) {
            ListNode<T> insertingNode = new ListNode<>(value);
            this.firstNode = insertingNode;
            this.lastNode = insertingNode;
            this.length = 1;
        } else {
            ListNode<T> insertingNode = new ListNode<>(value, lastNode, firstNode);
            this.lastNode.setNextNode(insertingNode);
            this.lastNode = insertingNode;
            this.firstNode.setPreviousNode(insertingNode);
            this.length++;
        }
    }

    @Override
    public T get(int index) {
        int realIndex = index % length;
        if (realIndex < 0) realIndex = length + realIndex;
        ListNode<T> currentNode;
        if (realIndex <= length / 2) {
            currentNode = this.firstNode;
            for (int j = 0; j < realIndex; j++) {
                currentNode = currentNode.getNextNode();
            }
        } else {
            currentNode = this.lastNode;
            for (int j = length - 1; j > realIndex; j--) {
                currentNode = currentNode.getPreviousNode();
            }
        }
        return currentNode.getValue();
    }

    @Override
    public void setStartOnIndex(int n) {
        int realIndex = n % length;
        if (realIndex < 0) realIndex = length + realIndex;
        ListNode<T> currentNode = firstNode;
        for (int j = 0; j <= realIndex; j++) {
            currentNode = currentNode.getNextNode();
        }
        this.firstNode = currentNode;
        this.lastNode = currentNode.getPreviousNode();
    }

    @Override
    public void remove(int n) {
        ListNode<T> currentNode = firstNode;
        int realIndex = n % length;
        if (realIndex < 0) realIndex = length + realIndex;
        for (int j = 0; j < realIndex; j++) {
            currentNode = currentNode.getNextNode();
        }
        currentNode.getPreviousNode().setNextNode(currentNode.getNextNode());
        currentNode.getNextNode().setPreviousNode(currentNode.getPreviousNode());
        currentNode = null;
        this.length--;
    }
}
