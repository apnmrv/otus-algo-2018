import Randomizer.IRandomizer;
import Randomizer.Randomizer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SplitterTest {

    private static final int MIN = 0;
    private static final int MAX = 1000;

    private static IRandomizer __randomizer = new Randomizer();

    @Test
    public void testCanSplit(){
        for (int k = 0; k < 1000; k ++) {
            int [] ar = __randomizer.getUniques(MIN, MAX);
            Splitter s = new Splitter();
            int pivotIdx = s.split(ar, 0, ar.length-1);
            for (int i = 0; i < pivotIdx; i++)
                assertTrue(ar[i] < pivotIdx);
            for (int j = pivotIdx+1; j < ar.length; j++)
                assertTrue(ar[j] > pivotIdx);
        }
    }
}