public class GeneFinding {
   public static void main (String[] args) {
      String[] genes = findGenes( args[0] );
      for (String gene : genes)
         System.out.println( gene );
   }
   public static String[] findGenes (String gnome) {
      final int LEN = gnome.length();
      String[] temp = new String[ LEN/9 ];
      int count = 0, index = 0;
      while (index < LEN) {
         int begin = gnome.indexOf( "ATG", index );
         if (begin < 0) break;
         for (index = begin+3; index < LEN; index += 3) {  
            if (isStopCodon( gnome.substring( index, index+3 ) )) {
               temp[count++] = gnome.substring( begin+3, index );
               index += 3;
               break;
            }
         }
      }
      String[] genes = new String[ count ];
      for (int i = 0; i < count; i++)
         genes[i] = temp[i];
      return genes;  
   }
   public static boolean isStopCodon (String s) {
      return "TAA".equals(s) || "TGA".equals(s) || "TAG".equals(s);
   }   
}
