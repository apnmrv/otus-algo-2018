package Main.Benchmark;

import java.util.ArrayList;
import java.util.List;

public class MultipleRunsReport implements IPrintableReport {
    private String _header;
    private MultipleRunsData _data;
    private double _averageExecTime;
    private int _sequenceLength;
    private int _numberOfExecutions;

    public MultipleRunsReport(MultipleRunsData data) {
        _data = data;
        _header = data.header();
        _sequenceLength = data.sequenceLength();
        _averageExecTime = data.averageExecTime();
        _numberOfExecutions = data.numberOfExecutions();
    }

    public List<String> getStrings()
    {
        List<String> output = new ArrayList<String>();

        output.add("MULTIPLE RUNS ESTIMATION");
        output.add(_header);
        output.add("Sequence length : " + _sequenceLength);
        output.add("Executions : " + _numberOfExecutions);
        output.add("Average execution time " +
                        _averageExecTime / 1_000_000 + " ms");

        return output;
    }
}
