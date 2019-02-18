package Benchmark;

import java.util.ArrayList;
import java.util.List;

public class MultipleRunsReport implements IPrintableReport {
    private String _title;
    private MultipleRunsData _data;
    private MultipleRunsData [] _dataArray;
    private double _averageExecTime;
    private int _sequenceLength;
    private int _numberOfExecutions;

    public MultipleRunsReport(MultipleRunsData data) {
        _data = data;
        _title = data.header();
        _sequenceLength = data.sequenceLength();
        _averageExecTime = data.averageExecTime();
        _numberOfExecutions = data.numberOfExecutions();
    }

    public MultipleRunsReport(MultipleRunsData[] mDataArray) {
        _dataArray = mDataArray;
        _title = mDataArray[0].header();
    }

    public List<String> getStrings()
    {
        if(null != _dataArray) {
            return getStringsForArrayData();
        }
        List<String> output = new ArrayList<>();

        output.add("MULTIPLE RUNS ESTIMATION");
        output.add(_title);
        output.add("Sequence length : " + _sequenceLength);
        output.add("Executions : " + _numberOfExecutions);
        output.add("Average execution time " +
                        _averageExecTime / 1_000_000 + " ms");

        return output;
    }

    private List<String> getStringsForArrayData() {
        List<String> output = new ArrayList<>();

        output.add("COMPLEXITY ESTIMATION");
        output.add(_title);

        StringBuilder header = new StringBuilder();
        header.insert(0, "Run");
        for(int i = header.length(); i < 25 - header.length(); i++){
            header.append(" ");
        }
        header.append("|Length");
        for(int i = header.length(); i < 50 - header.length(); i++){
            header.append(" ");
        }
        header.append("|Executions");
        for(int i = header.length(); i < 100 - header.length(); i++){
            header.append(" ");
        }
        header.append("|Average execution time (ms)");
        output.add(header.toString());
        int size = _dataArray.length;
        for (int i = 0; i < size; i++) {
            int length = _dataArray[i].sequenceLength();
            int runs = _dataArray[i].numberOfExecutions();
            double timeEst = _dataArray[i].averageExecTime();

            StringBuilder s = new StringBuilder();
            s.append(i+1);
            for(int j = s.length(); j < 25 - s.length(); j++){
                s.append(" ");
            }
            s.append("| "+length);
            for(int j = s.length(); j < 50 - s.length(); j++){
                s.append(" ");
            }
            s.append("| "+ runs);
            for(int j = s.length(); j < 100 - s.length(); j++){
                s.append(" ");
            }
            s.append("| "+timeEst / 10_000_000);
            output.add(s.toString());
        }
        return output;
    }
}
