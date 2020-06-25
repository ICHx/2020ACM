import java.util.*;
public class ComparatorTester {
   public static void main (String[] args) {
      ArrayList<Country> list = new ArrayList<Country>();
      list.add( new Country( "Uruguay", 176220 ) );
      list.add( new Country( "Thailand", 514000 ) );
      list.add( new Country( "Belgium", 30510 ) );

      Collections.sort( list, new CountryComparatorByName() );
      System.out.println( list );
      
      Collections.sort( list, Country.comparatorByName() );
      System.out.println( list );
      
      Collections.sort( list, new Comparator<Country>() {
         public int compare (Country c1, Country c2) {
            return c1.getName().compareTo( c1.getName() );
         }
      });
      System.out.println( list );
      
      Collections.sort(list, (c1, c2) -> c1.getName().compareTo(c2.getName()));
      System.out.println( list );

      Collections.sort( list, Comparator.comparing(e -> e.getName()) );
      System.out.println( list );
      
      Collections.sort( list, Comparator.comparing(Country::getName) );
      System.out.println( list );
   }
}
