import Randomizer.IRandomizer;
import Randomizer.Randomizer;
import Sorter.QuickSorter.HoareQSorter;
import Sorter.QuickSorter.ISorter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MedianOfMediansSelectorTest {

    private static final int TESTS_NUMBER = 100;

    private static final int MIN = 0;
    private static final int MAX = 1000;
    private static final int SIZE = 1000;

    ISelector __selector;
    private int[] __randomUniquesArray;
    private int[] __randomUniquesArraySorted;
    private int[] __randomArray;
    private int[] __randomArraySorted;

    public void setUp(){
        IRandomizer r = new Randomizer();
        ISorter s = new HoareQSorter();

        __selector = new MedianOfMediansSelector();
        __randomUniquesArray = r.getUniques(MIN, MAX);
        __randomArray = r.getRandomeSequence(MIN, MAX, SIZE);
        __randomUniquesArraySorted = __randomUniquesArray.clone();
        __randomArraySorted = __randomArray.clone();
        s.sort(__randomUniquesArraySorted);
        s.sort(__randomArraySorted);
    }

    @Test
    public void canSelectNthSmallestElementFromASequenceOfUniqueNumbers(){

        for (int counter = 1; counter <= TESTS_NUMBER; counter++) {

            setUp();

            for(int i = 1; i <= __randomUniquesArray.length; i++) {
                int eSelected = __selector.select(__randomUniquesArray, i);
                assertEquals(__randomUniquesArraySorted[i-1], eSelected);
            }
        }
    }

    @Test
    public void canSelectNthSmallestElementFromASequenceWithRepeatedNumbers(){

        for (int counter = 1; counter <= TESTS_NUMBER; counter++) {

            setUp();

            for(int i = 1; i <= __randomArray.length; i++) {
                int eSelected = __selector.select(__randomArray, i);
                assertEquals(__randomArraySorted[i-1], eSelected);
            }
        }
    }
}