import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class GeneFindingWithRegex {
   public static void main (String[] args) {
      String[] genes = findGenes( args[0] );
      for (String gene : genes)
         System.out.println( gene );
   }

   public static String[] findGenes (String gnome) {
      final String REGEX = "ATG(...)+(TAA|TGA|TAG)";
      Pattern p = Pattern.compile( REGEX );
      Matcher m = p.matcher( gnome );   // get a matcher object

      ArrayList<String> list = new ArrayList<String>();
      while (m.find())
         list.add( gnome.substring( m.start()+3, m.end()-3 ) );
         
      String[] result = new String[list.size()];   
      return list.toArray( result ); 
   }  
}
