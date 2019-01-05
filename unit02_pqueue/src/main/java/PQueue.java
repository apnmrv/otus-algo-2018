public class PQueue implements IPQueue {

    private PQueueLevel queueLevel;
    private DArrayExtended pqueue;

    PQueue(){
        pqueue = new DArrayExtended();
        setLevel(0);
    }

    private void setLevel(int i) {
        queueLevel = new PQueueLevel();
        pqueue.add(i, queueLevel);
    }

    public <T> void enqueue(int priority, T item) {

        queueLevel = (PQueueLevel) pqueue.get(priority);
        if(null == queueLevel) {
            setLevel(priority);
        }
        queueLevel.add(item);
    }

    public <T> T dequeue() {

        return current();

    }

    private <T> T current() {
        T current = null;
        int i = 0;
        int levels = pqueue.size();

        do{
            queueLevel = (PQueueLevel) pqueue.get(i);
            current = (T) queueLevel.firstOne();
            i++;
        } while(null == current && i < levels);

        return current;
    }
}
