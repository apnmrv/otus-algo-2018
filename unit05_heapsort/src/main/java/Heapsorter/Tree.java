package Heapsorter;

class Tree {

    private int[] _data;
    private int _lastChildIdx;
    private int _lastParentIdx;
    private int[] _parents;
    private int[] _leafs;

    Tree() { }

    int getLastChildIdx() {
        return _lastChildIdx;
    }

    int getLastParentIdx() {
        return _lastParentIdx;
    }

    void setLastChildIdx(int lastChildIdx) {
        this._lastChildIdx = _lastChildIdx;
    }

    void setLastParentIdx(int lastParentIdx) {
        this._lastParentIdx = _lastParentIdx;
    }
}
