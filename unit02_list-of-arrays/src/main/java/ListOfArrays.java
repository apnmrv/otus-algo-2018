public class ListOfArrays <T> implements IListOfArrays {

    private OListExtended<BArray<T>> _arrays;
    private int _delta;

    private int _index = 0;
    private BArray<T> _targetArray = null;
    private OList.ListItem _targetItem = null;

    ListOfArrays(int delta){
        _delta = delta;
        _arrays = new OListExtended<BArray<T>>();
        addArray();
    }

    public Object get(int index) {

        Object result = null;

        setTargets(index);

        if(null != _targetArray)
        {
            result = _targetArray.get(index);
        }

        return result;
    }

    public void add(Object item) {

        BArray lastArray = (BArray) _arrays.tail().get();

        if(lastArray.size() == _delta)
        {
            addArray();
            lastArray = (BArray) _arrays.tail().get();
        }

        lastArray.add(item);
    }

    public void insert(int index, Object item) {

        setTargets(index);

        if(null != _targetItem) {
            if(_targetArray.size() > _index){
                shiftForward();
                _targetArray.set(_index, item);
            } else {
                _arrays.insertAfter(_targetItem, new BArray<T>(_delta));
                BArray arrayTo = (BArray)_targetItem.getNext().get();
                arrayTo.set(0, item);
            }
        }
    }

    private void shiftForward() {

        BArray arrayFrom = _targetArray;
        BArray arrayTo = (BArray)_targetItem.getNext().get();

        _arrays.insertAfter(_targetItem, new BArray<T>(_delta));
        for(int i=_index; i<arrayFrom.size(); i++)
        {
            int j = 0;
            arrayTo.set(j, arrayFrom.cut(i));
            j++;
        }
    }

    public void remove(int index) {
        setTargets(index);
        if(null !=_targetItem){
            _targetArray.remove(_index);
            shiftBack();
        }
    }

    private void shiftBack() {

        int newSize = _targetArray.size();

        for(int i = _index; i < newSize; i++)
        {
            _targetArray.set(i, _targetArray.cut(i+1));
        }
    }

    private void addArray()
    {
        _arrays.addItem(new BArray<T>(_delta));
    }

    private void setTargets(int index)
    {
        _index = index;
        _targetItem = _arrays.current();
        _targetArray = (BArray) _targetItem.get();

        while(null != _targetArray && _delta < _index)
        {
            _index -= _targetArray.size();
            _targetItem = _arrays.current();
            _targetArray = (BArray) _targetItem.get();
        }
    }
}
