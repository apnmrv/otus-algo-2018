package AVL;

public class AVLTree<T1 extends Comparable<T1>, T2> implements ITree<T1, T2> {

    private Node<T1, T2> __root;

    public AVLTree(){}

    @Override
    public T2 get(T1 key) {
        Node<T1, T2> node = __findNodeByKey(__root, key);
        return null != node ? node.value() : null;
    }

    public boolean isBalanced(){
        return 1 >= Math.abs(__bFactor(__root));
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
        return __balance(node);
    }

    @Override
    public void remove(T1 key) {
        __remove(__root, key);
    }

    private Node<T1, T2> __remove(Node<T1, T2> node, T1 key){
        if (null == node)
            return null;

        int cmp = key.compareTo(node.key());
        if (cmp < 0)
            node.setLeft(__remove(node.left(), key));
        else if (cmp > 0)
            node.setRight(__remove(node.right(), key));
        else {                                          // key == node.key
            Node<T1, T2> left = node.left();
            Node<T1, T2> right = node.right();

            if(null == right)
                return left;

            Node<T1, T2> min = __findNodeWithMinimalKey(right);
            min.setRight(__removeNodeWithMinimalKey(right));
            min.setLeft(left);

            return __balance(min);
        }
        return __balance(node);
    }

    private Node<T1, T2> __findNodeWithMinimalKey(Node<T1, T2> node){
        return null != node.left() ? __findNodeWithMinimalKey(node.left()) : node;
    }

    private Node<T1, T2> __removeNodeWithMinimalKey(Node<T1, T2> node){
        if(null == node.left())
            return node.right();
        node.setLeft(__removeNodeWithMinimalKey(node.left()));
        return __balance(node);
    }

    private Node<T1, T2> __rotateLeft(Node<T1, T2> nodeA){
        Node<T1, T2> nodeB = nodeA.right();
        nodeA.setRight(nodeB.left());
        nodeB.setLeft(nodeA);
        __fixHeight(nodeA, nodeB);

        return nodeB;
    }

    private Node<T1, T2> __rotateRight(Node<T1,T2> nodeA) {
        Node<T1, T2> nodeB = nodeA.left();
        nodeA.setLeft(nodeB.right());
        nodeB.setRight(nodeA);
        __fixHeight(nodeA, nodeB);

        return nodeB;
    }

    private int __height (Node<T1, T2> node){
        return null != node ? node.height() : 0;
    }

    private int __bFactor(Node<T1, T2> node){
        return __height(node.right()) - __height(node.left());
    }

    private void __fixHeight(Node<T1,T2> nodeA, Node<T1,T2> nodeB) {
        __fixHeight(nodeA);
        __fixHeight(nodeB);
    }

    private void __fixHeight(Node<T1, T2> node){
        int hLeft = __height(node.left());
        int hRight = __height(node.right());
        node.setHeight((hLeft > hRight ? hLeft : hRight) + 1);
    }

    private Node<T1, T2> __balance(Node<T1, T2> node){
        __fixHeight(node);
        if (__bFactor(node) == 2){
            if(__bFactor(node.right()) < 0)
                node.setRight(__rotateRight(node.right()));
            return __rotateLeft(node);
        }
        if (__bFactor(node) == -2){
            if(__bFactor(node.left()) > 0)
                node.setLeft(__rotateLeft(node.left()));
            return __rotateRight(node);
        }
        return node;
    }
}
