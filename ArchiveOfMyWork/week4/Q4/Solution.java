package Q4;

import java.util.Scanner;
import java.util.Stack;

/**
 * Leetcode 394 https://leetcode.com/problems/decode-string/ decodeStr 
 * Given an encoded string, return its decoded string.
 * 
 * The encoding rule is: k[encoded_string], where the encoded_string inside the
 * square brackets is being repeated exactly k times. Note that k is guaranteed
 * to be a positive integer.
 * 
 * You may assume that the input string is always valid; No extra white spaces,
 * square brackets are well-formed, etc.
 * 
 * Furthermore, you may assume that the original data does not contain any
 * digits and that digits are only for those repeat numbers, k. For example,
 * there won't be input like 3a or 2[4].
 * 
 * Examples:
 * 
 * s = "3[a]2[bc]", return "aaabcbc". s = "3[a2[c]]", return "accaccacc". s =
 * "2[abc]3[cd]ef", return "abcabccdcdcdef".
 * 
 */

/**
 * Failed case : Consider "2[abc]3[cd]ef" DONE! Consider "3[a]2[b4[F]c]" DONE!
 * 
 */
public class Solution {
    private final static Scanner sc = new Scanner(System.in);

    // ignore scanner close message
    public static void main(String[] args) {
        System.out.println("Enter sequence");
        String inString = sc.next();
        System.out.println(decodeString(inString));

    }

    public static String decodeString(String inString) {

        char[] chAry = inString.toCharArray();

        Stack<String> cStack = new Stack<>();
        Stack<Integer> iStack = new Stack<>();

        StringBuilder nBuf = new StringBuilder();
        StringBuilder outStr = new StringBuilder();

        int isNested = 0;

        for (int i = 0; i < chAry.length; i++) {
            char char1 = chAry[i];
            if (Character.isDigit(char1)) {
                while (i++ < chAry.length && Character.isDigit(char1)) {
                    nBuf.append(char1);
                    char1 = chAry[i];
                }
                i--;

                // do merge number and push
                int num = Integer.parseInt(nBuf.toString());
                iStack.push(num);
                // reset stringbuilder
                nBuf.setLength(0);

            }

            switch (char1) {
                case '[':
                // do char append and push
                {
                    StringBuilder cBuf = new StringBuilder();

                    // reading string
                    char1 = chAry[++i];
                    while (Character.isLetter(char1)) {
                        cBuf.append(char1);

                        char1 = chAry[++i];
                    }
                    // store the string
                    cStack.push(cBuf.toString());

                    --i; // let outside switch case handle

                    isNested += 1;
                    break;

                }
                case ']':
                // do pop both stack, append outstring from cb
                {
                    int times = iStack.pop();
                    String content = cStack.pop();

                    if (isNested > 1) {
                        // append to the stack content
                        StringBuilder stackContent = new StringBuilder(cStack.pop());
                        for (int j = 0; j < times; j++) {
                            stackContent.append(content);
                        }
                        cStack.push(stackContent.toString());

                    } else {
                        // append to outString
                        for (int j = 0; j < times; j++) {
                            outStr.append(content);
                        }
                    }

                    isNested -= 1;
                    break;
                }

                default: {
                    // the alphabet not repeated

                    // imitate '['
                    StringBuilder cBuf = new StringBuilder();
                    // reading string
                    while (i < chAry.length && Character.isLetter(char1 = chAry[i])) {
                        cBuf.append(char1);
                        i++;
                    }
                    --i;

                    // imitate ']'

                    if (isNested >= 1) {
                        // append to the stack content
                        StringBuilder stackContent = new StringBuilder(cStack.pop());
                        stackContent.append(cBuf);
                        cStack.push(stackContent.toString());

                    } else {
                        // append to outString
                        outStr.append(cBuf);

                    }
                    break;
                }
            }

        }

        // check validity, not neccessary on leetcode testCase
        if (cStack.isEmpty() && iStack.isEmpty()) {
            return outStr.toString();
        } else {
            System.out.println("e: Invalid sequence");
            return "";
        }
    }

}