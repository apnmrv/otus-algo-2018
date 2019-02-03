import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class PQueueTest <T> {

    private static final int NUMBER_OF_PRIORITIES = 1_000;
    private static final int NUMBER_OF_ELEMENTS_TO_ENQUEUE = 1_000;

    private PQueue _loadedPQueue;
    private PQueue _emptyPQueue;
    private Map _elementsToEnqueue;
    private String[] types = {"string", "integer", "array", "userObject"};


    private class UserObject {
        private String string;
        private int integer;

        UserObject(String s, int i){
            string = s;
            integer = i;
        }
    }

    @BeforeEach
    void setUp() {
        _elementsToEnqueue = new HashMap();
        _emptyPQueue = new PQueue();
        _loadedPQueue = new PQueue();

        _elementsToEnqueue.put("string", "string");
        _elementsToEnqueue.put("integer", 100);
        _elementsToEnqueue.put("array", new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        _elementsToEnqueue.put("userObject", new UserObject("string", 125));

        for (int p = 0; p < NUMBER_OF_PRIORITIES; p++){

            for (int i = 0; i < types.length; i++) {
                _loadedPQueue.enqueue(p, _elementsToEnqueue.get(types[i]));
            }
        }
    }

    @Test
    void dequeueReturnsWhatWasEnqueued(){

        _emptyPQueue.enqueue(1, 10);
        T dequeued = _emptyPQueue.dequeue();
        assertEquals(10, dequeued);
    }

    @Test
    void canAddAtAnyGivenLevel(){

        char[] charrArr = {'s', 't', 'r', 'i', 'n', 'g'};

        _emptyPQueue.enqueue(8, 10);

        T dequeued = _emptyPQueue.dequeue();
        assertEquals( 10, dequeued);
    }

    @Test
    void canAddElementsAtAnyDifferentLevels(){

        char[] charrArr = {'s', 't', 'r', 'i', 'n', 'g'};

        _emptyPQueue.enqueue(8, 10);
        _emptyPQueue.enqueue(0, "string");
        _emptyPQueue.enqueue(15, charrArr);

        T dequeued = _emptyPQueue.dequeue();
        assertEquals( "string", dequeued);

        dequeued = _emptyPQueue.dequeue();
        assertEquals( 10, dequeued);

        dequeued = _emptyPQueue.dequeue();
        assertEquals( charrArr, dequeued);
    }

    @Test
    void canExtendPrioritiesDynamically(){

        String s = new String ("string");
        Integer integer = new Integer(100);

        for(int i = 0; i < 1_000; i++){
            _emptyPQueue.enqueue(i, s);
            _emptyPQueue.enqueue(i, integer);
        }

        for(int i = 0; i < 1_000; i++){
            T dequeued = _emptyPQueue.dequeue();
            assertEquals(s, dequeued);
            dequeued = _emptyPQueue.dequeue();
            assertEquals(integer, dequeued);
        }
    }


    @Test
    void dequeuedIsOfTheTypeEnqueued() {
        for (int p = 1; p < NUMBER_OF_PRIORITIES; p++) {
            for (int i = 0; i < types.length; i++) {
                T dequeued = _loadedPQueue.dequeue();
                String type = _elementsToEnqueue.get(types[i]).getClass().getName();
                assertEquals(type, dequeued.getClass().getName());
            }
        }
    }

    @Test
    void dequeueReturnsNullIfEmpty(){
        IPQueue pQueueToTest = new PQueue();
        assertNull(pQueueToTest.dequeue());
    }

    @Test
    void dequeuedHasTheSameValueAsEnqueued() {
        for (int p = 1; p < NUMBER_OF_PRIORITIES; p++) {
            for (int i = 0; i < types.length; i++) {
                T dequeued = _loadedPQueue.dequeue();
                assertEquals(_elementsToEnqueue.get(types[i]), dequeued);
            }
        }
    }

    @Test
    void canDequeueAllElementsEnqueued()
    {
        PQueue pq = new PQueue();

        for(int i = 0; i < NUMBER_OF_PRIORITIES; i++){
            for(int j=0; j < NUMBER_OF_ELEMENTS_TO_ENQUEUE; j++){
                pq.enqueue(i,j);
            }
        }

        Integer intgr = pq.dequeue();

        while (intgr != null) {
            assertNotNull(intgr);
            intgr = pq.dequeue();
        }
        assertNull(intgr);
    }
}