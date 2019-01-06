public class OList<T> {

    @SuppressWarnings("hiding")
    protected class ListItem<T> {
        private T _item;
        private ListItem<T> _next;

        ListItem(T item) {
            _item = item;
            _next = null;
        }

        public T get() {
            return _item;
        }

        public void setNext(ListItem<T> item) {
            _next = item;
        }
        public ListItem<T> getNext() {
            return _next;
        }
    }

    private ListItem<T> _head;
    private ListItem<T> _tail;

    protected OList() {
        _head = null;
        _tail = null;
    }

    protected ListItem<T> head() {
        return _head;
    }

    protected ListItem<T> tail() {
        return _tail;
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
