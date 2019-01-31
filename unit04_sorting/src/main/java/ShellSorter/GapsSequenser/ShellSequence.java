package ShellSorter.GapsSequenser;

import java.util.ArrayList;

public class ShellSequence implements IGapsSequence {

    private ArrayList<Integer> _gaps;

    public ShellSequence()
    {
        _gaps = new ArrayList<>();
    }

    @Override
    public int[] sequence(int limit)
    {
        for ( int num = limit/2; num > 1; num /= 2 )
        {
            _gaps.add(num);
        }
        _gaps.add(1);

        return toIntegersArray(_gaps);
    }

    private int[] toIntegersArray(ArrayList<Integer> gaps) {
        int[]result = new int[gaps.size()];
        int idx = 0;
        for(int gap : gaps) {
            result [idx] = gap;
            idx++;
        }
        return result;
    }
}
