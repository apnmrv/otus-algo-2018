import Benchmark.Benchmark;
import Benchmark.IBenchmark;
import Benchmark.IPrintableReport;
import Sorter.ISorter;
import Sorter.InsertionSorter.InsertionSorter;
import Sorter.MergeSorter.*;
import Sorter.QuickSorter.*;

public class App {

    private static final int DATA_LENGTH_MIN = 100;
    private static final int DATA_LENGTH_MAX = 10_000_000;
    private static final int RUNS = 20;
    private static final int CUTOFF_TO_INSERTION_SORT = 27;

    public static void main(String ...args){

        Printer printer = new Printer();
        IBenchmark b = new Benchmark();

        /*
        * MERGE SORT
        * */
        ISorter s = new MSorterBasic(new BasicMerger());
        IPrintableReport r = b.estimateComplexity(s, DATA_LENGTH_MIN, DATA_LENGTH_MAX, RUNS);
        printer.printReport(r);

        s = new MSorterAccountingAlreadySorted(new BasicMerger());
        r = b.estimateComplexity(s, DATA_LENGTH_MIN, DATA_LENGTH_MAX, RUNS);
        printer.printReport(r);

        s = new MSorterUsingCopyOptimization(new BasicMerger());
        r = b.estimateComplexity(s, DATA_LENGTH_MIN, DATA_LENGTH_MAX, RUNS);
        printer.printReport(r);

        s = new MSorterUsingInsertionSort(new BasicMerger(), new InsertionSorter(), CUTOFF_TO_INSERTION_SORT);
        r = b.estimateComplexity(s, DATA_LENGTH_MIN, DATA_LENGTH_MAX, RUNS);
        printer.printReport(r);

        s = new MSorterAllInOneOptimized(new BasicMerger(), new InsertionSorter(), CUTOFF_TO_INSERTION_SORT);
        r = b.estimateComplexity(s, DATA_LENGTH_MIN, DATA_LENGTH_MAX, RUNS);
        printer.printReport(r);


        /*
         * QUICK SORT
         * */
        s = new LomutoQSorter();
        r = b.estimateComplexity(s, DATA_LENGTH_MIN, DATA_LENGTH_MAX, RUNS);
        printer.printReport(r);

        s = new HoareQSorter();
        r = b.estimateComplexity(s, DATA_LENGTH_MIN, DATA_LENGTH_MAX, RUNS);
        printer.printReport(r);

        s = new QSorterUsingRandomPivot(CUTOFF_TO_INSERTION_SORT);
        r = b.estimateComplexity(s, DATA_LENGTH_MIN, DATA_LENGTH_MAX, RUNS);
        printer.printReport(r);

        s = new QSorterUsingMedianOfThreePivot(CUTOFF_TO_INSERTION_SORT);
        r = b.estimateComplexity(s, DATA_LENGTH_MIN, DATA_LENGTH_MAX, RUNS);
        printer.printReport(r);

        s = new YaroslavskiDualPivotQSorter();
        r = b.estimateComplexity(s, DATA_LENGTH_MIN, DATA_LENGTH_MAX, RUNS);
        printer.printReport(r);
    }
}
