package MergeSorter;

import Randomizer.IRandomizer;
import Randomizer.Randomizer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SorterTest {

    @Test
    void sort() {

        ISorter s = new SimpleMergeSorter();
        IRandomizer r = new Randomizer();

        int [] arrIn = r.getUniques(1, 10);
        int [] arrOut = s.sort(arrIn);

        int [] arrExpected = {1,2,3,4,5,6,7,8,9,10};

        assertArrayEquals(arrExpected, arrOut);
    }
}