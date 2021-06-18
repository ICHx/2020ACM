
// Problem ACM002: Return Books
import java.util.Scanner;

public class ACM002 {
   final static int DEBUG = 1;

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      while (in.hasNext()) {
         String sBorrowDate = in.next();
         String sReturnDate = in.next();

         int[] borrowDate = dateFrom(sBorrowDate);
         int[] returnDate = dateFrom(sReturnDate);

         int daysBorrowed = daysPassed(borrowDate, returnDate);

         if (daysBorrowed <= 30) { // [1 .. 30] days
            System.out.println("The return is successful!");
         } else {
            System.out.printf("You are late, please pay $%.1f!\n", lateFee(daysBorrowed - 30));
         }
         System.out.println("--------------------");
      }
      in.close();
   }

   private static double lateFee(int lateDays) {

      double lateFee1 = 0;
      // more than 180, 250
      if (lateDays >= 180) {
         return 250;
      }

      // first 30 days 0.5/day
      if (lateDays > 30) {
         lateDays -= 30;
         lateFee1 = 15;
      } else {
         lateFee1 = lateDays * 0.5;
         return lateFee1;
      }

      // more days 0.7/day
      lateFee1 += lateDays * 0.7;
      return lateFee1;
   }

   private static int[] dateFrom(String sDate) {
      int date, yyyy, mm, dd;

      date = Integer.parseInt(sDate);
      dd = date % 100;
      yyyy = date / 10000;
      mm = (date - dd - yyyy * 10000) / 100;
      if (DEBUG > 0)
         System.out.println("date=" + yyyy + "-" + mm + "-" + dd);
      int[] target = { yyyy, mm, dd };
      return target;

   }

   // the d2 day should be equal or after the d1 day
   private static int daysPassed(int[] d1, int[] d2) {
      int delta_y, delta_m, delta_d, temp;
      int[] mDay = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

      delta_y = d2[0] - d1[0];
      delta_m = d2[1] - d1[1];// wrong to calc dD here

      // special case = if delta year>1, return a large number
      if (delta_y > 1)
         return 365;
      if (delta_y == 1 && delta_m >= 0)
         return 365;
      // special case = if 2 date within the same month,
      // return 0 as it returns anyway
      // if (d1.equals(d2)) return 0;
      if (delta_y == 0 && delta_m == 0)
         return 0;

      // start counting months
      while (delta_y > 0) {
         delta_m += 12;
         delta_y--; // asume now dY=0
      } // change dM to positive by adding 12
      if (delta_m > 7) {
         return 181;
      } // more than half year, idc the value

      // start counting days, the evil part
      int m0 = d1[1], mf = d2[1];
      int d0 = d1[2], df = d2[2];

      delta_d = df - d0;

      for (int i = delta_m; i > 0; i--) {
         temp = Month(mf - i, 12);
         delta_d += mDay[temp];
      }

      // check leap year
      if (d2[0] % 4 == 0 || d1[0] % 4 == 0) {
         // check origin
         if (m0 < 2)
            delta_d++;
         else if (m0 == 2 && d0 <= 29)
            delta_d++;// less than 2-29
         // check final
         if (mf > 2)
            delta_d++;
         else if (mf == 2 && d0 == 29)
            delta_d++;// exactly 2-29

         if (d2[0] == d1[0])
            delta_d--; // fix same year added twice
      }

      if (DEBUG > 0)
         System.out.println(delta_d);
      return delta_d;// assumed positive
   }

   // MORE HELP METHODS

   private static int Month(int n, int B) { // n%B= m + a*B
      int m;
      m = n % B;
      if (m < 0)
         m += B;
      if (m == 0)
         return 1;
      return m;
   }

}

// 20200228 20200309 ok
// 20151030 20160408 ok
// 20170523 20180615 ok
// 20191215 20200114 ok
// 20191215 20200115 ok