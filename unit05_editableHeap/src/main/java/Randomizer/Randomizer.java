package Randomizer;

import java.util.HashMap;
import java.util.Map;

public class Randomizer implements IRandomizer {

    @Override
    public int[] getRandomeSequence(int min, int max, int size) {

        int [] result = new int[size];

        for(int i = 0; i < size; i++)
        {
            result[i] = (int) (Math.random()*((max-min)+1))+min;
        }

        return result;
    }

    public int[] getUniques(int min, int max, int size){
        int [] result = new int [size];
        Map<Integer, Integer> temp = new HashMap();

        while(temp.size() <= size)
        {
            int number = (int) (Math.random()*((max-min)+1))+min;
            if(!temp.containsKey(number)){
                temp.put(number, number);
            }
        }
        for(int i = 0 ; i < size ; i++) {
            result[i] = temp.get(i);
        }
        return result;
    }
}
