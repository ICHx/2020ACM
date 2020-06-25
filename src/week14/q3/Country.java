package week14.q3;

import java.util.Comparator;

public class Country implements Comparable<Country> {
   private String name;
   private double area;

   public Country(String aName, double anArea) {
      name = aName;
      area = anArea;
   }

   public String getName() {
      return name;
   }

   public double getArea() {
      return area;
   }

   public String toString() {
      return name + " " + area;
   }

   public int compareTo(Country other) {
      if (area < other.area)
         return -1;
      if (area > other.area)
         return 1;
      return 0;
   }

   //!q3
   public static Comparator<Country> comparatorByName() {
      return (c1, c2) -> c1.getName().compareTo(c2.getName());
   }

   public static Comparator<Country> comparatorByArea() {
      return (c1, c2) -> (int) (c1.getArea() - c2.getArea());
   };
   //!q3
   
   // public static Comparator<Country> comparatorByName() {
   // return new Comparator<Country>() {
   // public int compare(Country c1, Country c2) {
   // return c1.getName().compareTo(c2.getName());
   // }
   // };
   // }

   // public static Comparator<Country> comparatorByArea() {
   // return new Comparator<Country>() {
   // public int compare(Country c1, Country c2) {
   // return (int) (c1.getArea() - c2.getArea());
   // }
   // };
   // }

}
