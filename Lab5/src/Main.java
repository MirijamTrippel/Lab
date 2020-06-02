
//TODO 1) Do a Big-Oh analysis of the running time.
//TODO 2) Implement the code in a simple main class and run it
//        for several interesting values of N.
//TODO 3) Write a simple method public static bool isPrime (int n) {...}
//        to determine if a positive integer N is prime.
//TODO 4) Compare the running times needed to determine if a 20-bit number and a
//        40-bit number are prime by running 100 examples of each through your program.

public class Main {

    public static void main(String[] args) {
        // O(n)
        System.out.println("////////////Fragment 1: ///////////");
        for (int n = 0; n <= 50; n++) {
            System.out.println(n + " steps: " + fragment1(n));
        }
        // O(n^2)
        System.out.println("////////////Fragment 2: ///////////");
        for (int n = 0; n <= 50; n++) {
            System.out.println(n + " steps: " + fragment2(n));
        }
        // O(n^2)
        System.out.println("////////////Fragment 3: ///////////");
        for (int n = 0; n <= 50; n++) {
            System.out.println(n + " steps: " + fragment3(n));
        }
        // O(n^2)
        System.out.println("////////////Fragment 4: ///////////");
        for (int n = 0; n <= 50; n++) {
            System.out.println(n + " steps: " + fragment4(n));
        }
        // O(n^3)
        System.out.println("////////////Fragment 5: ///////////");
        for (int n = 0; n <= 50; n++) {
            System.out.println(n + " steps: " + fragment5(n));
        }
        // O(n^2)
        System.out.println("////////////Fragment 6: ///////////");
        for (int n = 0; n <= 50; n++) {
            System.out.println(n + " steps: " + fragment6(n));
        }
        // O(n^5)
        System.out.println("////////////Fragment 7: ///////////");
        for (int n = 0; n <= 50; n++) {
            System.out.println(n + " steps: " + fragment7(n));
        }

        for (long n = (long) Math.pow(2, 20); n <= Math.pow(2, 20) + 100; n++) {
            System.out.print(n + ": " + isPrime(n) + " | time: ");
            System.out.println(timerResult);
        }
        for (long n = (long) Math.pow(2, 40); n <= Math.pow(2, 40) + 100; n++) {
            System.out.print(n + ": " + isPrime(n) + " | time: ");
            System.out.println(timerResult);
        }
    }

    static double timerStart;
    static double timerEnd;
    static double timerResult;

    public static int fragment1(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum++;
        return sum;

    }

    public static int fragment2(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                sum++;
        return sum;
    }

    public static int fragment3(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++)
            for (int j = i; j < n; j++)
                sum++;
        return sum;
    }

    public static int fragment4(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum++;
        for (int j = 0; j < n; j++)
            sum++;
        return sum;
    }

    public static int fragment5(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n * n; j++)
                sum++;
        return sum;
    }

    public static int fragment6(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < i; j++)
                sum++;
        return sum;
    }

    public static int fragment7(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++)
            for (int j = 0; j < n * n; j++)
                if (j % i == 0)
                    for (int k = 0; k < j; k++)
                        sum++;
        return sum;
    }

    // Part 2
    public static boolean isPrime(long n) {
        timerStart = System.nanoTime();
        if (n < 2) {
            timerEnd = System.nanoTime();
            timerResult = timerEnd - timerStart;
            return false;
        } else {
            for (long i = 2; i <= n / 2; i++) {
                if (n % i == 0) {
                    timerEnd = System.nanoTime();
                    timerResult = timerEnd - timerStart;
                    return false;
                }
            }
            timerEnd = System.nanoTime();
            timerResult = timerEnd - timerStart;
            return true;
        }
    }
}