public class HeapSorter {

    private Heap _heap;

    public int[] sortHeap(Heap heap) {
        _heap = heap;
        int size = _heap.size();
        int [] sorted = new int[size];
        for(int i = 0; i < size; i++){
            sorted[i] = _heap.cutVertex();
        }
        return sorted;
    }
}
