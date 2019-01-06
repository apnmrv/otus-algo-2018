import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ListOfArraysTest {

    private static final ListOfArrays LIST_OF_STRINGS = new ListOfArrays(100);
    private static final ListOfArrays LIST_OF_INTEGERS = new ListOfArrays(100);
    private static final ListOfArrays LIST_OF_ARRAYS = new ListOfArrays(100);
    private static final String STRING_ELEMENT = "string";
    private static final int INT_ELEMENT = 156;
    private static final String[] ARRAY_ELEMENT = {"string", "one more string", "yet another string"};
    private static final int LIST_CAPACITY = 1500;

    @BeforeAll
    void setUp() {
        for (int i = 0; i < LIST_CAPACITY; i++)
        {
            LIST_OF_STRINGS.add(STRING_ELEMENT);
            LIST_OF_INTEGERS.add(INT_ELEMENT);
            LIST_OF_ARRAYS.add(ARRAY_ELEMENT);
        }
    }

    @Test
    void get() {
        assertEquals(STRING_ELEMENT, LIST_OF_STRINGS.get(LIST_CAPACITY/2));
        assertEquals(INT_ELEMENT, LIST_OF_INTEGERS.get(LIST_CAPACITY/2));
        assertEquals(ARRAY_ELEMENT, LIST_OF_ARRAYS.get(LIST_CAPACITY/2));
    }

    @Test
    void insert() {
        String stringToInsert = "special string";
        LIST_OF_STRINGS.insert(LIST_CAPACITY/3, stringToInsert);
        assertEquals(stringToInsert, LIST_OF_STRINGS.get(LIST_CAPACITY/3));
        assertEquals(STRING_ELEMENT, LIST_OF_STRINGS.get(LIST_CAPACITY/3-1));
        assertEquals(STRING_ELEMENT, LIST_OF_STRINGS.get(LIST_CAPACITY/3+1));

        int intToInsert = 543;
        LIST_OF_INTEGERS.insert(LIST_CAPACITY/25, intToInsert);
        assertEquals(intToInsert, LIST_OF_INTEGERS.get(LIST_CAPACITY/25));
        assertEquals(INT_ELEMENT, LIST_OF_INTEGERS.get(LIST_CAPACITY/25+1));
        assertEquals(INT_ELEMENT, LIST_OF_INTEGERS.get(LIST_CAPACITY/25-1));

        String[] arrayToInsert = {"special string", "one more super special string", "yet another mega special string"};
        LIST_OF_ARRAYS.insert(LIST_CAPACITY/30, arrayToInsert);
        assertEquals(arrayToInsert, LIST_OF_ARRAYS.get(LIST_CAPACITY/30));
        assertEquals(ARRAY_ELEMENT, LIST_OF_ARRAYS.get(LIST_CAPACITY/30-1));
        assertEquals(ARRAY_ELEMENT, LIST_OF_ARRAYS.get(LIST_CAPACITY/30+1));
    }

    @Test
    void remove() {
        LIST_OF_STRINGS.remove(LIST_CAPACITY/7);
        assertEquals(STRING_ELEMENT, LIST_OF_STRINGS.get(LIST_CAPACITY/7-1));
        assertEquals(STRING_ELEMENT, LIST_OF_STRINGS.get(LIST_CAPACITY/7+1));

        LIST_OF_INTEGERS.remove(LIST_CAPACITY/9);
        assertEquals(INT_ELEMENT, LIST_OF_INTEGERS.get(LIST_CAPACITY/9+1));
        assertEquals(INT_ELEMENT, LIST_OF_INTEGERS.get(LIST_CAPACITY/9-1));

        LIST_OF_ARRAYS.remove(LIST_CAPACITY/32);
        assertEquals(ARRAY_ELEMENT, LIST_OF_ARRAYS.get(LIST_CAPACITY/32-1));
        assertEquals(ARRAY_ELEMENT, LIST_OF_ARRAYS.get(LIST_CAPACITY/32+1));
    }
}