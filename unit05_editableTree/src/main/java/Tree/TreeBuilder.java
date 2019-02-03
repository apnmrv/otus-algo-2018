package Tree;

public class TreeBuilder implements ITreeBuilder {

    private static final int ROOT_ID = 0;

    private int _lastParentId;
    private int _lastChildId;

    private TreeNode [] _nodes;

    @Override
    public Tree buildTree(int [] data) {
        int size = data.length;
        _lastParentId = (size-1)/2 - size%2;
        _lastChildId = size - 1;

        TreeNode root = new TreeNode(ROOT_ID, data[ROOT_ID]);
        _nodes[ROOT_ID] = root;

        int parentId = ROOT_ID;
        TreeNode parent = root;
        while(parentId <= _lastParentId){
            int lChildId = parentId*2+1;
            int rChildId = lChildId+1;
            parent.setLeftChild(new TreeNode(lChildId, data[lChildId]));
            if(rChildId >=_lastChildId){
                parent.setRightChild(new TreeNode(rChildId, data[rChildId]));
            }
        }
        return new Tree(root);
    }
}
