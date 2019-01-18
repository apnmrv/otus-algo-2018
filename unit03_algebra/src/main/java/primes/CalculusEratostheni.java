package primes;

import java.util.ArrayList;

public class CalculusEratostheni extends PrimesCalculator {

    private ArrayList<Integer> _numbersToTest = new ArrayList<>();

    protected CalculusEratostheni(IConvertor convertor) {
        super(convertor);
    }

    @Override
    public int[] getPrimesUpTo(int limit) {

        _resultArray.add(2);
        for(int i = 3; i <= limit; i ++)
        {
            _numbersToTest.add(i);
        }

        for(int j = number : _numbersToTest){

        }

        {
            boolean isPrime = true;
            double root = Math.sqrt(i);

            for(int j = 2; j <= root; j++)
            {
                if(i % j == 0){
                    isPrime = false; break;
                }
            }
            if(isPrime) {
                _resultArray.add(i);
            }
        }

        return _convertor.listToArrAy(_resultArray);
    }
}
