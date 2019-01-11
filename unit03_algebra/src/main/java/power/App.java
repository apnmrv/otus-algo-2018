package power;

import power.Calculator.Calculator;
import power.Calculator.ExponentiationBySquaring;
import power.Calculator.SimpleIteration;

import java.math.BigDecimal;

public class App {

    private static long lStartTime;
    private static long lEndTime;
    private static BigDecimal result;

    public static void main(String[] args) {

        int base = 3;
        int exp = 80;

        Calculator sCalc = new SimpleIteration(); // O(2^n) runtime; 0(n) stack
        lStartTime = System.nanoTime();
        result = sCalc.power(base, exp);
        lEndTime = System.nanoTime();

        System.out.printf("SIMPLE ITERATION%n");
        output(result, calcExecTime());

        Calculator qCalc = new ExponentiationBySquaring(); // O(2^n) runtime; 0(n) stack
        lStartTime = System.nanoTime();
        result = qCalc.power(base, exp);
        lEndTime = System.nanoTime();

        System.out.printf("QUICK ITERATION%n");
        output(result, calcExecTime());
    }

    private static long calcExecTime() {
        return lEndTime - lStartTime;
    }

    private static void output(BigDecimal result, long execTime) {
        System.out.printf("Execution time(mcs): %d%n", execTime/1_000);
        System.out.printf("Result : %s", result.toString());
        System.out.printf("%n%n");
    }
}
