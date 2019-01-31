package Heapsorter;

public class HeapBuilder {

    private int [] _array;
    private int _lastParentIdx;
    private boolean _ready;

    public int[] heapIt(int [] array){

        _array = array;
        _ready = false;
        _lastParentIdx = ((array.length-1)>>2)-1;

        checkParents();

        return _array;
    }

    private void checkParents(){
        for(int i = _lastParentIdx; i >= 0 && !_ready; i--) {
            _ready = true;
            int firstbornIdx = firstbornIdxOf(i);
            if(_array[i] < _array[firstbornIdx]) {
                interchange(i, firstbornIdx);
                _ready = false;
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
