package Sorter.QuickSorter;

import Sorter.SorterTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LomuttoQSorterTest extends SorterTest {

    @BeforeEach
    public void setUp() {
        super.setUp();
        _sorter = new LomutoQSorter();
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