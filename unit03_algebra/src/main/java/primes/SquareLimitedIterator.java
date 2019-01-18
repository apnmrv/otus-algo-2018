package primes;

public class SquareLimitedIterator extends PrimesCalculator {

    protected SquareLimitedIterator(IConvertor convertor) {
        super(convertor);
    }

    @Override
    public int[] getPrimesUpTo(int limit) {

        _resultArray.add(2);

        for (int i = 3; i <= limit; i+=2)
        {
            boolean isPrime = true;

            for(int j = 3; j*j <= i; j++)
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
