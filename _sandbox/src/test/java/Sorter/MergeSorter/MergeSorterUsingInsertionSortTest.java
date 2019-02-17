package Sorter.MergeSorter;

import Sorter.InsertionSorter.InsertionSorter;
import Sorter.SorterTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MergeSorterUsingInsertionSortTest extends SorterTest {

    @BeforeEach
    public void setUp() {
        super.setUp();
        _sorter = new MSorterUsingInsertionSort(new BasicMerger(), new InsertionSorter(), 32);
    }

    @Test
    public void testRandomSequencesSorting(){
        super.testRandomSequencesSorting();
    }

    @Test
    public void testEqualsSequencesSorting(){
        super.testEqualsSequencesSorting();
    }
}