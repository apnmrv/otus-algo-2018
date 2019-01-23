package ShellSorter.GapsSequenser;

public class TokudaSequencer implements IGapsSequence{

    @Override
    public int[] getGapsUpto(int number) {
        int [] tokudaGaps = new int[number];
        tokudaGaps[0] = 1;

        for (int i = 1; tokudaGaps[i-1] < number; i++)
        {
            tokudaGaps[i] = (9*(9/4)^(i-1)-4)/5;
        }

        return tokudaGaps;
    }
}
