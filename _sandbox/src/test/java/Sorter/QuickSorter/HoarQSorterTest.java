package Sorter.QuickSorter;

import Sorter.ArrayHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;

class HoarQSorterTest extends QSorterTest {

    @BeforeEach
    void setUp() {
        super.setUp();
        _qSorter = new HoarQSorter(new HoarSplitter(new ArrayHelper()));
    }

    @Test
    protected void testRandomSequencesSorting(){
        super.testRandomSequencesSorting();
    }
}