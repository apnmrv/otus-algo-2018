package primes;

import java.util.ArrayList;

public class CribrumEratosthenisWithBytes extends PrimesCalculator {

    private ArrayList<Byte> _sieve = new ArrayList<>();

    @Override
    public Object[] getPrimesUpTo(int limit) {

        int number;
        fillSieve(limit);
        _resultArray.add(2);

        while(!_sieve.isEmpty()){
            number = _sieve.remove(0);
            _resultArray.add(number);
            sieveBy(number);
        }

        return _resultArray.toArray();
    }

    private void sieveBy(int divisor) {

        int divident;
        int size = _sieve.size();

        for(int i = 0; i < size; i++){
            divident = _sieve.get(i);
            if(0 == divident % divisor) {
                _sieve.remove(i);
                size--;
            }
        }
    }

    private void fillSieve(int limit) {
        for (int i = 3; i <= limit; i+=2) {
            _sieve.add(i, (byte) 1);
        }
    }
}
