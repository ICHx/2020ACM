package week5;

import java.util.Scanner;
import java.time.Instant;
import java.time.Duration;

/**
 * TestPrime
 */
public class TestPrime2 {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // int n = sc.nextInt();
        int n=100000;
        Instant start = Instant.now(); // JDK 8.0+
        // Do something
        for (int i = 0; i < 10; i++) {
            int count = numberOfPrimes(n);
            System.out.printf("%d Primes <= %d\n", count, n);
        }
        // done sth.
        Instant end = Instant.now();
        long timeInMS = Duration.between(start, end).toMillis();
        System.out.println("Case 2 Time passed =" + timeInMS);
    }

    private static int numberOfPrimes(int n) {
        // count primes
        boolean[] isPrime = Sieve(n + 1);
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i])
                count++;
        }
        return count;
    }

    private static boolean[] Sieve(int n) {
        // ! second example
        boolean[] b = new boolean[n];
        for (int i = 2; i < n; i++) {
            b[i] = true;
        }

        int maxFact = (int) (Math.sqrt(n)+0.1);
        for (int i = 2; i <= maxFact; i++) {
            if (b[i]) {
                for (int j = i*i; j < n; j+=i) {
                    b[j] = false;
                }
            }
        }
        return b;

    }

}