package Sorter.QuickSorter;

import Randomizer.Randomizer;
import Sorter.ArrayHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class HoarSplitterTest {

    private HoarSplitter __splitter;
    private int [] __randomSequence;
    private int [] __equalsSequence;
    private int [] __uniquesSequence;

    @BeforeEach
    void setUp() {
        __splitter = new HoarSplitter(new ArrayHelper());
        __randomSequence = (new Randomizer()).getRandomSequence(0, 10, 10);
        __uniquesSequence = (new Randomizer()).getUniques(0, 9);
        __equalsSequence = new int [] { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 };
    }

    @Test
    void testSplitsRandomSequenceAsRequired(){

        int pivotIdx = __splitter.split(__randomSequence, 0, __randomSequence.length-1);

        assertTrue(isSplittedProperly(pivotIdx, __randomSequence));
    }

    @Test
    void testSplitsSequenceOfEqualsAsRequired(){

        int pivot = __splitter.split(__equalsSequence, 0, __equalsSequence.length-1);

        assertTrue(isSplittedProperly(pivot, __equalsSequence));
    }

    boolean isSplittedProperly(int pivotIdx, int [] array){

        int i = 0;
        int j = array.length-1;

        while (i < pivotIdx-1) {
            if(array[i] > array[pivotIdx]) {
                return false;
            }
            i++;
        }

        while(j > pivotIdx+1){
            if(array[j] < array[pivotIdx]) {
                return false;
            }
            j--;
        }

        return true;
    }
}