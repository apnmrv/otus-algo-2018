package Sorter;

import Randomizer.Randomizer;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SorterTest {

    private static int SIZE = 1_000_000;
    private static int MIN = 0;
    private static int MAX = 10;
    private static int NEGATIVE_MIN = -10;
    private static int ROTATE_RANDOM = 100;

    private int[] __equalsArray;
    private Randomizer __randomizer;

    protected ISorter _sorter;;

    @BeforeEach
    public void setUp() {
        __randomizer = new Randomizer();
        __equalsArray = new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    }

    public void testRandomSequencesSorting(){
        for(int i = 0; i < ROTATE_RANDOM; i++) {
            int [] arr = __randomizer.getRandomSequence(MIN,MAX,SIZE);
            try {
                _sorter.sort(arr);
            } catch (Exception e) {
                e.printStackTrace();
            }
            assertTrue(isSortedProperly(arr));
        }
    }

    public void testEqualsSequencesSorting() {
        try {
            _sorter.sort(__equalsArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    protected void testSequencesWithNegativesSorting() {
        for(int i = 0; i < ROTATE_RANDOM; i++) {
            int [] arr = __randomizer.getRandomSequence(NEGATIVE_MIN,MAX,SIZE);
            try {
                _sorter.sort(arr);
            } catch (Exception e) {
                e.printStackTrace();
            }
            assertTrue(isSortedProperly(arr));
        }
    }
}