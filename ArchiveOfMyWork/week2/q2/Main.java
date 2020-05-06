package q2;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 
 * 題目：求給定數字的平方根。 do n 分析：數學，二分。可以利用模擬（手算開方）或者二分求解。
 * 
 * X=sqrt(Y), 1<=Y<=10^1000
 * 
 * https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=964
 */
public class Main {
    final static boolean DEBUG = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (DEBUG)
            System.out.println("Please enter no. of cases:");

        BigInteger input1,calc0;
        int N = sc.nextInt();
        System.out.println();

        for (int i = 0; i < N ; i++) {

            if (DEBUG)
                System.out.println("Please enter vals:");

            input1 = sc.nextBigInteger();
            calc0 = squareRoot(input1);
            System.out.println(calc0 + "\n");
        }

        sc.close();
    }

    public static BigInteger squareRoot(BigInteger input1) {
        BigInteger TWO = new BigInteger(String.valueOf(2));

        int test = input1.intValue();
        switch (test) {
            case 1:
                return BigInteger.ONE;
            case 4:
                return TWO;
            default:
                break;
        }
        BigInteger reference1 = new BigInteger(String.valueOf(1 << 30));
        test = input1.compareTo(reference1);
        int section = 1; // 1 = lower, 2 = upper. just for debugging

        if (test >= 0) {
            // 初始化
            BigInteger calc0 = BigInteger.ZERO;

            int logY = (int) Math.log(input1.longValue());
            int shiftPara = logY;
            BigInteger testBI = new BigInteger("0");

            // BigInteger ceil = input1.shiftLeft(logY>>1); //effectively divide 2
            BigInteger floor = BigInteger.ONE;
            BigInteger half = input1.shiftRight(shiftPara >> 1); // the initial half
            BigInteger ceil = half;

            // shiftPara >>= 1;

            // boolean success = false;

            for (;;) {
                /*
                 * Y divides into 2 sections, 0..half, half+1..ceil, when floor-ceil less than a
                 * certain value, should use brutal force instead
                 */

                // half = (ceil + floor) >> 1;
                // calc0 = (half * half);

                half = BigInteger.ZERO;
                half = half.add(ceil);
                half = half.add(floor);
                half = half.shiftRight(1);
                /*
                 * the larger the number, x/2 >> sqrt(x) sqrt(x) is bound above by y=2^ln(x) and
                 * x/2 , below by ln(x) for x>2 so, we are not really using half
                 */

                calc0 = half.multiply(half);

                // TEST BEGIN
                test = input1.compareTo(calc0);

                if (test == 1) {
                    // inputLong > calc0 the section is smaller than root
                    section = 2;
                    floor = half;
                    // ceil= ;//nochange

                } else if (test == -1) {
                    // inputLong < calc0 the section is larger than root
                    section = 1;
                    // floor=; //nochange
                    ceil = half;
                } else
                // if (inputLong == calc0)
                {
                    calc0 = half;
                    return calc0;
                }

                //// if ((ceil - floor) < 5) {
                testBI = ceil.subtract(floor);
                test = testBI.compareTo(BigInteger.TEN);
                if (test == -1) {
                    break;
                }

                if (DEBUG)
                    System.out.println("division: " + section);

            } // no integer root found

            /*
             * this loop find the closest if not exact integer to root
             * 
             * const: bignum ceil. bignum floor var: tempBI
             * 
             */
            BigInteger last_difference = BigInteger.TEN, current_difference;
            BigInteger testVal = floor;
            BigInteger last_factor = BigInteger.TEN;
            boolean first = true;

            for (long i = 0; i <= 10; i++, testVal.add(BigInteger.ONE)) {
                // todo: implement allow closest value

                calc0 = testVal.multiply(testVal);
                if (input1.equals(calc0)) {
                    return testVal;
                }

                current_difference = calc0.subtract(input1);
                current_difference = current_difference.abs();

                if (!first) {
                    test = current_difference.compareTo(last_difference);
                    if (test >= 0) {
                        // last solution was better
                        return last_factor;
                    }
                }
                first = false;
                // store last factor, find smallest difference
                last_factor = testVal;
                last_difference = current_difference;

            }
            return last_factor; // assume smallest difference

            //
        } else {
            // smaller than 2^63, directly uses long
            long inputLong = input1.longValueExact();

            long calc1 = 0; // calculation

            long floor = 1; // only for integer roots
            long half = 0;
            long ceil = inputLong >> 1;
            BigInteger returnBI;
            /*
             * Initial ceiling is half of the number __________as sqrt(x) is smaller than
             * 0.5x for x>4
             */

            for (;;) {
                /*
                 * Y divides into 2 sections, 0..half, half+1..ceil, when floor-ceil less than a
                 * certain value, should use brutal force instead
                 */

                half = (ceil + floor) >> 1;
                calc1 = (half * half);

                // TEST BEGIN
                if (inputLong > calc1) {
                    // the section is smaller than root
                    section = 2;
                    floor = half;
                    // ceil= ;//nochange

                } else if (inputLong < calc1) {
                    // the section is larger than root
                    section = 1;
                    // floor=; //nochange
                    ceil = half;
                } else
                // if (inputLong == calc1)
                {
                    calc1 = (long) half;
                    returnBI = new BigInteger(String.valueOf(calc1));
                    return returnBI;
                }

                if ((ceil - floor) < 5) {
                    break;
                }

                if (DEBUG)
                    System.out.println("division: " + section);
            }

            // this loop find the closest if not exact integer to root
            int last_difference = 1, current_difference = -1;
            boolean first = true;
            long last_factor = 1;

            for (long i = floor; i <= ceil; i++) {
                // todo: implement allow closest value
                calc1 = (long) (i * i);
                if (inputLong == calc1) {
                    // calc1 = (long) i;
                    returnBI = new BigInteger(String.valueOf(i));
                    return returnBI;
                }

                current_difference = (int) Math.abs(calc1 - inputLong);
                if (!first && current_difference > last_difference) {
                    // last solution was better
                    returnBI = new BigInteger(String.valueOf(last_factor));
                    return returnBI;
                }
                first = false;
                // store last factor, find smallest difference
                last_factor = i;
                last_difference = current_difference;

            }
            returnBI = new BigInteger(String.valueOf(last_factor));
            return returnBI;
            // assume smallest difference

        } // end of small num test.

    }// end of function
}