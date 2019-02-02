package Heapsorter;

public class AllInOneHeapSorter implements ISorter {

    private static final String NAME = "Heapsorter";

    private static final int FIRST_PARENT_IDX = 0;

    private int[] _array;
    private int _heapSize;
    private int _lastChildIdx;
    private int _lastParentIdx;


    public int[] sort(int[] arr){
        _array = arr;
        _heapSize = arr.length;

        setLimits();
        buildHeap();
        sortHeap();

        return _array;
    }

    private void sortHeap() {

        while(_heapSize > 1) {
            interchange(FIRST_PARENT_IDX, _lastChildIdx);
            _heapSize--;
            setLimits();
            drown(FIRST_PARENT_IDX);
        }
    }

    private void setLimits()
    {
        _lastChildIdx = _heapSize - 1;
        _lastParentIdx = (_heapSize -1)/2 - _heapSize %2;
    }

    private void buildHeap(){
        int parentIdx = _lastParentIdx;
        while(parentIdx >= FIRST_PARENT_IDX){
            drown(parentIdx);
            parentIdx --;
        }
    }

    private void drown(int parentIdx){
        int firstbornIdx;
        while(parentIdx <= _lastParentIdx){
            firstbornIdx = firstbornIdxOf(parentIdx);
            if(parentIdx != whichIsElder(parentIdx, firstbornIdx)) {
                interchange(parentIdx, firstbornIdxOf(parentIdx));
            }
            parentIdx = firstbornIdx;
        }
    }

    private int firstbornIdxOf(int idx) {
        int firstbornIdx = idx*2+1;
        if(firstbornIdx < _lastChildIdx){
            firstbornIdx = whichIsElder(idx*2+1, idx*2+2);
        }
        return firstbornIdx;
    }

    private int whichIsElder(int idx1, int idx2) {
        int result = idx1;
        if(_array[idx1] < _array[idx2]) {
            result = idx2;
        }
        return result;
    }

    private void interchange(int idx1, int idx2) {
        int temp = _array[idx1];
        _array[idx1] = _array[idx2];
        _array[idx2] = temp;
    }

    @Override
    public String title() {
        return NAME;
    }
}
