public class Recursion {

    public void countDown(int number){

        System.out.printf("%d ", number);
        if (number > 0)
            countDown(--number);

        return;
    }

    public void countUp(int number){
        number--;
        if (number >= 0)
            countUp(number);
        System.out.printf("%d ", ++number);

        return;
    }

    public int factorial(int number){
        int result;

        if( number == 1 ){
            result = 1;
        } else {
            result = number*factorial( --number );
        }
        return result;
    }
}
