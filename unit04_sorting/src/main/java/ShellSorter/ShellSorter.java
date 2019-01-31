package ShellSorter;

import Main.ISorter;
import ShellSorter.GapsSequenser.IGapsSequence;

public class ShellSorter implements ISorter {

    private static final String TITLE = "Shell Sort";
    private IGapsSequence _sequence;

    public ShellSorter(IGapsSequence sequence) {
        this._sequence = sequence;
    }

    @Override
    public int[] sort(int[] numbers) {

        int size = numbers.length;
        int [] gaps = _sequence.sequence(size);
        int steps = gaps.length;
        int i,j,key;

        for(int s = 0; s < steps; s++)
        {
            int gap = gaps[s];
            for(i = gap; i < size; i++)
            {
                key = numbers[i];
                for(j = i; gap <= j && key < numbers[j-gap]; j -= gap)
                {
                    numbers[j] = numbers[j-gap];
                }
                numbers[j] = key;
            }
        }

        return numbers;
    }

    @Override
    public String title() {
        return TITLE;
    }
}
