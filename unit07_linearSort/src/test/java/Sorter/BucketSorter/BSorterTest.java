package Sorter.BucketSorter;

import Sorter.SorterTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BSorterTest extends SorterTest {
    @BeforeEach
    public void setUp() {
        super.setUp();
        _sorter = new BSorter();
    }

    @Test
    public void canSortPositiveIntegers(){
        super.canSortPositiveIntegers();
    }

    @Test
    public void testEqualsSequencesSorting(){
        super.testEqualsSequencesSorting();
    }
}