public class PQueueLevel <T> {

    private OListExtended _list;

    PQueueLevel(){
        _list = new OListExtended();
    }

    public void add(T element)
    {
        _list.addItem(element);
    }

    public T pickFirst() {

        T head = (T) _list.first();

        return head;
    }

    public boolean isEmpty() {
        return null == _list.head();
    }
}
