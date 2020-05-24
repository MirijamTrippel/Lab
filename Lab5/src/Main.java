
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
        System.out.println(fragment1(n));
        System.out.println(timerResult);
    }

    // https://www.baeldung.com/java-algorithm-complexity


    static double timerStart;
    static double timerEnd;
    static double timerResult;

    // Linear Time Algorithms – O(n) = 50 // T = ungefähr 2900.0
    public static int fragment1(int n) {
        int sum = 0;
        timerStart = System.nanoTime();
        for (int i = 0; i < n; i++)
            sum++;
        timerEnd = System.nanoTime();
        timerResult = timerEnd - timerStart;
        return sum;

    }


    // O(n^2) = 2500
    public static int fragment2(int n) {
        int sum = 0;
        timerStart = System.nanoTime();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                sum++;
        timerEnd = System.nanoTime();
        timerResult = timerEnd - timerStart;
        return sum;
    }

    // ??? = 1275 wie kann das sein denn wir haben doch die selbe größe als i
    public static int fragment3(int n) {
        int sum = 0;
        timerStart = System.nanoTime();
        for (int i = 0; i < n; i++)
            for (int j = i; j < n; j++)
                sum++;
        timerEnd = System.nanoTime();
        timerResult = timerEnd - timerStart;
        return sum;
    }

    // Linear Time Algorithms – O(n) = 100
    public static int fragment4(int n) {
        int sum = 0;
        timerStart = System.nanoTime();
        for (int i = 0; i < n; i++)
            sum++;
        for (int j = 0; j < n; j++)
            sum++;
        timerEnd = System.nanoTime();
        timerResult = timerEnd - timerStart;
        return sum;
    }

    // O(n^3) = 125000
    public static int fragment5(int n) {
        int sum = 0;
        timerStart = System.nanoTime();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n * n; j++)
                sum++;
        timerEnd = System.nanoTime();
        timerResult = timerEnd - timerStart;
        return sum;
    }

    // ??? = 1225
    public static int fragment6(int n) {
        int sum = 0;
        timerStart = System.nanoTime();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < i; j++)
                sum++;
        timerEnd = System.nanoTime();
        timerResult = timerEnd - timerStart;
        return sum;
    }

    // ??? = 13996133
    public static int fragment7(int n) {
        int sum = 0;
        timerStart = System.nanoTime();
        for (int i = 1; i < n; i++)
            for (int j = 0; j < n * n; j++)
                if (j % i == 0)
                    for (int k = 0; k < j; k++)
                        sum++;
        timerEnd = System.nanoTime();
        timerResult = timerEnd - timerStart;
        return sum;
    }

    // Part 2
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        } else {
            for (int i = 2; i <= n / 2; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}