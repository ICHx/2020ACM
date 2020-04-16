import java.util.ArrayList;

public class Main {
    /*-
     * REQ 1. Generate N numbers [done]
     * 1a. decimals 
     * 1b. fractions 
     * 1c. mixed fraction 带分数
     * 
     * 2. Generate N-1 operators [done]
     * 3. Later: do difficult definition [done]
     * 
     * REQ 2. Read from String and solve the question
     */

    public static void main(String[] args) {
        //menu
        
        
        {
            ArrayList<Integer> NList = FileOpr.SeedFileOpen();

            //TODO initialize count from file

            int i = 0, count = NList.size();
            Generate[] entry = new Generate[count];
            for (Integer N : NList) {
                //
                if (N > 3 || N < 1) {
                    //incorrect input of level
                    System.out.println("E1: Invalid level :" + N);
                    System.exit(1);
                }
                entry[i] = new Generate(N);
                System.out.printf("[%d] ", i + 1);
                System.out.println(entry[i].toString());
                i++;
            }
        }

    }

}