package Tree;

public class TreeNode {

    private int _id;
    private int _value;
    private TreeNode _parent = null;
    private TreeNode _lChild = null;
    private TreeNode _rChild = null;

    TreeNode(int id, int value) {
        _id = id;
    }

    void setParent(TreeNode node){
        _parent = node;
    }

    void setRightChild(TreeNode node){
        _rChild = node;
    }

    void setLeftChild(TreeNode node){
        _lChild = node;
    }

    TreeNode parent() {
        return _parent;
    }

    TreeNode leftChild(){
        return _lChild;
    }

    TreeNode rightChild(){
        return _rChild;
    }

    boolean isParent(){
        return (null != _rChild || null !=_lChild);
    }

    boolean isRoot(){
        return null != _parent;
    }
}
