package fibonacci.Calculator;

import java.math.BigInteger;
/*
 * [1 1]^n   [F(n+1) F(n)  ]
 * [1 0]   = [F(n)   F(n-1)]
 */
public class Matrix extends FibonacciCalculator{
    private static final BigInteger[] _matrix = {
            BigInteger.ONE,
            BigInteger.ONE,
            BigInteger.ONE,
            BigInteger.ZERO
    };
    private static final BigInteger[] _zeroPowerMatrix = {
            BigInteger.ONE,
            BigInteger.ZERO,
            BigInteger.ZERO,
            BigInteger.ONE};

    @Override
    BigInteger fibonacci(int number) {
        return matrixPow(_matrix, number)[1];
    }

    // Возведение в степень
    private BigInteger[] matrixPow(BigInteger[] matrix, int n) {
        BigInteger[] result = _zeroPowerMatrix;
        while (0 != n) {
            if (0 != n % 2) {
                result = matrixMultiply(result, matrix);
            }
            n /= 2;
            matrix = matrixMultiply(matrix, matrix);
        }
        return result;
    }

    // Пермножение матриц
    private BigInteger[] matrixMultiply(BigInteger[] x, BigInteger[] y) {
        return new BigInteger[] {
                multiply(x[0], y[0]).add(multiply(x[1], y[2])),
                multiply(x[0], y[1]).add(multiply(x[1], y[3])),
                multiply(x[2], y[0]).add(multiply(x[3], y[2])),
                multiply(x[2], y[1]).add(multiply(x[3], y[3]))
        };
    }

    // Перемножение двух BigInteger
    private static BigInteger multiply(BigInteger x, BigInteger y) {
        return x.multiply(y);
    }
}
