import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class OListExtendedTest<T> {

    private static final int INT_ITEM = 100;
    private static final String STRING_ITEM = "string";
    private static final String[] ARRAY_ITEM = {"string", "another string", "yet another string"};

    private OListExtended<T> objToTest;

    @BeforeEach
    void setUp()
    {
        objToTest = new OListExtended<T>();
    }

    @Test
    void canIterateWithCurrent()
    {
        objToTest.addItem(INT_ITEM);
        objToTest.addItem(STRING_ITEM);
        objToTest.addItem(ARRAY_ITEM);

        OList.ListItem currentItem = objToTest.current();

        assertEquals(INT_ITEM, currentItem.get());

        currentItem = objToTest.current();
        assertEquals(STRING_ITEM, currentItem.get());

        currentItem = objToTest.current();
        assertEquals(ARRAY_ITEM, currentItem.get());

        currentItem = objToTest.current();
        assertNull(currentItem);

        currentItem = objToTest.current();
        assertEquals(INT_ITEM, currentItem.get());

        currentItem = objToTest.current();
        assertEquals(STRING_ITEM, currentItem.get());

        currentItem = objToTest.current();
        assertEquals(ARRAY_ITEM, currentItem.get());

        currentItem = objToTest.current();
        assertNull(currentItem);
    }
}