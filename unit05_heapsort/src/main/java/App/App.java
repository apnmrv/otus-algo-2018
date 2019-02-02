package App;

import Benchmark.*;
import Heapsorter.*;

public class App {

    public static void main(String... args){

        int size = 1_000;
        Printer printer = new Printer();

        /*
        * HEAPSORT
        * */
        ISorter s = new AllInOneHeapSorter();
        IBenchmark b = new Benchmark();
        IPrintableReport r = b.estimateSingleRun(s, size);
        printer.printReport(r);

        r = b.estimateMultipleRuns(s, size, 10);
        printer.printReport(r);
    }
}
