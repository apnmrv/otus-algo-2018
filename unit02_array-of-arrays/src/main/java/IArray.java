public class IArray<T> {

    private BArray<BArray<T>> _arr;
    private int _delta;

    private int _arrayIndex;
    private int _elementIndex;

    public IArray(int size)
    {
        _delta = size;
        _arr = new BArray<BArray<T>>(_delta);
        _arr.add(0, new BArray<T>(_delta));
    }

    public T get(int index){
        setIndices(index);
        return (T)_arr.get(_arrayIndex).get(_elementIndex);
    }

    public void relocate() {
        _arr.add(_arr.size(), new BArray<T>(_delta));
    }

    public void add(int index, T element) {

        if(_arr.size()*_delta <= index){
            relocate();
        }
        setIndices(index);
        _arr.get(_arrayIndex).add(_elementIndex, element);
    }

    private void setIndices(int index)
    {
        _arrayIndex = index / _delta;
        _elementIndex = index % _delta;
    }
}
