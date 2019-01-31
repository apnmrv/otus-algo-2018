package Benchmark;

import java.util.ArrayList;
import java.util.List;

public class SingleRunReport implements IPrintableReport {
    private String _header;
    private IRunData _data;

    public SingleRunReport(IRunData data) {
        _data = data;
        _header = data.algorithm();
    }

    public List<String> getStrings()
    {
        List<String> output = new ArrayList<>();

        output.add("SINGLE RUN ESTIMATION");
        output.add(_header);
        output.add(sequenceString("In :", _data.sequenceIn()));
        output.add(sequenceString("Out :", _data.sequenceOut()));
        output.add("Sequence length : " + _data.sequenceIn().length);
        output.add("Execution time : " +
                ((double)_data.executionTime()) / 1_000_000 + " ms");


        return output;
    }

    private String sequenceString(String initial, int [] sequence) {
        String str = initial;

        int sLength = sequence.length;
        for(int i = 0; i < sLength; i++){
            str += sequence[i] + " ";
        }
        return str;
    }
}
