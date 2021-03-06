package Sorter;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SorterTest {

    private static int SIZE = 100_000;
    private static int MIN = 0;
    private static int MAX = 10_000;
    private static int NEGATIVE_MIN = -1000;
    private static int ROTATE_RANDOM = 100;

    private int[] __equalsArray;
    private Randomizer __randomizer;

    protected ISorter _sorter;;

    @BeforeEach
    public void setUp() {
        __randomizer = new Randomizer();
        __equalsArray = new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    }

    public void canSortPositiveIntegers(){
        for(int i = 0; i < ROTATE_RANDOM; i++) {
            int [] arr = __randomizer.getRandomSequence(MIN,MAX,SIZE);

            try {
                _sorter.sort(arr);
            } catch (Exception e) {
                e.printStackTrace();
            }
            assertTrue(isSorted(arr));
        }
    }

    public void testEqualsSequencesSorting() {
        try {
            _sorter.sort(__equalsArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(isSorted(__equalsArray));
    }

    private boolean isSorted(int[] array) {
        boolean result = true;
        for(int i = 0; i < array.length-1; i++){
            if(array[i]>array[i+1]){
                result = false;
                break;
            }
        }
        return result;
    }

    protected void canSortNegativeIntegers() {
        for(int i = 0; i < ROTATE_RANDOM; i++) {
            int [] arr = __randomizer.getRandomSequence(NEGATIVE_MIN,MAX,SIZE);
            try {
                _sorter.sort(arr);
            } catch (Exception e) {
                e.printStackTrace();
            }
            assertTrue(isSorted(arr));
        }
    }
}