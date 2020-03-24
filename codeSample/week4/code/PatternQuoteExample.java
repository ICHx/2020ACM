import java.util.regex.Pattern;

public class PatternQuoteExample {
   public static void main (String[] args) {
      String input = "Math operators: +-*/. ";
      boolean result;

      String quoted = Pattern.quote("+-*/.");
      System.out.println(quoted);

      // regex using standard escaping
      result = input.matches(".*\\s+\\+-\\*/\\.\\s+.*");
      System.out.println(result);

      // regex Using Pattern.quote around our search string
      result = input.matches(".*\\s+" + quoted + "\\s+.*");
      System.out.println(result);

      // regex Using \Q and \E around our search string
      result = input.matches(".*\\s+\\Q+-*/.\\E\\s+.*");
      System.out.println(result);
   }
}

