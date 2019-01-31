package Main;

import Main.Benchmark.Benchmark;
import Main.Benchmark.IPrintableReport;
import ShellSorter.GapsSequenser.CiuraSequence;
import ShellSorter.ShellSorter;
import ShellSorter.GapsSequenser.ShellSequence;
import InsertionSorter.InsertionSorter;

public class App {


    public static void main(String [] args) {

        int size = 1000;
        Printer printer = new Printer();

        /*
        * INSERTION SORT
        * */
        ISorter s1 = new InsertionSorter();
        IBenchmark b = new Benchmark();

        IPrintableReport report = b.estimateSingleRun(s1, size);
        printer.printReport(report);

        report = b.estimateMultipleRuns(s1, size, 10);
        printer.printReport(report);

        /*
         * SHELL SORT WITH SHELL's GAPS
         * */
        ISorter s2 = new ShellSorter(new ShellSequence());
        report = b.estimateSingleRun(s2, size);
        printer.printReport(report);
        report = b.estimateMultipleRuns(s2, size, 10);
        printer.printReport(report);

        /*
         * SHELL SORT WITH CIURA's GAPS
         * */
        ISorter s3 = new ShellSorter(new CiuraSequence());
        report = b.estimateSingleRun(s3, size);
        printer.printReport(report);
        report = b.estimateMultipleRuns(s3, size, 10);
        printer.printReport(report);

    }
}
