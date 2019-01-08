public class ListOfArrays <T> implements IListOfArrays {

    private OListExtended<BArray<T>> _arrays;
    Counter _counter;

    private int _index = 0;
    private BArray<T> _targetArray = null;
    private OList.ListItem _targetItem = null;
    private OList.ListItem _prevItem = null;
    private OList.ListItem _nextItem = null;

    ListOfArrays(int delta){
        _counter = new Counter(delta);
        _arrays = new OListExtended<BArray<T>>();
    }

    public Object get(int index) {

        Object result = null;

        setTargets(index);

        if(null != _targetArray)
        {
            result = _targetArray.get(_index);
        }

        return result;
    }

    public void add(Object obj) {
        if(0 == _counter.arrays()){
            addArray();
            _arrays.resetCurrent();
        }

        BArray lastArray = (BArray) _arrays.tail().get();

        if(lastArray.size() == _counter.arrayCapacity())
        {
            addArray();
            lastArray = (BArray) _arrays.tail().get();
        }

        lastArray.add(obj);
        _counter.addElement();
    }

    public void insert(int index, Object item) {

        setTargets(index);
        int elementsInArray = _targetArray.size();

        if(elementsInArray > _index){
            shiftForward();
            _targetArray.set(_index, item);
        } else {
            _targetArray.add((T)item);
        }
        _counter.addElement();
    }

    private void shiftForward() {

        BArray arrayFrom = _targetArray;
        _arrays.insertAfter(_targetItem, new BArray<T>(_counter.arrayCapacity()));
        BArray arrayTo = (BArray)_targetItem.getNext().get();

        int numberOfElementsInTargetArray = arrayFrom.size();

        for(int i=_index; i<numberOfElementsInTargetArray; i++)
        {
            arrayTo.add(arrayFrom.cut(i));
        }
    }

    public void remove(int index) {
        setTargets(index);
        if(null !=_targetItem){
            _targetArray.remove(_index);
            _counter.removeElement();
            shiftBack();
            if(_targetArray.size()==0){
                removeEmptyCurrentTargetItem();
            }
        }
    }

    private void removeEmptyCurrentTargetItem() {
        if (_prevItem != null && _nextItem != null) {
            _prevItem.setNext(_nextItem);
        }
        _arrays.resetCurrent();
        _counter.removeArray();
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
        _arrays.addItem(new BArray<T>(_counter.arrayCapacity()));
        _counter.addArray();
    }

    private void setTargets(int index)
    {
        _index = index;
        _arrays.resetCurrent();
        setListItems();

        _targetArray = (BArray) _targetItem.get();

        while(null != _targetArray && _targetArray.size() <= _index)
        {
            _index -= _targetArray.size();
            setListItems();
            _targetArray = _targetItem != null ? (BArray) _targetItem.get() : null;
        }
    }

    private void setListItems(){
        _targetItem = _arrays.current();
        _prevItem = _arrays.previous();
        _nextItem = _arrays.next();
    }

    public int arrays(){
        return _counter.arrays();
    }

    public int elements(){
        return _counter.elements();
    }
}
