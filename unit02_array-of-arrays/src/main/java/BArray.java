public class BArray<T>{

    private int maxLength;
    protected Object[] _arr;
    protected int length = 0;

    public BArray(int size)
    {
        maxLength = size;
        _arr = new Object[size];
    }

    @SuppressWarnings("unchecked")
    public T get(int index)
    {
        return (T)_arr[index];
    }

    protected void add(int index, T element)
    {
        _arr[index] = (T)element;
        ++length;
    }

    public int size( )
    {
        return length;
    }

    private void relocate(int newsize, int index)
    {
        Object[] tmp = new Object[newsize];

        if (_arr != null)
            for(int i=0; i < _arr.length; i++)
                if (i<index)
                    tmp[i] = _arr[i];
                else
                    tmp[i+1] = _arr[i];
        _arr = tmp;
    }
}
