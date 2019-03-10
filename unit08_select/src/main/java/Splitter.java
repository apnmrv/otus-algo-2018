import Randomizer.IRandomizer;
import Randomizer.Randomizer;

public class Splitter {

    private static IRandomizer __randomizer = new Randomizer();

    public static int split(int [] arr, int idxFrom, int idxTo){

        int initialPivotIdx = __randomizer.getRandomValue(idxFrom, idxTo);

        int pivotElement = arr[initialPivotIdx];
        ArrayHelper.swap(arr, initialPivotIdx, idxTo);

        int finalPivotIdx = idxFrom;

        for (int i = idxFrom; i < idxTo; i++) {
            if (arr[i] <= pivotElement){
                ArrayHelper.swap(arr, finalPivotIdx, i);
                finalPivotIdx++;
            }
        }
        ArrayHelper.swap(arr, finalPivotIdx, idxTo);

        return finalPivotIdx;
    }
}
