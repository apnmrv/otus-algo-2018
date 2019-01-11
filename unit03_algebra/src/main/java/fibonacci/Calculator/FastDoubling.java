package fibonacci.Calculator;

import java.math.BigInteger;

public class FastDoubling extends FibonacciCalculator{

    @Override
    BigInteger fibonacci(int number) {
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        int m = 0;
        for (int bit = Integer.highestOneBit(number); bit != 0; bit >>>= 1) {

            assert a.equals(slowFibonacci(m));
            assert b.equals(slowFibonacci(m+1));

            BigInteger d = multiply(a, b.shiftLeft(1).subtract(a));
            BigInteger e = multiply(a, a).add(multiply(b, b));
            a = d;
            b = e;
            m *= 2;
            assert a.equals(slowFibonacci(m));
            assert b.equals(slowFibonacci(m+1));

            if ((number & bit) != 0) {
                BigInteger c = a.add(b);
                a = b;
                b = c;
                m++;
                assert a.equals(slowFibonacci(m));
                assert b.equals(slowFibonacci(m+1));
            }
        }
        return a;
    }

    private static BigInteger slowFibonacci(int n) {
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        for (int i = 0; i < n; i++) {
            BigInteger c = a.add(b);
            a = b;
            b = c;
        }
        return a;
    }

    private static BigInteger multiply(BigInteger x, BigInteger y) {
        return x.multiply(y);
    }
}
