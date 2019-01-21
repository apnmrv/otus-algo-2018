package primes;

public class CribrumEratosthenisAdvanced extends PrimesCalculator {

    private byte [] _sieve;
    private int _currentPrimeIndex;
    private int _previousPrimeIndex;
    private int _limit;

    @Override
    public Object[] getPrimesUpTo(int limit) {
        initSieve(limit);

        while(_currentPrimeIndex != _previousPrimeIndex){
            sieve();
            _resultArray.add(_currentPrimeIndex);
            shiftIndices();
        }
        return _resultArray.toArray();
    }

    private void shiftIndices() {
        _previousPrimeIndex = _currentPrimeIndex;
        for(int i = _currentPrimeIndex+1; i <= _limit; i++) {
            if(0 == _sieve[i]) {
                _currentPrimeIndex = i;
                break;
            }
        }
    }

    private void initSieve(int limit) {
        _limit = limit;
        _sieve = new byte[_limit+1];
        _previousPrimeIndex = 0;
        _currentPrimeIndex = 2;
    }

    private void sieve() {
        for(int i=_currentPrimeIndex*2; i<=_limit; i += _currentPrimeIndex){
            _sieve[i] = 1;
        }
    }
}
