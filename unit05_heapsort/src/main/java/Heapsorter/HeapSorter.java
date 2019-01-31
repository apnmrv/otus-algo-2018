package Heapsorter;

public class HeapSorter implements ISorter{

    int [] _array;

    HeapBuilder _heaper;
    Drowner _drowner;
    int _lastIdx;

    public HeapSorter(){
        _heaper = new HeapBuilder();
        _drowner = new Drowner();
    }

    @Override
    public int[] sort(int[] array) {

        _array = array;

        _lastIdx = _array.length - 1;
        _heaper.heapIt(_array);
        sortHeap(_array);

        return _array;
    }

    private void sortHeap(int[] array) {

    }
}
