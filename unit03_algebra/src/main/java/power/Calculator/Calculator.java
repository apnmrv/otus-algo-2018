package power.Calculator;

import java.math.BigDecimal;

public abstract class Calculator implements ICalculator{

    @Override
    public abstract BigDecimal power(int base, int exponent);
}
