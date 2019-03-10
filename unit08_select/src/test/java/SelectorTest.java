import Randomizer.IRandomizer;
import Randomizer.Randomizer;
import Sorter.QuickSorter.HoareQSorter;
import Sorter.QuickSorter.ISorter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SelectorTest {

    private static final int MIN = 0;
    private static final int MAX = 100;

    ISelector __selector;
    private int[] __randomArray;
    private int[] __randomArraySorted;


    @BeforeEach
    public void setUp(){
        IRandomizer r = new Randomizer();
        ISorter s = new HoareQSorter();
        __selector = new Selector();
        __randomArray = r.getUniques(MIN, MAX);
        __randomArraySorted = __randomArray.clone();
        s.sort(__randomArraySorted);
    }

    @Test
    public void canSelectNthSmallestElement(){

        for(int i = 1; i <= __randomArray.length; i++) {
            int eSelected = __selector.select(__randomArray, i);
            assertEquals(__randomArraySorted[i-1], eSelected);
        }
    }
}