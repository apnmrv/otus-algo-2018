package primes;

import java.util.ArrayList;

public class NoSquaresOddsIterator extends PrimesCalculator {

    private ArrayList<Integer> _numbers = new ArrayList<>();

    @Override
    public Object[] getPrimesUpTo(int limit) {
        _resultArray.add(2);
        fillNumbers(limit);
        removeSquares();

        for (int i = 3; i <= limit; i += 2)
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

        return _resultArray.toArray();
    }

    private void removeSquares() {

        for (int i = 0; i < _numbers.size(); i++) {

            for(int j = i+1; j < _numbers.size(); j++) {

                if(_numbers.get(j) == _numbers.get(i)*_numbers.get(i))
                {
                    _numbers.remove(j);
                }
            }
        }
    }

    private void fillNumbers(int limit) {
        for(int i = 3; i <= limit; i += 2) {
            _numbers.add(i);
        }
    }
}
