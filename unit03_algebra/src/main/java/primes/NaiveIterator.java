package primes;

public class NaiveIterator extends PrimesCalculator {

    public NaiveIterator(IConvertor convertor) {
        super(convertor);
    }

    @Override
    public int[] getPrimesUpTo(int limit) {

        for (int i = 2; i <= limit; i++)
        {
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

        return _convertor.listToArray(_resultArray);
    }
}
