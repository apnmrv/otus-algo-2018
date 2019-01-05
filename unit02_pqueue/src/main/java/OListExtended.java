public class OListExtended <T> extends OList {

    void addItem(Object item) {
        super.add(item);
    }

    T first() {
        T element = null;
        ListItem head = null;

        head = super.head();

        if(null != head) {
            element = (T) head.get();
            shiftHead(head);
        }

        return element;
    }

    private void shiftHead(ListItem head) {
        _head = head.getNext();
    }
}
