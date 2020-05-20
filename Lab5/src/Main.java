
//TODO 1) Do a Big-Oh analysis of the running time.
//TODO 2) Implement the code in a simple main class and run it
//        for several interesting values of N.
//TODO 3) Write a simple method public static bool isPrime (int n) {...}
//        to determine if a positive integer N is prime.
//TODO 4) Compare the running times needed to determine if a 20-bit number and a
//        40-bit number are prime by running 100 examples of each through your program.

public class Main {

    public static void main(String[] args) {
        int n = 50;
        System.out.println(fragment7(n));

    }

    // https://www.baeldung.com/java-algorithm-complexity


    // Linear Time Algorithms – O(n) = 50
    public static int fragment1(int n){
        int sum = 0;

        for ( int i = 0; i < n; i ++)
            sum++;

        return sum;
    }
    // O(n^2) = 2500
    public static int fragment2(int n){
        int sum = 0;

        for ( int i = 0; i < n; i ++)
            for ( int j = 0; j < n; j ++)
                sum++;

        return sum;
    }

    // ??? = 1275 wie kann das sein denn wir haben doch die selbe größe als i
    public static int fragment3(int n){
        int sum = 0;

        for ( int i = 0; i < n; i ++)
            for ( int j = i; j < n; j ++)
                sum++;

        return sum;
    }

    // Linear Time Algorithms – O(2n) = 100
    public static int fragment4(int n){
        int sum = 0;

        for ( int i = 0; i < n; i ++)
            sum ++;
        for ( int j = 0; j < n; j ++)
            sum ++;

        return sum;
    }

    // O(n^3) = 125000
    public static int fragment5(int n){
        int sum = 0;

        for ( int i = 0; i < n; i ++)
            for ( int j = 0; j < n*n; j ++)
                sum++;

        return sum;
    }

    // ??? = 1225
    public static int fragment6(int n){
        int sum = 0;

        for ( int i = 0; i < n; i ++)
            for ( int j = 0; j < i; j ++)
                sum++;

        return sum;
    }

    // ??? = 13996133
    public static int fragment7(int n){
        int sum = 0;

        for ( int i = 1; i < n; i ++)
            for ( int j = 0; j < n*n; j ++)
                if (j % i == 0)
                    for (int k = 0; k < j; k++)
                        sum++;

        return sum;
    }



}