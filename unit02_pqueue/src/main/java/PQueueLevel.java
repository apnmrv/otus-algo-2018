public class PQueueLevel <T> {

    private OListExtended list;

    PQueueLevel(){
        list = new OListExtended();
    }

    public void add(T element)
    {
        list.addItem(element);
    }

    public T firstOne() {

        T head = (T) list.first();

        return head;
    }
}
