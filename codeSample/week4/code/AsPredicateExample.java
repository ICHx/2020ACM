import java.util.List;
import java.util.stream.*;
import java.util.regex.*;

public class AsPredicateExample {
   public static void main (String[] args) {
      final String[] monthsArr =
         { "10", "0", "05", "09", "12", "15", "00", "-1", "100" };
      final Pattern validMonthPattern =
         Pattern.compile( "^(?:0?[1-9]|1[00-2])$" );
      List<String> filteredMonths = 
         Stream.of( monthsArr )
               .filter( validMonthPattern.asPredicate() )
               .collect( Collectors.toList() );
      System.out.println( filteredMonths );
   }
}

