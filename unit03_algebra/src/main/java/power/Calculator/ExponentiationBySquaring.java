package power.Calculator;

import java.math.BigDecimal;

public class ExponentiationBySquaring extends Calculator {
    @Override
    public BigDecimal power(int base, int exponent) {
        BigDecimal result = new BigDecimal(1);
        BigDecimal b = new BigDecimal(base);

        while (0 != exponent){
            if(1 == exponent%2) {
                result = result.multiply(b);
                exponent--;
            }
            exponent /= 2;
            b = b.multiply(b);
        }

        return result;
    }
}
