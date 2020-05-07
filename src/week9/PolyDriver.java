package week9;

import week9.Point;

import java.util.Scanner;

public class PolyDriver {



private static Scanner sc = new Scanner(System.in);

public static void main(String[] args) {
    // polygon init.
    System.out.println("Enter Polygon sides#");
    int N = sc.nextInt();
    Point[] points = new Point[N];
    System.out.println("Enter Polygon corners coordinate");
    // get x y line by line
    for (int i = 0; i < N; i++) {
        points[i] = new Point(sc.nextDouble(),sc.nextDouble());
    }
    // finish polygon init.
    
    if(!sc.next().equals("===")) System.exit(-1);
    
    // get Point q
    System.out.println("Enter Q");
    Point q = new Point(sc.nextDouble(), sc.nextDouble());
    
    
    PolyGon P = new PolyGon(points);
}
}
