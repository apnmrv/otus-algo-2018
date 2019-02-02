package Heapsorter;

public class HeapBuilder {
    private int [] _data;
    private Tree _heap;
    private int _size;

    HeapBuilder(){
        _heap = new Tree();
    }

    public void buildHeap(int [] data)
    {
        _data = data;
        _size = data.length;
        _heap.setLastChildIdx(_size - 1);
        _heap.setLastParentIdx((_size-1)/2 - _size%2);
    }
}
