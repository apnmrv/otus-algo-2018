package Randomizer;

public interface IRandomizer {

    public int[] getRandomSequence(int min, int max, int size);
    
    public int[] getUniques(int min, int max);

    public int getRandomValue(int min, int max);
}
