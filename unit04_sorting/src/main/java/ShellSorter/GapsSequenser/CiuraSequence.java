package ShellSorter.GapsSequenser;

public class CiuraSequence implements IGapsSequence {

    private static int [] ciuraGaps = {701, 301, 132, 57, 23, 10, 4, 1};

    @Override
    public int[] sequence(int number) {
        return ciuraGaps;
    }
}
