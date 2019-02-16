import Randomizer.IRandomizer;
import Randomizer.Randomizer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuickSortBlueprintsTest {

    private int [] __randomArray;
    private int [] __equalsArray;

    @BeforeEach
    void setUp() {
        IRandomizer r = new Randomizer();
        __randomArray = r.getRandomSequence(1, 100, 100);
        __equalsArray = new int [] {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
    }

    @Test
    void testPartitionsRandomArray(){
        QuickSortBlueprints quickSortBlueprints = new QuickSortBlueprints(__randomArray);
        int pivotIdx = quickSortBlueprints.partitionLikeLomuto(0, __randomArray.length-1);

        assertTrue(isPreparedProperly(pivotIdx, __randomArray));
    }

    @Test
    void testPartitionsArrayOfEqualNumbers(){
        QuickSortBlueprints quickSortBlueprints = new QuickSortBlueprints(__equalsArray);
        int pivotIdx = quickSortBlueprints.partitionLikeLomuto(0, __equalsArray.length-1);

        assertTrue(isPreparedProperly(pivotIdx, __equalsArray));
    }

    @Test
    void testHoarPartitionsArrayOfEqualNumbers(){
        QuickSortBlueprints quickSortBlueprints = new QuickSortBlueprints(__equalsArray);
        int pivotIdx = quickSortBlueprints.partitionLikeHoar(0, __equalsArray.length-1);

        assertTrue(isPreparedProperly(pivotIdx, __equalsArray));
    }

    @Test
    void testHoarPartitionsRandomArray(){
        QuickSortBlueprints quickSortBlueprints = new QuickSortBlueprints(__randomArray);
        int pivotIdx = quickSortBlueprints.partitionLikeHoar(0, __randomArray.length-1);

        assertTrue(isPreparedProperly(pivotIdx, __randomArray));
    }

    boolean isPreparedProperly(int pivotIdx, int [] array){

        int i = 0;
        int j = array.length-1;

        while (i < pivotIdx-1) {
            if(array[i] > array[pivotIdx]) {
                return false;
            }
            i++;
        }

        while(j > pivotIdx+1){
            if(array[j] < array[pivotIdx]) {
                return false;
            }
            j--;
        }

        return true;
    }

    @Test
    void testQuickSortRandomWithLomuto(){

        QuickSortBlueprints quickSortBlueprints = new QuickSortBlueprints(__randomArray);
        quickSortBlueprints.sortWithLomuto(0, __randomArray.length-1);
        assertTrue(isSortedProperly(__randomArray));
    }

    @Test
    void testQuickSortRandomWithHoar(){

        for(int i = 0; i < 100; i++) {

            int [] arr = (new Randomizer()).getRandomSequence(0, 100, 100);
            QuickSortBlueprints quickSortBlueprints = new QuickSortBlueprints(arr);
            quickSortBlueprints.sortWithHoar(0, arr.length-1);
            assertTrue(isSortedProperly(arr));
        }
    }

    @Test
    void testQuickSortEqualsWithLomuto(){

        QuickSortBlueprints quickSortBlueprints = new QuickSortBlueprints(__equalsArray);
        quickSortBlueprints.sortWithLomuto(0, __equalsArray.length-1);
        assertTrue(isSortedProperly(__equalsArray));
    }

    @Test
    void testQuickSortEqualsWithHoar(){
        QuickSortBlueprints quickSortBlueprints = new QuickSortBlueprints(__equalsArray);
        quickSortBlueprints.sortWithHoar(0, __equalsArray.length-1);
        assertTrue(isSortedProperly(__equalsArray));
    }

    boolean isSortedProperly(int[] arr) {
        for(int i = 0; i < arr.length-1; i++){
            if(arr[i] > arr[i+1])
                return false;
        }
        return true;
    }
}