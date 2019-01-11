package fibonacci.Calculator;

import java.math.BigInteger;

public class Recursion extends FibonacciCalculator {
    @Override
    BigInteger fibonacci(int number) {
        if(number < 3) {
            return BigInteger.ONE;
        }
        return fibonacci(number-1).add(fibonacci(number-2));
    }
}
