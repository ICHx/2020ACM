import java.util.regex.*;

public class MatcherAppendExample {
   public static void main (String[] args) {
      final String input = 
         "<n1=v1 n2=v2 n3=v3> n1=v1 n2=v2 abc=123 <v=pq id=abc> v=pq";

      // pattern1 to find all matches between < and >
      final Pattern pattern = Pattern.compile( "<[^>]+>" );

      // pattern1 to find each name=value pair
      final Pattern pairPattern = Pattern.compile( "(\\w+)=(\\w+)" );
      Matcher enclosedPairs = pattern.matcher(input);

      StringBuffer sbuf = new StringBuffer();
      // call find in a loop and call appendReplacement for each match
      while (enclosedPairs.find()) {
         Matcher pairMatcher = pairPattern.matcher( enclosedPairs.group());
         // replace name=value with value=name in each match
         enclosedPairs.appendReplacement( 
            sbuf, pairMatcher.replaceAll( "$2=$1" )
         );
      }
      // appendTail to append remaining character to buffer
      enclosedPairs.appendTail( sbuf );
      System.out.println( sbuf );
   }
}
