package primes;

public class App {
    /*
     * bool
     *  while i*j <= max_num: 
     * numbers[i*j
     * ] = False  и в while j += 1
     *
     * Главная проблема -- память
     * Улучшить :
     * 1) отбросить четные
     * 2) просеивать с квадратов
     * 3) заканчивать, когда n^2 > N
     * */
    private static int [] result;

    public static void main(String[] args) throws InterruptedException {

        int limit = 1000_000;

        IConvertor conv = new Convertor();

        ICalculator calc = new NaiveIterator(conv);
        long estimation = estimate(calc, limit);
        output("Primitive iteration", limit, estimation);

        calc = new OddsOnlyIterator(conv);
        estimation = estimate(calc, limit);
        output("Odds iteration", limit, estimation);

        calc = new NoEvensNoQuadratsIterator(conv);
        estimation = estimate(calc, limit);
        output("Evens&Quadrats excluded iteration", limit, estimation);

        calc = new SquareRootLimitedIterator(conv);
        estimation = estimate(calc, limit);
        output("Square root limited odds iteration", limit, estimation);

        calc = new PrimesOnlyAsDivisorsIterator(conv);
        estimation = estimate(calc, limit);
        output("Primes only iteration", limit, estimation);
    }

    private static long estimate(ICalculator calc, int limit) {

        long startTime = System.nanoTime();
        result = calc.getPrimesUpTo(limit);
        long endTime = System.nanoTime();

        return (endTime-startTime);
    }

    private static void output(String method, int limit, long execTime) {

        System.out.printf("%s needs %d ms to get primes up to %d",
                method, execTime/1_000, limit);
        System.out.printf("%n");
        System.out.printf("Result : ");
        for(int r:result){
            System.out.printf("%d ", r);
        }
        System.out.printf("%n%n");
    }
}
