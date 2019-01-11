package fibonacci;

import fibonacci.Calculator.*;

import java.math.BigInteger;
import java.util.Map;

public class App {

    private static Map<Integer, BigInteger> _resultSet;
    private static int number;

    public static void main(String[] args) {
        number = 2300;

        if(number < 45){
            FibonacciCalculator rCalc = new Recursion(); // O(2^n) runtime; 0(n) stack
            long estimation = estimate(rCalc, number);

            System.out.printf("RECURSION%n");
            output(_resultSet, estimation);
        }

        if(number < 2500) {
            FibonacciCalculator mCalc = new Memoization(); // O(n) runtime; O(n) space; no stack
            long estimation = estimate(mCalc, number);

            System.out.printf("MEMOISATION%n");
            output(_resultSet, estimation);
        }

//        if (number < 5000) {
//            FibonacciCalculator iCalc = new SimpleIteration(); // O(n) runtime; O(1) space; no stack
//            long estimation = estimate(iCalc, number);
//
//            System.out.printf("ITERATION%n");
//            output(_resultSet, estimation);
//        }

        if (number < 5000) {
            FibonacciCalculator matrixCalc = new Matrix(); // O(log(n))
            long estimation = estimate(matrixCalc, number);

            System.out.printf("MATRIX%n");
            output(_resultSet, estimation);
        }
//
//        if (number < 5000) {
//            FibonacciCalculator fdCalc = new FastDoubling(); // O(log(n))
//            long estimation = estimate(fdCalc, number);
//
//            System.out.printf("DOUBLING%n");
//            output(_resultSet, estimation);
//        }
    }

    private static long estimate(ICalculator calc, int number) {
        _resultSet = null;
        long startTime = System.nanoTime();
        _resultSet = calc.getSequence(number);
        long endTime = System.nanoTime();

        return (endTime-startTime);
    }

    private static void output(Map result, long execTime) {
        System.out.printf("Execution time(ms): %d%n", execTime/1_000_000);
        for (int i = 0; i < number; i++){
            System.out.printf("%s, ", result.get(i).toString());
        }
        System.out.printf("%n%n");
    }
}
