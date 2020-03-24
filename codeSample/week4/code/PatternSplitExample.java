import java.util.*;
import java.util.regex.*;
public class PatternSplitExample {
   public static void main (String[] args) {
      final String input = "value1||value2||value3";
      final Pattern p = Pattern.compile( Pattern.quote( "||" ) );

      // call split and print each element from generated array
      // using stream API
      Arrays.stream( p.split(input) )  // p.splitAsStream(input)
            .forEach( System.out::println );
   }
}

