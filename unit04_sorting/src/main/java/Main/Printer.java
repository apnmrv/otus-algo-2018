package Main;

import Benchmark.IPrintableReport;

import java.util.List;

public class Printer {

    public void printReport(IPrintableReport report) {
        List<String> strings = report.getStrings();
        for (String s: strings) {
            System.out.printf("%s%n", s);
        }
    }
}
