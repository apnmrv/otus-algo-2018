

public class App {
    public static void main(String ...args){
        Recursion r = new Recursion();
        r.countDown(10);
        System.out.printf("%n");
        r.countUp(10);
        System.out.printf("%n");
        System.out.printf("%d", r.factorial(5));
    }
}
