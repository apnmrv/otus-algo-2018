package Tree;

public class TreeNodeFactory implements ITreeNodeFactory {

    @Override
    public TreeNode createParentNode(int id, TreeNode parentNode, TreeNode leftChild, TreeNode rightChild) {
        return new TreeNode(id, parentNode, leftChild, rightChild);
    }

    @Override
    public TreeNode createChildNode(int id, TreeNode parentNode) {
        return new TreeNode (id, parentNode);
    }
}
