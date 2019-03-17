package Randomizer;

import java.util.HashMap;
import java.util.Map;

public class Randomizer implements IRandomizer{

    @Override
    public int[] getRandomSequence(int min, int max, int size) {

        int [] result = new int[size];

        for(int i = 0; i < size; i++)
        {
            result[i] = getRandomValue(min, max);
        }

        return result;
    }

    @Override
    public int[] getUniques(int min, int max){
        int size = max - min +1;

        int [] result = new int [size];
        Map<Integer, Integer> temp = new HashMap();

        int i = 0;
        while(i < size)
        {
            int number = getRandomValue(min, max);
            if(!temp.containsKey(number)){
                temp.put(number, number);
                result[i] = number;
                i++;
            }
        }
        return result;
    }

    @Override
    public int getRandomValue(int min, int max) {
        return (int) (Math.random()*((max-min)+1))+min;
    }
}
