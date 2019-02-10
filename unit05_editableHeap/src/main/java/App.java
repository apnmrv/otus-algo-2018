import Randomizer.Randomizer;

public class App {

    private static final int SIZE = 20;

    public static void main(String... args){

//        int[] data = new Randomizer().getUniques(0, SIZE);

        int [] data = {7,6,2,5,3,1,0,4};

        HeapBuilder builder = new HeapBuilder();
        HeapSorter sorter = new HeapSorter();

        Heap heap = builder.build(data.clone());
        print((sorter.sortHeap(heap)));

        for(int i = 7; i > 0; i--)
        {
            Heap h = builder.build(data.clone());
            for(int j = 1; j < i; j++) {
                h.removeNode(i-1);
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
