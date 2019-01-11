package power.Calculator;

import java.math.BigDecimal;

public class SimpleIteration extends Calculator {

    @Override
    public BigDecimal power(int base, int exponent) {
        BigDecimal result = new BigDecimal(1);
        BigDecimal b = new BigDecimal(base);

        while (0 != exponent){
            result = result.multiply(b);
            exponent --;
        }

        return result;
    }
}
