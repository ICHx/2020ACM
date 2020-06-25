package week14.q1;

import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;

public class BoysAndGirlsInOneRank {
   public static void main (String[] args) throws FileNotFoundException {
      try ( // with resources
         Scanner in = new Scanner( new File( "babynames.txt"));
         PrintWriter rank  = new PrintWriter( "ranknames.txt");
      ) {
         Set<BabyName> names = new TreeSet<>( BabyName.compareByPopulation() );
         while (in.hasNextLine()) {
            String[] s = in.nextLine().split( "\\s+" );
            if (s.length >= 7) {
               BabyName boyName = new BabyName( s[1], Integer.parseInt(s[2]), 
                  Double.parseDouble(s[3]), Gender.BOY
               );
               BabyName girlName = new BabyName( s[4], Integer.parseInt(s[5]), 
                  Double.parseDouble(s[6]), Gender.GIRL
               );
               names.add( boyName);    
               names.add( girlName);    
            }
         }
         int index = 0;
         for (BabyName n : names)
            rank.printf( "%d %s %d %s\n",
               ++index, n.name, n.population, n.rate + " " + n.gender
            );
      } // auto close all resources 
   }
}

enum Gender { BOY, GIRL };

class BabyName {
   String name;
   int population;
   double rate;
   Gender gender;
   
   BabyName (String n, int p, double r, Gender g) {
      name = n;
      population = p;
      rate = r;
      gender = g;
   }      
  
   static Comparator<BabyName> compareByPopulation () {
      return new Comparator<BabyName>() {
         public int compare (BabyName a, BabyName b) {
            if (b.population != a.population) 
               return b.population - a.population;
            return a.name.compareTo( b.name);
         }
      };
   }
}
   
