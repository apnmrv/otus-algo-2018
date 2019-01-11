package fibonacci.Calculator;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

abstract public class FibonacciCalculator implements ICalculator {

    Map<Integer, BigInteger> _sequence;
    BigInteger _fNum = BigInteger.ZERO;

    FibonacciCalculator(){
    };

    public Map<Integer, BigInteger> getSequence(int size){
        _sequence = new HashMap<>();
        _sequence.put(0, BigInteger.ZERO);

        for(int i = 1; i < size; i++){
            if (i < 2) {
                _fNum = BigInteger.ONE;
            } else {
                _fNum = fibonacci(i);
            }
            _sequence.put(i, _fNum);
        }
        return _sequence;
    }

    abstract BigInteger fibonacci(int number);
}
