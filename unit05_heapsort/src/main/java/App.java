public class App {

    public static void main(String... args){

        IRandomizer rand = new Randomizer();
        int [] array = rand.getIntegers(0, 1000, 1000);
        HeapSorter sorter = new HeapSorter();

        print(array);
        array = sorter.sort(array);
        print(array);
    }

    public static void print(int[]array){
        for(int i = 0; i < array.length; i++) {
            System.out.printf("%d ", array[i]);
        }
        System.out.printf("%n");
    }
}
