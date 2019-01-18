package primes;

import java.util.Iterator;

public class PrimesOnlyAsDivisorsIterator extends PrimesCalculator{

    protected PrimesOnlyAsDivisorsIterator(IConvertor convertor) {
        super(convertor);
    }

    @Override
    public int[] getPrimesUpTo(int limit) {

        _resultArray.add(2);

        for (int i = 3; i <= limit; i += 2)
        {
            boolean isPrime = true;
            double root = Math.sqrt(i);

            for(int prime : _resultArray) {
                if(prime > root) break;
                if(0 == i % prime) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                _resultArray.add(i);
            }
        }

        return _convertor.listToArrAy(_resultArray);
    }
}
