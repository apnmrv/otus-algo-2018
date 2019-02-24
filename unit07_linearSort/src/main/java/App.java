

public class App {
    public static void main(String ...args){

        int [] a = {31, 25, 56, 47, 12, 37, 88, 113, 83, 99};

        int [] b = radixSort(a, 8, 2);

        for (int i: b){
            System.out.println(i);
        }
    }

    static int[] radixSort(int[] a, int w, int d) {
        int[] b = null;
        for (int p = 0; p < w/d; p++) {
            int c[] = new int[1<<d];
            // the next three for loops implement counting-sort
            b = new int[a.length];
            for (int i = 0; i < a.length; i++)
                c[ (a[i] >> d*p) & ((1<<d)-1) ]++;
            for (int i = 1; i < 1<<d; i++)
                c[i] += c[i-1];

            for ( int i = a.length-1; i >= 0; i-- )
                b[--c[(a[i] >> d*p) & ((1<<d)-1) ]] = a[i];
            a = b;
        }
        return b;
    }
}
