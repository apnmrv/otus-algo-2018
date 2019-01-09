package fibonacci;

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
    * */

    private static long a = 1;
    private static long b = 1;

    public static void main(String[] args) {

        long[] result = (long[]) calculate(1, 91);

        int i = 0;
        while(result[i]!=0){
            System.out.println(result[i]);
            i++;
        }
    }

    private static long [] calculate(int from, int to) {

        long [] result = new long[to];
        int j = 0;

        for (int i = from; i < to; i++) {
            long f = a+b;
            a = b;
            b = f;
            result[j] = f;
            j++;
        }
        return result;
    }
}
