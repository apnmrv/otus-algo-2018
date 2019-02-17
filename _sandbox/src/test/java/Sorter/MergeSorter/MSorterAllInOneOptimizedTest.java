package Sorter.MergeSorter;

import Sorter.InsertionSorter.InsertionSorter;
import Sorter.SorterTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MSorterAllInOneOptimizedTest extends SorterTest {

    @BeforeEach
    public void setUp() {
        super.setUp();
        _sorter = new MSorterAllInOneOptimized(new BasicMerger(), new InsertionSorter(), 15);
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