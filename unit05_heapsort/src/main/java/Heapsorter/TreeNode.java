package Heapsorter;

public class TreeNode {

    private int data;
    private TreeNode _parent = null;
    private TreeNode _lChild = null;
    private TreeNode _rChild = null;

    TreeNode() {

    }

    TreeNode(TreeNode parent, TreeNode leftChild, TreeNode rightChild) {
        _parent = parent;
        _lChild = leftChild;
        _rChild = rightChild;
    }

    TreeNode(TreeNode leftChild, TreeNode rightChild) {
        _lChild = leftChild;
        _rChild = rightChild;
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

    boolean isVertex(){
        return null != _parent;
    }


}
