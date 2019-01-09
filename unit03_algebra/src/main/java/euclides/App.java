package euclides;

public class App {

    public static void main(String[] args){

    }

    public int euclidesSimple(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }


    public int euclidesMod(int a, int b)
    {
        while (a != 0 && b !=0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        return a;
    }

}
