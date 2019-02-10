import MergeSorter.ISorter;
import MergeSorter.SimpleMergeSorter;
import Randomizer.*;

public class App {

    public static void main (String ... args) {

        ISorter s = new SimpleMergeSorter();

        IRandomizer rand = new Randomizer();

        int [] array = rand.getRandomeSequence(100, 1000, 100);

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
