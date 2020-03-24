import java.util.regex.*;

public class MatcherMatchesExample {
   public static void main (String[] args) {
      final Pattern pattern1 = Pattern.compile( "mastering" );
      final Pattern pattern2 = Pattern.compile( "mastering.*" );
      final Pattern pattern3 = Pattern.compile( "regular.*" );
      
      String input = "mastering regular expressions";
      Matcher matcher = pattern1.matcher(input);
      System.out.printf( "[%s] => [%s]: %s%n", 
         input, matcher.pattern(), matcher.matches());
      
      // update the matcher pattern with a new pattern
      matcher.usePattern(pattern2);
      System.out.printf( "[%s] => [%s]: %s%n", 
         input, matcher.pattern(), matcher.matches());
      
      // update the matcher pattern with a new pattern
      matcher.usePattern(pattern3);
      System.out.printf( "[%s] => [%s]: %s%n", 
         input, matcher.pattern(), matcher.matches());
   }
}

