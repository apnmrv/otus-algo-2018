package Benchmark;

import java.util.ArrayList;
import java.util.List;

public class MultipleRunsData {

    private String _algorithm = null;
    private List<IRunData> _dataList;

    MultipleRunsData(){
        _dataList = new ArrayList<>();
    }

    MultipleRunsData(List<IRunData> dataList){
        _dataList = dataList;
        _algorithm = dataList.get(0).algorithm();
    }

    public void addSingleResultData(IRunData data) {
        _dataList.add(data);
    }

    public List<IRunData> dataSet() {
        return _dataList;
    }

    public String header() {
        return null !=_algorithm ? _algorithm :
                null != _dataList ? _dataList.get(0).algorithm() : "";
    }

    public int sequenceLength() {
        return _dataList.get(0).sequenceIn().length;
    }

    public double averageExecTime() {
        int times = _dataList.size();
        long sum = 0;
        for (IRunData data: _dataList) {
            sum += data.executionTime();
        }
        return ((double)sum)/times;
    }

    public int numberOfExecutions() {
        return _dataList.size();
    }
}
