package fibonacci.Calculator;

import java.math.BigInteger;

public class SimpleIteration extends FibonacciCalculator{

    private BigInteger [] _results;

    public SimpleIteration(){
        _results = new BigInteger[]{BigInteger.ONE, BigInteger.ONE};
    }

    @Override
    BigInteger fibonacci(int number) {
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        BigInteger f = BigInteger.valueOf(2);

        for(int i = 2; i < number; i++){
            f = a.add(b);
            a = b;
            b = f;
//            _results[i%2] = _results[0] + _results[1]; // вариант; работает медленнее в среднем
        }

        return f; // _results[number%2];
    }
}
