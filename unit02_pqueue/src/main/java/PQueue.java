public class PQueue implements IPQueue {

    private DArray _levels;

    PQueue(){
        _levels = new DArray();
        setLevels(10);
    }

    private void setLevels(int levels) {
        int actual = _levels.size();
        int extended = actual+levels;
        for(int i = actual; i < extended; i++){
            PQueueLevel queueLevel = new PQueueLevel();
            _levels.add(queueLevel);
        }
    }

    public <T> void enqueue(int priority, T item) {

        if(priority > _levels.size()-1) {
            setLevels(10);
        }

        PQueueLevel level = (PQueueLevel) _levels.get(priority);
        level.add(item);
    }

    public <T> T dequeue() {
        return current();
    }

    private <T> T current() {
        T current = null;
        int levels = _levels.capacity();
        int lNumber = 0;
        
        while(null == current && lNumber < levels){
            PQueueLevel level = (PQueueLevel) _levels.get(lNumber);
            if(!level.isEmpty()) {
                current = (T) level.pickFirst();
            }
            lNumber++;
        }
        return current;
    }
}
