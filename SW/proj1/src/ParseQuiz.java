import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ParseQuiz
 */
public class ParseQuiz {

    public static float CalcString(String input) {
        final String PLUS = "[+-]";
        final String STAR = "((\\*)|[\\/])";
        final String FRAC = "[_|]";
        // final String PLUS = ".*[+-].*";
        // final String STAR = ".*((\\*)|[\\/]).*";
        // final String FRAC = ".*[_|].*";

        // recursively split and parse between [+-]
        /**
         * Cases: 1. * 2. / 3a. 12|23 3b. 1_12|23 4a. 1 * 12|23 4b. 1 * 2_12|23 4c. 1 *
         * 2_12|23 * 1
         */

        /**
         * Procedures 1. If has operator(+-), Splitted by +-, CalcString(substrings) 2.
         * If dont have (+-) but has operator (* /)-> Split by (* /) 2b. false, false,
         * If has operator (|), it is fraction, ________ do CalcString(fraction)
         * -------- do 2_12|23 == (2 * 23 + 12 ) / 23 ----else return directly
         * 
         */

        boolean hasPLUS, hasSTAR, hasFRAC;
        hasPLUS = input.matches(".*" + PLUS + ".*");
        hasSTAR = input.matches(".*" + STAR + ".*");
        hasFRAC = input.matches(".*" + FRAC + ".*");

        ArrayList<String> Operands = new ArrayList<>();
        String[] Nums = null;

        Pattern pPlus = Pattern.compile(PLUS);
        Matcher plus = pPlus.matcher(input);

        // [done] handle FRAC before combine

        if (hasPLUS) {
            if(Main.DEBUG==1) System.out.println("has plus/minus");
            while (plus.find()) {
                Operands.add(plus.group());
            }

            Nums = pPlus.split(input);
            float total = 0;

            for (int i = 0; i < Nums.length; i++) {
                // calc num
                Nums[i] = String.valueOf(CalcString(Nums[i]));

                // sum nums
                if (i == 0) {
                    total += Float.parseFloat(Nums[0]);
                    continue;
                }
                if (Operands.get(i - 1).equals("+")) {
                    total += Float.parseFloat(Nums[i]);
                } else {
                    total -= Float.parseFloat(Nums[i]);
                }
            }
            return total;
        } else {
            if(Main.DEBUG==1)System.out.println("has no plus");
        }

        Pattern pSt = Pattern.compile(STAR);
        Matcher star = pSt.matcher(input);

        if (hasSTAR) {
            if(Main.DEBUG==1)System.out.println("has star");
            while (star.find()) {
                Operands.add(star.group());
            }

            Nums = pSt.split(input);
            float total = 0;

            for (int i = 0; i < Nums.length; i++) {
                // calc num
                Nums[i] = String.valueOf(CalcString(Nums[i]));

                // sum nums
                if (i == 0) {
                    total += Float.parseFloat(Nums[0]);
                    continue;
                }
                if (Operands.get(i - 1).equals("*")) {
                    total *= Float.parseFloat(Nums[i]);
                } else {
                    total /= Float.parseFloat(Nums[i]);
                }
            }

            return total;
        } else {
            if(Main.DEBUG==1)System.out.println("has no star");
        }

        if (hasFRAC) {
            // format 2_12|23 == 2 + 12  / 23
            int num1, num2;
            float num3;

            if (input.contains("_")) {
                String s[] = input.split("_");
                String t[] = s[1].split("\\|");

                num1 = Integer.parseInt(s[0].trim());
                num2 = Integer.parseInt(t[0].trim());
                num3 = Integer.parseInt(t[1].trim());
                return  num1 + num2 / num3;
            } else {
                String s[] = input.split("\\|");

                num1 = Integer.parseInt(s[0].trim());
                num2 = Integer.parseInt(s[1].trim());
                return (float) num1 / num2;
            }

        } else {
            if(Main.DEBUG==1)System.out.println("has no frac");
        }

        // base case
        return Float.parseFloat(input);
    }
}