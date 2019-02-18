package Sorter.QuickSorter;

import Sorter.SorterTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OptimizedQSorterWithRandomPivotTest extends SorterTest {

    @BeforeEach
    public void setUp() {
        super.setUp();
        _sorter = new QSorterUsingRandomPivot(15);
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