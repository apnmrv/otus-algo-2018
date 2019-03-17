package BST;


class Node<T1 extends Comparable<T1>, T2> {
    private T1 __key;
    private T2 __value;
    private Node<T1, T2> __left, __right;

    Node(T1 key, T2 value) {
        __key = key;
        __value = value;
    }

    T1 key() {
        return __key;
    }

    T2 value() {
        return __value;
    }

    Node<T1, T2> left() {
        return __left;
    }

    Node<T1, T2> right() {
        return __right;
    }

    void setLeft(Node<T1, T2> node) {
        __left = node;
    }

    void setRight(Node<T1, T2> node) {
        __right = node;
    }

    void setValue(T2 value) {
        __value = value;
    }

    void setKey(T1 key) {
        __key = key;
    }
}
