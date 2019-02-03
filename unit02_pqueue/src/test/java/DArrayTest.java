import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DArrayTest {

    private static final int BLOCK_SIZE = 100;
    private DArray _dArrToTest;

    @BeforeEach
    void setUp() {
        _dArrToTest = new DArray(BLOCK_SIZE);
    }

    @Test
    void canBeFilledUp()
    {
        for(int i=0; i<BLOCK_SIZE; i++) {
            _dArrToTest.add("string_"+i);
            assertEquals("string_"+i, _dArrToTest.get(i));
        }
    }

    @Test
    void canExtendDynamically()
    {
        for(int i=0; i<(BLOCK_SIZE^2); i++) {
            _dArrToTest.add("string_"+i);
            assertEquals("string_"+i, _dArrToTest.get(i));
        }
    }

    void canInsertElement(){
        DArray dArr = new DArray();
        dArr.insert(0, new int [] {3, 4, 5, 6});
        dArr.insert(3, "string");
        dArr.insert(8, 3);

        assertEquals(3, dArr.get(8));
        assertEquals("string", dArr.get(3));
    }
}