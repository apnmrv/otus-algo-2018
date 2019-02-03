package Tree;

public interface ITreeNodeFactory {
    TreeNode createParentNode(int id, TreeNode parentNode, TreeNode leftChild, TreeNode rightChild);
    TreeNode createChildNode(int id, TreeNode parentNode);
}
