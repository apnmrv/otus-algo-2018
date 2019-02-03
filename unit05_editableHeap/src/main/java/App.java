import Randomizer.Randomizer;

import java.util.zip.ZipEntry;

public class App {

    private static final int SIZE = 20;

    public static void main(String... args){

        int[] data = new Randomizer().getUniques(0, SIZE, SIZE);

        HeapBuilder builder = new HeapBuilder();
        HeapSorter sorter = new HeapSorter();

        Heap heap = builder.build(data.clone());
        print((sorter.sortHeap(heap)));

        for(int i = 1; i < SIZE; i++)
        {
            Heap h = builder.build(data.clone());

            for (int j = 0; j < i; j++) {
                h.removeNode(1);
            }

            print((sorter.sortHeap(h)));
        }

    }

    private static void print(int[] data) {

        System.out.printf("%n");

        for(int i = 0; i < data.length; i++){
            System.out.printf("%d ", data[i]);
        }
        System.out.printf("%n");
    }
}
