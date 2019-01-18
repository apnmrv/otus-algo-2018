package primes;

import java.util.ArrayList;

abstract class PrimesCalculator implements ICalculator {

    protected ArrayList<Integer> _resultArray = new ArrayList<>();
    protected IConvertor _convertor;

    protected PrimesCalculator(IConvertor convertor) {
        _convertor = convertor;
    }
}
