import MergeSorter.ISorter;
import MergeSorter.Sorter;
import Randomizer.*;

public class App {

    public static void main (String ... args) {

        ISorter s = new Sorter();

        IRandomizer rand = new Randomizer();

        int [] array = rand.getUniques(0, 10);

        System.out.printf("%nBefore :");

        for (int i1 : array) {
            System.out.printf("%d ", i1);
        }

        array = s.sort(array);

        System.out.printf("%nAfter  :");
        for (int i1 : array) {
            System.out.printf("%d ", i1);
        }
    }
}
