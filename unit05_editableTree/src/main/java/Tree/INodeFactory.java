package Tree;

interface INodeFactory {
    TreeNode create(int parentIdx, int leftChildIdx, int rightChildIdx);
}
