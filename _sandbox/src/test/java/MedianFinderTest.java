import MedianOfMedians.MedianFinder;
import Randomizer.IRandomizer;
import Randomizer.Randomizer;
import Sorter.ISorter;
import Sorter.QuickSorter.HoareQSorter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MedianFinderTest {

    private static final int TESTS_NUMBER = 100;

    private static final int MIN = 0;
    private static final int MAX = 1000;
    private static final int SIZE = 1000;

    MedianFinder __finder;
    private int[] __randomArray;
    private int[] __randomArraySorted;

    public void setUp() {
        IRandomizer r = new Randomizer();
        ISorter s = new HoareQSorter();

        __finder = new MedianFinder();

        __randomArray = r.getRandomSequence(MIN, MAX, SIZE);

        __randomArraySorted = __randomArray.clone();
        try {
            s.sort(__randomArraySorted);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void canSelectNthSmallestElement(){

        for (int counter = 1; counter <= TESTS_NUMBER; counter++) {

            setUp();

            int medianFound = __finder.median(__randomArray);

            assertEquals(__randomArraySorted[__randomArraySorted.length/2], medianFound);
        }
    }
}