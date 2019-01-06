class BArray<T> {

    private int length = 0;
    private int maxLength;

    private Object[] _arr;

    public BArray(int size) {
        maxLength = size;
        _arr = new Object[maxLength];
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        T result = null;

        if(index < length)
        {
            result = (T)_arr[index];
        }
        return result;
    }

    protected void add(T element) {

        if(length < maxLength)
        {
            _arr[length] = (Object)element;
            ++length;
        }
    }

    public int size( ) {
        return length;
    }

    public void set(int index, Object item) {
        _arr[index] = item;
    }

    public T cut(int index){
        T result = get(index);
        remove(index);
        return result;
    }

    public void remove(int index){
        _arr[index] = null;
        --length;
    }
}
