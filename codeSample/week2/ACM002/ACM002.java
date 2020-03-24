// Problem ACM002: Return Books
import java.util.Scanner;
public class ACM002 {
   public static void main (String[] args) {
      Scanner in = new Scanner( System.in );
      while (in.hasNext()) {
         String sBorrowDate = in.next();
         String sReturnDate = in.next();
               
         int[] borrowDate = dateFrom( sBorrowDate );
         int[] returnDate = dateFrom( sReturnDate );

         int daysBorrowed = daysPassed( borrowDate, returnDate );
         
         if (daysBorrowed <= 30) {   // [0 .. 30] days
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
      double fee = 0.0;
      if (lateDays <= 30)         //  [1 .. 30] late days
         fee = 0.5 * lateDays;
      else if (lateDays <= 180)   //  [31 .. 180] late days
         fee = 0.5 * 30 + 0.7 * (lateDays - 30);
      else                        //  [181 .. ) late days
         fee = 250.0; 
            
      return fee;
   }            

   private static int[] dateFrom (String sDate) {
      int[] date = new int[3];
      date[Y] = Integer.parseInt( sDate.substring(0,4) );
      date[M] = Integer.parseInt( sDate.substring(4,6) );
      date[D] = Integer.parseInt( sDate.substring(6,8) );
      return date;
   }
   
   // the d2 day should be equal or after the d1 day
   private static int daysPassed (int[] d1, int[] d2) {
   	if (isEqual(d1, d2)) return 0;
   	  
   	// in the same year & month
   	if (d1[Y]==d2[Y] && d1[M]==d2[M]) 
   	   return d2[D] - d1[D];
   	  
      int days = 0;
   	if (d1[Y]==d2[Y]) {  // same year
   	  	days = daysPerMonth(d1[Y], d1[M]) - d1[D];
   	  	for (int m = d1[M]+1; m < d2[M]; m++)
   	  	   days += daysPerMonth(d1[Y], m);
   	  	days += d2[D];
   	} else {             // over years
   	  	days = daysPassed( d1, new int[] {d1[Y], DECEMBER, 31} );
   	  	for (int y = d1[Y]+1; y < d2[Y]; y++)
   	  	   days += isLeapYear(y) ? 366 : 365;
   	  	days += daysPassed( new int[] {d2[Y], JANUARY, 1}, d2 );
         days++;
      }
      return days;   	  	    
   }
   
   private static boolean isEqual (int[] d1, int[] d2) {
      return d1[Y]==d2[Y] && d1[M]==d2[M] && d1[D]==d2[D];
   }    

   private static int daysPerMonth (int y, int m) {
      int days = DAYS_PER_MONTH[m-1];
      if (m == FEBRUARY && isLeapYear( y )) days++;
      return days;
   }

   private static boolean isLeapYear (int y) {
      return (y%4 == 0 && y%100 != 0) || (y%400 == 0);
   }

   private static final int[] DAYS_PER_MONTH = { 
      31, 28, 31,  30, 31, 30,  31, 31, 30,  31, 30, 31
   };

   private static final int  JANUARY = 1;
   private static final int FEBRUARY = 2;
   private static final int DECEMBER = 12;
   
   private static final int Y = 0;
   private static final int M = 1;
   private static final int D = 2;   
}
