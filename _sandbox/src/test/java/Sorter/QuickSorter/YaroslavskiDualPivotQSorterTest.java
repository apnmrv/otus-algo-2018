package Sorter.QuickSorter;

import Sorter.SorterTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YaroslavskiDualPivotQSorterTest extends SorterTest {

    @BeforeEach
    public void setUp() {
        super.setUp();
        _sorter = new YaroslavskiDualPivotQSorter();
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