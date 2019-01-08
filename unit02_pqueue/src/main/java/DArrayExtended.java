public class DArrayExtended <T> extends DArray{

    private int _blockSize = 10;
    private int _elementsCount = 0;

    DArrayExtended(){
        _arr = new Object[_blockSize];
    }

    DArrayExtended(int blockSize){
        _blockSize = blockSize;
        _arr = new Object[_blockSize];
    }

    @Override
    Object get(int index) {

        T result = null;

        if(index < size()){
            result = (T) super.get(index);
        }

        return result;
    }

    protected void relocate() {
        int currSize = size();
        int newSize = currSize + _blockSize;

        Object[] tmp = new Object[newSize];

        for(int i=0; i < currSize; i++) {
            tmp[i] = _arr[i];
        }

        _arr = tmp;
    }

    public void add(Object element) {
        if (false == canAddAnElement()){
            relocate();
        }
        _arr[_elementsCount] = element;
        ++_elementsCount;
    }

    private boolean canAddAnElement() {
        boolean answer = true;
        if(_elementsCount == size()){
            answer = false;
        }
        return answer;
    }
}
