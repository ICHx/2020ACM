import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ParseQuiz
 */
public class ParseQuiz {
    // !if From file:
    // splitting regex ： ^(\[\d+\])(.+)
    // first match group: [num]
    // secondmatch group: question[i]
    private static String patternQ= "^(\\[\\d+\\])(.+)";
    

    
    // public static String[] SplitString(String input) {
    //     String Numbers[]=input.split(OPR);
    //     for (String string : Numbers) {
            
    //     }
        
    //     Pattern oPat = Pattern.compile(OPR);
    //     Matcher oMatch=oPat.matcher(input);
    // }
    
    public static float CalcString(String input) {
        final String PLUS= "[+-]";
        final String STAR= "((\\*)|[\\/])";
        final String FRAC= "[_|]";
        // final String PLUS = ".*[+-].*";
        // final String STAR = ".*((\\*)|[\\/]).*";
        // final String FRAC = ".*[_|].*";

        // recursively split and parse between [+-]
        /**
         * Cases:
         * 1. *
         * 2. /
         * 3a. 12|23
         * 3b. 1_12|23
         * 4a. 1 * 12|23
         * 4b. 1 * 2_12|23
         * 4c. 1 * 2_12|23 * 1
         */
        
         /**  Procedures
         * 1. If has operator(+-), Splitted by +-, CalcString(substrings)
         * 2. If dont have (+-) but has operator (* /)-> Split by (* /)
         * 2b. false, false, If has operator (|), it is fraction, 
         * ________ do CalcString(fraction)
         * -------- do 2_12|23 == (2 * 23 + 12 ) / 23
         * ----else return directly
         * 
           */
          
           boolean hasPLUS, hasSTAR, hasFRAC;
           hasPLUS=input.matches(".*"+PLUS+".*");
           hasSTAR=input.matches(".*"+STAR+".*");
           hasFRAC=input.matches(".*"+FRAC+".*");
           
           ArrayList<String> Operands =  new ArrayList<>();
           String[] Nums = null;
           //    ArrayList<String> Nums =  new ArrayList<>();
           
           Pattern pFrac=Pattern.compile(FRAC);
           Matcher frac=pFrac.matcher(input);
        
           
           Pattern pPlus=Pattern.compile(PLUS);
           Matcher plus=pPlus.matcher(input);
           
           
           
           //TODO handle FRAC before PLUS
           
        if(hasPLUS){
            System.out.println("has plus/minus");
            while(plus.find()){
                Operands.add(plus.group());
            }
            
            Nums = pPlus.split(input);
            float total=0;
            
            for (int i = 0; i < Nums.length; i++) {
                // calc num
                Nums[i]=String.valueOf(CalcString(input));
                
                // sum nums
                if(i==0) {
                    total += Float.parseFloat(Nums[0]);
                    continue;}
                if(Operands.get(i-1)=="+"){
                    total += Float.parseFloat(Nums[i]);
                }else{
                    total -= Float.parseFloat(Nums[i]);
                }
            }
            
            
        return total;
        }
        else{
            System.out.println("has no plus");
        }
        
        Pattern pSt=Pattern.compile(STAR);
        Matcher star=pSt.matcher(input);
        
        if(hasSTAR){
            System.out.println("has star");
            
            
            return 0;
        }
        else{
            System.out.println("has no star");
        }
        
        
        return -1;
    }
}