import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IArrayTest<T> {

    private static final int BLOCK_SIZE = 100;
    private IArray<Integer> _objToTest;

    @BeforeEach
    void setUp() {
        _objToTest  = new IArray<Integer>(BLOCK_SIZE);
    }

    @Test
    void canAddElement()
    {
        int element = 10;
        _objToTest.add(1, element);

        int elementReturned = _objToTest.get(1);

        assertEquals(element, elementReturned);
    }

    @Test
    void canAddMoreElementsThanSize()
    {
        int element = 10;

        for(int i = 0; i < BLOCK_SIZE*50; i++) {
            _objToTest.add(i, element);
        }
        _objToTest.add(BLOCK_SIZE, element);

        int elementReturned = _objToTest.get(BLOCK_SIZE/25);

        assertEquals(element, elementReturned);
    }
}