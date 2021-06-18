package week5.q2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class CntTime {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("choice:");
        Scanner in = new Scanner( System.in );
        cnt(in.nextInt());
        in.close();
    }

    public static void cnt(int choice) throws FileNotFoundException {
        // int n = sc.nextInt();
        System.setIn(new FileInputStream(new File("src/week5/q2/case.txt")));
        
        
        Instant start = Instant.now(); // JDK 8.0+
        // Do something

        if (choice == 0) {
            HDU1016A.main(null);
            System.out.println('A');
            
        } else {
            
            HDU1016B.main(null);
            System.out.println('B');

        }

        Instant end = Instant.now();
        long timeInMS = Duration.between(start, end).toMillis();
        System.out.println("Case" + choice + "Time passed =" + timeInMS);
    }
}