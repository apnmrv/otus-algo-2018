package fibonacci.Calculator;

import java.math.BigInteger;

public class Memoization extends FibonacciCalculator {

    @Override
    BigInteger fibonacci(int number) {
        BigInteger f = _sequence.get(number);
        if(null != f)
        {
            return f;
        } else {
            return fibonacci(number-1).add(fibonacci(number-2));
        }
    }
}
