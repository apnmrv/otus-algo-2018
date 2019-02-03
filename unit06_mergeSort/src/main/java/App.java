public class App {

    public static void main (String ... args) {

//        int [] array = {1, 1, 1, 1, 5, 6, 7, 8};
//        int [] array = {5, 7, 8, 9, 2, 2, 2, 2};
//        int [] array = {5, 7, 8, 9, 10, 2, 2, 2, 2};
//        int [] array = {5, 7, 8, 9, 2, 2, 2, 2, 2};
        int[] array = {2, 1};

        int []  result = merge(array, 1);

        for (int i = 0; i < array.length; i++){
            System.out.printf("%d ", result[i]);
        }
    }

    public static int [] merge(int[] arrIn, int median){

        int size = arrIn.length;
        int [] arrOut = new int[size];
        int lPtr = 0;
        int rPtr = median;

        for(int i = 0; i < size; i++){
            if(lPtr < median &&
                    (rPtr >= size || arrIn[lPtr]<= arrIn[rPtr])){
                arrOut[i] = arrIn[lPtr];
                lPtr++;
            } else {
                arrOut[i] = arrIn[rPtr];
                rPtr++;
            }
        }
        return arrOut;
    }
}
