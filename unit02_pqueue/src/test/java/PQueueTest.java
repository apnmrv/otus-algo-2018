import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class PQueueTest <T> {

    private PQueue pQueueToTest;
    private Map elementsToEnqueue;
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
        elementsToEnqueue = new HashMap();
        pQueueToTest = new PQueue();

        elementsToEnqueue.put("string", "string");
        elementsToEnqueue.put("integer", 100);
        elementsToEnqueue.put("array", new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        elementsToEnqueue.put("userObject", new UserObject("string", 125));

        for (int p = 1; p < 11; p++){

            for (int i = 0; i < types.length; i++) {
                pQueueToTest.enqueue(p, elementsToEnqueue.get(types[i]));
            }
        }
    }

    @Test
    void canDequeueSomethingJustEnqueued() {
        for (int p = 1; p < 11; p++) {
            for (int i = 0; i < types.length; i++) {
                T dequeued = pQueueToTest.dequeue();
                assertNotNull(dequeued);
            }
        }
    }

    @Test
    void dequeuedIsOfTheTypeEnqueued() {
        for (int p = 1; p < 11; p++) {
            for (int i = 0; i < types.length; i++) {
                T dequeued = pQueueToTest.dequeue();
                String type = elementsToEnqueue.get(types[i]).getClass().getName();
                assertEquals(type, dequeued.getClass().getName());
            }
        }
    }

    @Test
    void dequeuedHasTheSameValueAsEnqueued() {
        for (int p = 1; p < 11; p++) {
            for (int i = 0; i < types.length; i++) {
                T dequeued = pQueueToTest.dequeue();
                assertEquals(elementsToEnqueue.get(types[i]), dequeued);
            }
        }
    }
}