package primes;

import java.util.ArrayList;

public class Convertor implements IConvertor {

    @Override
    public int[] listToArrAy(ArrayList<Integer> list) {

        int num = list.size();

        int[] arr = new int [num];

        for (int i = 0; i < num; i++)
        {
            arr[i] = list.get(i);
        }

        return arr;
    }
}
