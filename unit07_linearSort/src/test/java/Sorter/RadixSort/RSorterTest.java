package Sorter.RadixSort;

import Sorter.SorterTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RSorterTest extends SorterTest {
    @BeforeEach
    public void setUp() {
        super.setUp();
        _sorter = new RSorter();
    }

    @Test
    public void canSortPositiveIntegers(){
        super.canSortPositiveIntegers();
    }

    @Test
    public void testEqualsSequencesSorting(){
        super.testEqualsSequencesSorting();
    }

    @Test
    public void canSortNegativeIntegers(){
        super.canSortNegativeIntegers();
    }
}