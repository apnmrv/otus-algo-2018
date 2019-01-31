package Main;

public class Randomizer implements IRandomizer {

    private int [] result;

    @Override
    public int[] getIntegers(int min, int max, int size) {

        result = new int[size];

        for(int i = 0; i < size; i++)
        {
            result [i] = (int) (Math.random()*((max-min)+1))+min;
        }

        return result;
    }
}
