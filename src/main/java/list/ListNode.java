package list;

class ListNode<T> {
    private T value;
    private ListNode nextNode;
    private ListNode previousNode;

    ListNode(T value, ListNode previousNode, ListNode nextNode) {
        this.value = value;
        this.nextNode = nextNode;
        this.previousNode = previousNode;
    }

    ListNode(T value) {
        this.nextNode = null;
        this.previousNode = null;
        this.value = value;
    }

    T getValue() {
        return value;
    }

    ListNode getNextNode() {
        return nextNode;
    }

    ListNode getPreviousNode() {
        return previousNode;
    }

    void setNextNode(ListNode nextNode) {
        this.nextNode = nextNode;
    }

    void setPreviousNode(ListNode previousNode) {
        this.previousNode = previousNode;
    }
}
