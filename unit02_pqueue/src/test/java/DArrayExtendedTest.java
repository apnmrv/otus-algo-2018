import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DArrayExtendedTest {

    private static final int BLOCK_SIZE = 100;
    private DArrayExtended _dArrToTest;

    @BeforeEach
    void setUp() {
        _dArrToTest = new DArrayExtended(BLOCK_SIZE);
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
}