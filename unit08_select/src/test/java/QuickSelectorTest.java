import Randomizer.IRandomizer;
import Randomizer.Randomizer;
import Sorter.QuickSorter.HoareQSorter;
import Sorter.QuickSorter.ISorter;
import Sorter.QuickSorter.Splitter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSelectorTest {

    private static final int TESTS_NUMBER = 100;

    private static final int MIN = 0;
    private static final int MAX = 100;

    ISelector __selector;
    private int[] __randomArray;
    private int[] __randomArraySorted;

    public void setUp(){
        IRandomizer r = new Randomizer();
        ISorter s = new HoareQSorter();

        __selector = new QuickSelector();
        __randomArray = r.getUniques(MIN, MAX);
        __randomArraySorted = __randomArray.clone();
        s.sort(__randomArraySorted);
    }

    @Test
    public void canSelectNthSmallestElement(){

        for (int counter = 1; counter <= TESTS_NUMBER; counter++) {

            setUp();

            for(int i = 1; i <= __randomArray.length; i++) {
                int eSelected = __selector.select(__randomArray, i);
                assertEquals(__randomArraySorted[i-1], eSelected);
            }
        }
    }
}