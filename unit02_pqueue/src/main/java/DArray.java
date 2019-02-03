public class DArray<T>{

    private Object[] _arr;
    private int _blockSize = 10;
    private int _elementsCount = 0;

    DArray(){
        _arr = new Object[_blockSize];
    }

    DArray(int blockSize){
        _blockSize = blockSize;
        _arr = new Object[_blockSize];
    }

    T get(int index) {
        T result = null;
        if(index >=0 && index < _elementsCount){
            result = (T)_arr[index];
        }
        return result;
    }

    private void relocate() {
        int currSize = capacity();
        int newSize = currSize + _blockSize;

        Object[] tmp = new Object[newSize];

        for(int i=0; i < currSize; i++) {
            tmp[i] = _arr[i];
        }

        _arr = tmp;
    }

    private void relocate(int newsize, int index) {
        Object[] tmp = new Object[newsize];

        if (_arr != null)
            for(int i=0; i < _arr.length; i++)
                if (i<index)
                    tmp[i] = _arr[i];
                else
                    tmp[i+1] = _arr[i];
        _arr = tmp;
    }

    void add(Object element) {
        if (false == canAdd()){
            relocate();
        }
        _arr[_elementsCount] = element;
        _elementsCount++;
    }

    void insert(int index, T element) {
        if (_arr == null || _arr.length <= index)
            relocate(index+1, index);
        _arr[index] = (Object)element;
        _elementsCount++;
    }

    private boolean canAdd() {
        boolean answer = true;
        if(_elementsCount == capacity()){
            answer = false;
        }
        return answer;
    }

    int size(){
        return _elementsCount;
    }

    int capacity( ) {
        return _arr.length;
    }
}
