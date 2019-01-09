package eratosphenes;

public class App {
    /*
     * bool
     *  while i*j <= max_num: 
     * numbers[i*j
     * ] = False  и в while j += 1
     *
     * Главная проблема -- память
     * Улучшить :
     * 1) отбросить четные
     * 2) просеивать с квадратов
     * 3) заканчивать, когда n^2 > N
     * */

    public static void main(String[] args) {

        int[] result = (int[]) calculate(100);

        for(int r:result){
            System.out.println(r);
        }
    }

    public static int[] calculate(int max){

        int [] resultArray = new int [max];

        for (int i = 2; i < max; i++)
        {
            boolean isPrime = true;
            for(int j = i-1; j > 1; j--)
            {
                if(i % j == 0){
                    isPrime = false; break;
                }
            }
            if(isPrime) {
                resultArray[i] = i;
            } else {
                resultArray[i] = 0;
            }
        }

        return resultArray;
    }
}
