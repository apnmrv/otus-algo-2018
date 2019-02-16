package Sorter.QuickSorter;

import Randomizer.Randomizer;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertTrue;

class QSorterTest {

    private static int SIZE = 1000;
    private static int MIN = 0;
    private static int MAX = 1000;
    private static int ROTATE_RANDOM = 10;

    private int[] __randomArray;
    private int[] __equalsArray;
    private Randomizer __randomizer;

    protected QSorter _qSorter;

    @BeforeEach
    void setUp() {
        __randomizer = new Randomizer();
        __randomArray = __randomizer.getRandomSequence(MIN, MAX, SIZE);

        __equalsArray = new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    }

    void testRandomSequencesSorting(){
        for(int i = 0; i < ROTATE_RANDOM; i++) {
            int [] arr = __randomizer.getRandomSequence(MIN,MAX,SIZE);
            _qSorter.sort(arr);
            assertTrue(isSortedProperly(arr));
        }
    }

    void testEqualsSequencesSorting() {
        _qSorter.sort(__equalsArray);
        assertTrue(isSortedProperly(__equalsArray));
    }

    private boolean isSortedProperly(int[] array) {
        boolean result = true;
        for(int i = 0; i < array.length-1; i++){
            if(array[i]>array[i+1]){
                result = false;
                break;
            }
        }
        return result;
    }
}