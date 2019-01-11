package fibonacci.Calculator;

import java.math.BigInteger;
import java.util.Hashtable;

public class Memoization extends FibonacciCalculator {

    private Hashtable<Integer, BigInteger> _results = null;
    private int _number;

    @Override
    BigInteger fibonacci(int number) {

        if(null == _results) {
            init(number);
        }
        if(number < 2) {
            return _results.get(number);
        }
        if(null == _results.get(number)) {
            _results.put(number, fibonacci(number-1).add(fibonacci(number-2)));
        }

        return _results.get(number);
    }

    private void init(int number) {
        _results = new Hashtable<>();
        _results.put(0, BigInteger.ZERO);
        _results.put(1, BigInteger.ONE);
    }
}
