package week5;

import java.util.Scanner;
import java.time.Instant;
import java.time.Duration;

/**
 * TestPrime
 */
public class TestPrime3 {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();

        Instant start = Instant.now(); // JDK 8.0+
        // Do something
        for (int i = 0; i < 10; i++) {
            int count = numberOfPrimes(n);
            System.out.printf("%d Primes <= %d\n", count, n);
        }
        // done sth.
        Instant end = Instant.now();
        long timeInMS = Duration.between(start, end).toMillis();
        System.out.println("Case 3 Time passed =" + timeInMS);
    }

    private static int numberOfPrimes(int n) {
        // count primes
        if (n <= 1)
            return 0;
        if (n == 2)
            return 1;

        int nPrime = 1;
        for (int i = 3; i <= n; i += 2) {
            boolean isPrime = true;
            int maxFact = (int) (Math.sqrt(n) + 0.1);
            for (int j = 3; j <= maxFact; j += 2) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime)
                nPrime++;
        }
        return nPrime;
    }

}