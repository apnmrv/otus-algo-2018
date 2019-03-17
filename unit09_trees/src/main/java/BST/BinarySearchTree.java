package BST;

public class BinarySearchTree<T1 extends Comparable<T1>, T2> implements ITree<T1, T2> {
    private Node<T1, T2> __root;

    public BinarySearchTree(){}

    @Override
    public T2 get(T1 key) {
        Node<T1, T2> node = __findNodeByKey(__root, key);
        return null != node ? node.value() : null;
    }

    private Node<T1, T2> __findNodeByKey(Node<T1, T2> node, T1 key){
        if (null == node)
            return node;

        int cmp = key.compareTo(node.key());

        if (cmp < 0)
            __findNodeByKey(node.left(), key);
        else if (cmp > 0)
            __findNodeByKey(node.right(), key);
        return node;
    }

    @Override
    public void insert(T1 key, T2 value) {
        if (null == __root)
            __root = new Node(key, value);
        else
            __insertKeyValue(__root, key, value);
    }

    private Node<T1, T2> __insertKeyValue(Node<T1, T2> node, T1 key, T2 value){
        if(null == node) {
            return new Node(key, value);
        }

        int cmp = key.compareTo(node.key());
        if (cmp < 0) {
            node.setLeft(__insertKeyValue(node.left(), key, value));
        } else if (cmp > 0) {
            node.setRight(__insertKeyValue(node.right(), key, value));
        }
        return node;
    }

    @Override
    public void remove(T1 key) {
        __remove(__root, key);
    }

    private Node<T1, T2> __remove(Node<T1, T2> node, T1 key){
        if (null == node)
            return node;
        int cmp = key.compareTo(node.key());
        if (cmp < 0)
            node.setLeft(__remove(node.left(), key));
        else if (cmp > 0)
            node.setRight(__remove(node.right(), key));
        else if (null != node.left() && null != node.right()){  // has both descendants
            Node<T1, T2> leftMostLeafOfTheRightSubtree = __findNodeWithMinimalKey(node.right());
            node.setKey(leftMostLeafOfTheRightSubtree.key());
            node.setValue(leftMostLeafOfTheRightSubtree.value());

            node.setRight(__remove(node.right(), node.key()));
        } else {                                                // has only left child
            if (null != node.left())
                node = node.left();
            else                                                // has only right child
                node = node.right();
        }
        return node;
    }

    private Node<T1, T2> __findNodeWithMinimalKey(Node<T1, T2> node){
        return null != node.left() ? __findNodeWithMinimalKey(node.left()) : node;
    }

    private Node<T1, T2> __findNodeWithMaximalKey(Node<T1, T2> node){
        if (null == node.left())
            return node;
        return __findNodeWithMaximalKey(node);
    }

    private Node<T1, T2> __next(T1 key){
        Node<T1, T2> current = __root, next = null;
        while (null != current) {
            int cmp = key.compareTo(current.key());
            if (cmp < 0) {
                next = current;
                current = current.left();
            } else {
                current = current.right();
            }
        }
        return next;
    }

    private Node<T1, T2> __previous(T1 key){
        Node<T1, T2> current = __root, prev = null;

        while (null != current) {
            int cmp = key.compareTo(current.key());
            if (cmp >= 0) {
                prev = current;
                current = current.right();
            } else {
                current = current.left();
            }
        }
        return prev;
    }

    public boolean isBinarySearchTree(T1 min, T1 max){
        return __isBinarySearchTree(__root, min, max);
    }

    private boolean __isBinarySearchTree(Node<T1, T2> node, T1 min, T1 max){
        if(null == node)
            return true;
        if(0 > node.key().compareTo(min) || 0 < node.key().compareTo(max))
            return false;
        return __isBinarySearchTree(node.left(), min, node.key())
                && __isBinarySearchTree(node.right(), node.key(), max);
    }
}
