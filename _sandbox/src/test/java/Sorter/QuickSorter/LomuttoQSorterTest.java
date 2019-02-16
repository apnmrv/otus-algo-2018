package Sorter.QuickSorter;

import Sorter.ArrayHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LomuttoQSorterTest extends QSorterTest{

    @BeforeEach
    void setUp() {
        super.setUp();
        _qSorter = new LomutoQSorter(new LomutoSplitter(new ArrayHelper()));
    }

    @Test
    void testRandomSequences(){
        super.testRandomSequencesSorting();
    }

    @Test
    void testCanSortEqualsSequences(){
        super.testEqualsSequencesSorting();
    }
}