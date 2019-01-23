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
    private static Object [] result;

    public static void main(String[] args) throws InterruptedException {

        int limit = 100000;
        
        ICalculator calc = new NaiveIterator();
        long estimation = estimate(calc, limit);
        output("Primitive iteration", limit, estimation);

//        calc = new OddsIterator();
//        estimation = estimate(calc, limit);
//        output("Odds iteration", limit, estimation);
//
//        calc = new NoSquaresOddsIterator();
//        estimation = estimate(calc, limit);
//        output("Squares excluded odds iteration", limit, estimation);
//
//        calc = new NoSquareRootsOddsIterator();
//        estimation = estimate(calc, limit);
//        output("Square roots excluded odds iteration", limit, estimation);
//
//        calc = new SquareRootLimitedOddsIterator();
//        estimation = estimate(calc, limit);
//        output("Square root limited odds iteration", limit, estimation);
//
//        calc = new SquareLimitedIterator();
//        estimation = estimate(calc, limit);
//        output("Square limited odds iteration", limit, estimation);
//
//        calc = new PrimesIterator();
//        estimation = estimate(calc, limit);
//        output("Primes only iteration", limit, estimation);

//        calc = new CribrumEratosthenis();
//        estimation = estimate(calc, limit);
//        output("Eratosthenes", limit, estimation);
//
//        calc = new CribrumEratosthenisNoSquares();
//        estimation = estimate(calc, limit);
//        output("Eratosthenes without squares", limit, estimation);

        calc = new CribrumEratosthenisAdvanced();
        estimation = estimate(calc, limit);
        output("Eratosthenes advanced", limit, estimation);
    }

    private static long estimate(ICalculator calc, int limit) {

        long startTime = System.nanoTime();
        result = calc.getPrimesUpTo(limit);
        long endTime = System.nanoTime();

        return (endTime-startTime);
    }

    private static void output(String method, int limit, long execTime) {

        System.out.printf("%s needs %d ms to get primes up to %d",
                method, execTime/1_000_000, limit);
        System.out.printf("%n");
        System.out.printf("Result : ");
        for(Object r:result){
            System.out.printf("%d ", r);
        }
        System.out.printf("%n%n");
    }
}
