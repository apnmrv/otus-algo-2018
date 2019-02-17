package Sorter.MergeSorter;

import Sorter.SorterTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MergeSorterUsingCopyOptimizationTest extends SorterTest {

    @BeforeEach
    public void setUp() {
        super.setUp();
        _sorter = new MSorterUsingCopyOptimization(new BasicMerger());
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