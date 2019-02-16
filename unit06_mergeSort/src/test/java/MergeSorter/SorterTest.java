package MergeSorter;

import Randomizer.IRandomizer;
import Randomizer.Randomizer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SorterTest {

    private static final int MIN = 1;
    private static final int MAX = 10;
    private static final int SIZE = 10;
    private static int[] _arrayIn;

    @BeforeAll
    public static void setUp() {
        IRandomizer r = new Randomizer();
        _arrayIn = r.getRandomSequence(MIN, MAX, SIZE);
    }

    @Test
    void canSortRandomSequences(){
        ISorter s = new SimpleMergeSorter();
        int [] arrayOut = s.sort(_arrayIn);
        for(int i = 0; i < arrayOut.length-1; i++) {
            if(arrayOut[i]>arrayOut[i+1])
                fail("Check your code, pal");
        }
        assertTrue(true);
    }
}