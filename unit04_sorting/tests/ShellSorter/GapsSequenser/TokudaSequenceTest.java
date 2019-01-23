package ShellSorter.GapsSequenser;

import org.junit.jupiter.*;

class TokudaSequenceTest {

    private IGapsSequence _sequencer;

    public void testReturnsAppropriateSequence(){

        _sequencer = new TokudaSequencer();

        int [] gaps = new int[5];

        gaps = _sequencer.getGapsUpto(105);

    }
}