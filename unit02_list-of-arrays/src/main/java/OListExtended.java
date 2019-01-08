class OListExtended<T> extends OList {

    private ListItem _current = null;
    private ListItem _previous = null;
    private ListItem _next = null;

    OListExtended(){
        super();
        resetCurrent();
    }

    void addItem(Object item) {
        super.add(item);
    }

    public ListItem current() {
        ListItem curr = _current;
        shiftCurrent();
        return curr;
    }

    public ListItem previous(){
        return _previous;
    }

    public ListItem next(){
        return _next;
    }

    private void shiftCurrent() {
        if(null !=_current){
            _previous = _current;
            _current = _current.getNext();
            _next = _current != null ? _current.getNext(): null;
        } else {
            resetCurrent();
        }
    }

    public void insertAfter(OList.ListItem itemAfter, Object objectToInsert)
    {
        ListItem itemToInsert = new ListItem(objectToInsert);
        OList.ListItem itemBefore = itemAfter.getNext();
        itemAfter.setNext(itemToInsert);
        itemToInsert.setNext(itemBefore);
    }

    public void resetCurrent() {
        _previous = null;
        _current = head();
        _next = null != _current ? _current.getNext() : null;
    }
}