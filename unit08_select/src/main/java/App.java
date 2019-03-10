public class App {

    public static void main(String ... args){

        int [ ]arr = {198, 234, 0, 24, 154, 45, 3, 4, 77, 84, 5, 6, 7, 8, 1256, 9, 10};

        Selector wrapper = new Selector();

        int result = wrapper.select(arr, 6);

        System.out.println(result);
    }
}
