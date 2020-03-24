import java.util.regex.*;
public class MatcherFindExample {
   public static void main (String[] args) {
      final String input = 
         "some text <value1> anything <value2><value3> here";

      /* Part 1 */
      final Pattern pattern = Pattern.compile( "<([^<>]*)>" );
      Matcher matcher = pattern.matcher(input);
      while (matcher.find()) {
         System.out.printf( "[%d] => [%s]%n",
            matcher.groupCount(), matcher.group(1) );
      }

      /* Part 2 */
      // now use similar pattern but use a named group and reset the
      // matcher
      matcher.usePattern( Pattern.compile( "<(?<name>[^<>]*)>" ) );
      matcher.reset();
      while (matcher.find()) {
         System.out.printf( "[%d] => [%s]%n",
            matcher.groupCount(), matcher.group("name"));
      }
   }
}

