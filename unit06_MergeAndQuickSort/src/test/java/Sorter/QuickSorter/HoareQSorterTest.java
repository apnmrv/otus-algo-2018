package Sorter.QuickSorter;

import Sorter.SorterTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;

class HoareQSorterTest extends SorterTest {

    @BeforeEach
    public void setUp() {
        super.setUp();
        _sorter = new HoareQSorter();
    }

    @Test
    public void testRandomSequencesSorting(){
        super.testRandomSequencesSorting();
    }

    @Test
    void testCanSortEqualsSequences(){
        super.testEqualsSequencesSorting();
    }
}