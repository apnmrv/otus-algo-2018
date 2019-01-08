class BArray<T> {

    private int _length = 0;
    private int _capacity;

    private Object[] _arr;

    public BArray(int size) {
        _capacity = size;
        _arr = new Object[_capacity];
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        T result = null;

        if(index < _length)
        {
            result = (T)_arr[index];
        }
        return result;
    }

    protected void add(T element) {

        if(_length < _capacity)
        {
            _arr[_length] = (Object)element;
            ++_length;
        }
    }

    public int size( ) {
        return _length;
    }

    public void set(int index, Object item) {
        _arr[index] = item;
        _length++;
    }

    public T cut(int index){
        T result = get(index);
        remove(index);
        return result;
    }

    public void remove(int index){
        _arr[index] = null;
        _length--;
    }
}
