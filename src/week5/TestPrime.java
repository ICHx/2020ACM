package week5;

import java.util.Scanner;
import java.time.Instant;
import java.time.Duration;

/**
 * TestPrime
 */
public class TestPrime {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // int n = sc.nextInt();
        int n = 100000;
        Instant start = Instant.now(); // JDK 8.0+
        // Do something
        for (int i = 0; i < 10; i++) {
            Sieve(n);
        }

        Instant end = Instant.now();
        long timeInMS = Duration.between(start, end).toMillis();
        System.out.println("Case 1 Time passed =" + timeInMS);
    }

    private static void Sieve(int n) {
        // ! 1.3.16
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= n / i; i++) {
            if (isPrime[i] == true) {
                for (int j = i; j <= n / i; j++) {
                    isPrime[i * j] = false;
                }
            }
        }

        // count primes
        int primes = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i] == true)
                primes++;
        }
        System.out.println("Primes:" + primes);
    }

}