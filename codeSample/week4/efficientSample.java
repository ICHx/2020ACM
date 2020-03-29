package Q4;

import java.util.Scanner;

class efficientSample {
    private final static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter sequence");
        String inString = sc.next();
        System.out.println(decodeString(inString));

    }
    
    public static String decodeString(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }
        
        StringBuilder result = new StringBuilder();
        int i = 0;
        int number = 0;
        while (i < s.length()) {
            if (isNumber(s.charAt(i))) {
                while(i < s.length() && isNumber(s.charAt(i))) {
                    number = number * 10 + s.charAt(i) - '0';
                    i++;
                }
            } else if (s.charAt(i) == '[') {
                i++;
                int counter = 0;
                StringBuilder sb = new StringBuilder();
                while (i < s.length()) {
                    if (s.charAt(i) == '[') {
                        counter++;
                    } else if (s.charAt(i) == ']') {
                        if (counter == 0) {
                            break;
                        } else {
                            counter--;
                        }
                    }
                    sb.append(s.charAt(i));
                    i++;
                } 
                String sub = decodeString(sb.toString());
                while(number > 0) {
                    result.append(sub);
                    number--;
                }
                i++;
            } else {
                result.append(s.charAt(i));
                i++;
            }
        }
        return result.toString();
    }
    
    private static boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }
}