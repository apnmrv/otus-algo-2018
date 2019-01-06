class OListExtended<T> extends OList {

    protected ListItem _current;

    OListExtended(){
        super();
        _current = head();
    }

    void addItem(Object item) {
        super.add(item);
        _current = head();
    }

    public ListItem current() {
        ListItem result = null;

        if(_current != null){
            result = _current;
            shiftCurrent();
        } else {
            _current = head();
        }
        return result;
    }

    private void shiftCurrent()
    {
        _current = _current.getNext();
    }

    public void insertAfter(OList.ListItem itemAfter, Object objectToInsert)
    {
        ListItem itemToInsert = new ListItem(objectToInsert);
        OList.ListItem itemBefore = itemAfter.getNext();
        itemAfter.setNext(itemToInsert);
        itemToInsert.setNext(itemBefore);
    }
}