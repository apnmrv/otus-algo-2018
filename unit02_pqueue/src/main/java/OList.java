public class OList<T> {

    @SuppressWarnings("hiding")
    protected class ListItem<T> {
        T _item;
        ListItem<T> _next;

        ListItem(T item) {
            _item = item;
            _next = null;
        }

        T get() {
            return _item;
        }

        void setNext(ListItem<T> item) {
            _next = item;
        }
        ListItem<T> getNext() {
            return _next;
        }
    }

    protected ListItem<T> _head;
    protected ListItem<T> _tail;

    protected OList() {
        _head = null;
        _tail = null;
    }

    protected ListItem<T> head() {
        return _head;
    }

    protected void add(T item) {
        ListItem<T> li = new ListItem<T>(item);
        if (_head == null) {
            _head = li;
            _tail = li;
        }
        else {
            _tail.setNext(li);
            _tail = li;
        }
    }
}