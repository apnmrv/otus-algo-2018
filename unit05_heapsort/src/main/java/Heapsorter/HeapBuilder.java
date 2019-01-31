package Heapsorter;

public class HeapBuilder {

    private int [] _array;
    private int _size;

    public int[] heapIt(int [] array){

        _array = array;
        _size = _array.length;
        int firstParentIdx = ((_size-1)>>2)-1;
        checkParent(firstParentIdx);
        return _array;
    }

    private void checkParent(int idx){
        for(int parentIdx = idx; parentIdx >= 0; parentIdx--) {
            int firstbornIdx = firstbornIdxOf(parentIdx);
            if(_array[parentIdx] < _array[firstbornIdx]) {
                interchange(parentIdx, firstbornIdx);
                checkParent(parentIdx);
            }
        }
    }

    private void interchange(int idx1, int idx2) {
        int temp = _array[idx1];
        _array[idx1] = _array[idx2];
        _array[idx2] = temp;
    }

    private int firstbornIdxOf(int idx) {
        int result = idx<<2+1;
        if(hasBothOffsprings(idx)) {
            result = whichIsElder(idx<<2+1, idx<<2+2);
        }
        return result;
    }

    private int whichIsElder(int idx1, int idx2) {
        int result = idx1;
        if(_array[idx1] < _array[idx2]) {
            result = idx2;
        }
        return result;
    }

    private boolean hasBothOffsprings(int idx) {
        return _size >= idx<<2+2;
    }
}
