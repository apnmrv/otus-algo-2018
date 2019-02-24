package Sorter.CountingSorter;

import Sorter.SorterTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CSorterTest extends SorterTest {
    @BeforeEach
    public void setUp() {
        super.setUp();
        _sorter = new CSorter();
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