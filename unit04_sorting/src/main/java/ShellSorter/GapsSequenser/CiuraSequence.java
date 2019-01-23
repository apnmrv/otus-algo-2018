package ShellSorter.GapsSequenser;

public class CiuraSequence implements IGapsSequence {

    private static int [] ciuraGaps = {1,4,10,23,57,132,301,701};

    @Override
    public int[] getGapsUpto(int number) {
        return ciuraGaps;
    }
}
