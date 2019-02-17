package Sorter.MergeSorter;

import Sorter.SorterTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MergeSorterAccountingAlreadySortedTest extends SorterTest {

    @BeforeEach
    public void setUp() {
        super.setUp();
        _sorter = new MSorterAccountingAlreadySorted(new BasicMerger());
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