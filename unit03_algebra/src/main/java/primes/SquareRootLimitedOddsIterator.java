package primes;

public class SquareRootLimitedOddsIterator extends PrimesCalculator {

    @Override
    public Object[] getPrimesUpTo(int limit) {

        _resultArray.add(2);

        for (int i = 3; i <= limit; i+=2)
        {
            boolean isPrime = true;
            double root = Math.sqrt(i);

            for(int j = 3; j <= root; j++)
            {
                if(i % j == 0){
                    isPrime = false; break;
                }
            }
            if(isPrime) {
                _resultArray.add(i);
            }
        }

        return _resultArray.toArray();
    }
}
