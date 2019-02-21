package Sorter.CountingSorter;

import Sorter.SorterTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CSorterTest extends SorterTest {
    @BeforeEach
    public void setUp() {
        super.setUp();
        _sorter = new CSorter();
    }

    @Test
    public void testRandomSequencesSorting(){
        super.testRandomSequencesSorting();
    }

    @Test
    public void testEqualsSequencesSorting(){
        super.testEqualsSequencesSorting();
    }

    @Test
    public void testSequencesWithNegativesSorting(){
        super.testSequencesWithNegativesSorting();
    }
}