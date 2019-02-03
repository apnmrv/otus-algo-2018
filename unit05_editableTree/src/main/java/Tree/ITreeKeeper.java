package Tree;

public interface ITreeKeeper {
    public void createTree(int [] data);
    public void removeNode(int idx);
    public void insertAfter(int idx);
    public int getSorted();

    void moveUp(Tree.TreeNode node);
}
