package fibonacchi;

public class App {
    /*
    * рекурсия --- плохое решение
    * a = 1
    * b = 1
    * для i от 1 до n
    * a = b
    * b = f
    *
    * 2-й вариант : через золотое сечение
    * https://habr.com/post/148336/
    * https://medium.com/@dimko1/%D0%B0%D0%BB%D0%B3%D0%BE%D1%80%D0%B8%D1%82%D0%BC%D1%8B-%D0%BD%D0%B0%D1%85%D0%BE%D0%B6%D0%B4%D0%B5%D0%BD%D0%B8%D0%B5-%D1%87%D0%B8%D0%BB%D1%81%D0%B0-%D1%84%D0%B8%D0%B1%D0%BE%D0%BD%D0%B0%D1%87%D1%87%D0%B8-b68a582b6374
    * https://ru.wikipedia.org/wiki/%D0%A7%D0%B8%D1%81%D0%BB%D0%B0_%D0%A4%D0%B8%D0%B1%D0%BE%D0%BD%D0%B0%D1%87%D1%87%D0%B8
    * https://ru.wikipedia.org/wiki/%D0%9B%D0%B8%D0%BD%D0%B5%D0%B9%D0%BD%D0%B0%D1%8F_%D1%80%D0%B5%D0%BA%D1%83%D1%80%D1%80%D0%B5%D0%BD%D1%82%D0%BD%D0%B0%D1%8F_%D0%BF%D0%BE%D1%81%D0%BB%D0%B5%D0%B4%D0%BE%D0%B2%D0%B0%D1%82%D0%B5%D0%BB%D1%8C%D0%BD%D0%BE%D1%81%D1%82%D1%8C
    * http://mech.math.msu.su/~shvetz/54/inf/perl-problems/chFibonacci_sIdeas.xhtml
    * http://algolist.manual.ru/maths/count_fast/fibonacci.php
    * */
    private static long lStartTime;
    private static long lEndTime;
    private static long [] resultArray;

    public static void main(String[] args) {
        int number = 40;

        lStartTime = System.nanoTime();
        resultArray = byRecursion(number);
        lEndTime = System.nanoTime();

        System.out.printf("RECURSION%n");
        output(resultArray, calcExecTime());

        lStartTime = System.nanoTime();
        resultArray = byMemoisation(number);
        lEndTime = System.nanoTime();

        System.out.printf("MEMOISATION%n");
        output(resultArray, calcExecTime());
    }

    private static long calcExecTime() {
        return lEndTime - lStartTime;
    }

    private static void output(long[] result, long execTime) {
        System.out.printf("Execution time(mcs): %d%n", execTime/1_000);
        for (long f: result){
            System.out.printf("%d, ", f);
        }
        System.out.printf("%n%n");
    }

    private static long [] byMemoisation(int number) {

        long [] result = new long[number];

        result[0] = 0;
        result[1] = 1;
        int j = 2;
        long a = 0;
        long b = 1;

        for (int i = 2; i < number; i++) {
            long f = a+b;
            a = b;
            b = f;
            result[j] = f;
            j++;
        }
        return result;
    }

    private static long [] byRecursion(int number){
        long [] result = new long [number];
        for(int i = 0; i<number; i++){
            result[i] = calcFibonacchi(i);
        }

        return result;
    }

    private static long calcFibonacchi(int n){
        if ( n == 0 ) return 0;
        if (n == 1) return 1;
        return (long)(calcFibonacchi(n-2) + calcFibonacchi(n-1));
    }
}
