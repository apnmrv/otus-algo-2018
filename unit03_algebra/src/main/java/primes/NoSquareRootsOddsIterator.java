package primes;

public class NoSquareRootsOddsIterator extends PrimesCalculator {

    @Override
    public Object[] getPrimesUpTo(int limit) {

        _resultArray.add(2);

        for (int i = 3; i <= limit; i += 2)
        {
            double sqrt = Math.sqrt(i);
            if(0 == sqrt - (int)sqrt){
                continue;
            }
            boolean isPrime = true;
            for(int j = i-1; j > 1; j--)
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
