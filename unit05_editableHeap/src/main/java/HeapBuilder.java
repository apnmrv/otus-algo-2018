public class HeapBuilder {

    private Heap _heap;

    public Heap build(int[] data){
        _heap = new Heap(data);
        buildHeap();
        return _heap;
    }

    private void buildHeap(){
        int parentId = _heap.lastParentId();
        while(parentId >= _heap.vertexId()){
            _heap.drown(parentId);
            parentId --;
        }
    }
}
