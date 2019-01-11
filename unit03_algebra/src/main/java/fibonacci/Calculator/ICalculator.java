package fibonacci.Calculator;

import java.math.BigInteger;
import java.util.Map;

public interface ICalculator {
    Map<Integer, BigInteger> getSequence(int size);
}
