package Sorter;

import java.util.HashMap;
import java.util.Map;

public class Randomizer implements IRandomizer {

    @Override
    public int[] getRandomSequence(int min, int max, int size) {

        int [] result = new int[size];

        for(int i = 0; i < size; i++)
        {
            result[i] = (int) (Math.random()*((max-min)+1))+min;
        }

        return result;
    }

    public int[] getUniques(int min, int max){
        int size = max - min +1;

        int [] result = new int [size];
        Map<Integer, Integer> temp = new HashMap();

        int i = 0;
        while(i < size)
        {
            int number = (int) (Math.random()*((max-min)+1))+min;
            if(!temp.containsKey(number)){
                temp.put(number, number);
                result[i] = number;
                i++;
            }
        }
        return result;
    }
}
