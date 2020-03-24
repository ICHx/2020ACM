// Problem ACM002: Return Books
// Reference Solution B
// @ Max, 2020
import java.util.Scanner;
public class ACM002B {
   public static void main (String[] args) {
      Scanner in = new Scanner( System.in );
      while (in.hasNext()) {
         String sBorrowDate = in.next();
         String sReturnDate = in.next();
               
         int[] borrowDate = dateFrom( sBorrowDate );
         int[] returnDate = dateFrom( sReturnDate );

         int daysBorrowed = daysPassed( borrowDate, returnDate );
         
         if (daysBorrowed <= 30) {   // [1 .. 30] days
            System.out.println( "The return is successful!" );
         } else { 
            System.out.printf( 
               "You are late, please pay $%.1f!\n",
               lateFee( daysBorrowed - 30 )
            );
         }
      }
      in.close();
   }

   private static double lateFee (int lateDays) {
      if (lateDays <= 30)  return 0.5 * lateDays;   
      if (lateDays <= 180) return 15.0 + 0.7 * (lateDays - 30);
      return 250.0;        // [181 .. )  late days
   }            

   private static int[] dateFrom (String sDate) {
      return date(
         Integer.parseInt( sDate.substring(0,4) ), 
         Integer.parseInt( sDate.substring(4,6) ), 
         Integer.parseInt( sDate.substring(6,8) )
      );
   }
   
   // the d2 day should be equal or after the d1 day
   private static int daysPassed (int[] d1, int[] d2) {
   	// in the same year & month
      if (d1[Y] == d2[Y] && d1[M] == d2[M] && (
          d1[Y] != GREGORIAN_START_YEAR || 
          d1[Y] == GREGORIAN_START_YEAR && d1[M] != OCTOBER
         )) 
   	   return d2[D] - d1[D];
   	  
      int days = 0;
      if (d1[Y] == GREGORIAN_START_YEAR && d1[M] == OCTOBER ||
          d2[Y] == GREGORIAN_START_YEAR && d2[M] == OCTOBER
         ) {   // TODO
         return -9999999; 
      }

      if (d1[Y] == d2[Y]) {  // same year
         days = daysPerMonth( d1[Y], d1[M] ) - d1[D];
         for (int m = d1[M]+1; m < d2[M]; m++)
            days += daysPerMonth( d1[Y], m );
         days += d2[D];
      } else {               // over years
         days = daysPassed( d1, date(d1[Y], DECEMBER, 31) );
         for (int y = d1[Y]+1; y < d2[Y]; y++)
            days += daysPerYear( y );
         days += 1 + daysPassed( date(d2[Y], JANUARY, 1), d2 );
      }
      return days;            
   }

   private static int[] date (int y , int m, int d) {
      return new int[] { y, m, d };
   }  
   
   // return -n when d1<d2; 0 when d1=d2; n when d1>d2
   private static int compare (int[] d1, int[] d2) {
      if (d1[Y] != d2[Y]) return d1[Y] - d2[Y];
      if (d1[M] != d2[M]) return d1[M] - d2[M];
      return d1[D] - d2[D];
   }    

   private static int daysPerYear (int y) {
      if (y == GREGORIAN_START_YEAR) return 355;
      return isLeapYear(y) ? 366 : 365;
   } 

   private static int daysPerMonth (int y, int m) {
      if (y == GREGORIAN_START_YEAR && m == OCTOBER) return 21;
      
      int days = DAYS_PER_MONTH[m-1];
      if (m == FEBRUARY && isLeapYear( y )) days++;
      return days;
   }

   private static boolean isLeapYear (int y) {
      if (y < GREGORIAN_START_YEAR) return y%4 == 0;
      return (y%4 == 0 && y%100 != 0) || (y%400 == 0);
   }

   private static final int[] DAYS_PER_MONTH = { 
      31, 28, 31,  30, 31, 30,  31, 31, 30,  31, 30, 31
   };

   private static final int GREGORIAN_START_YEAR = 1582;

   private static final int  JANUARY = 1;
   private static final int FEBRUARY = 2;
   private static final int  OCTOBER = 10;
   private static final int DECEMBER = 12;
   
   private static final int Y = 0;
   private static final int M = 1;
   private static final int D = 2;   
}
