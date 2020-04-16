import java.util.ArrayList;

public class Main {
    /**
     * REQ 0. read question requirement from file[done] 0b. seed file choosing for
     * generation
     * 
     * REQ 1. Generate N numbers [done] 1a. decimals 1b. fractions 1c. mixed
     * fraction 带分数
     * 
     * 2. Generate N-1 operators [done] 3. Later: do difficult definition [done] -
     * first level : 3 terms , only integer - second level : 4 terms , integer
     * 
     * REQ 2. Read from String and solve the question
     */

    public static void main(String[] args) {
        // menu

        ArrayList<Integer> NList = FileOpr.SeedFileOpen();

        int count = NList.size();
        GenQuest[] entry = new GenQuest[count];

        {
            int i=0;
            for (Integer N : NList) {
                entry[i] = new GenQuest(N);
                System.out.printf("[%d] ", i + 1);
                System.out.println(entry[i]);
                i++;
                // equivalent to
                // ? System.out.println(entry[i].toString());
            }
        }

        {
            float result = -1;
            // FileOpr.FruitFileStash(entry);
            for (int i=0; i < entry.length; i++) {
                String workStr = entry[i].toString();
                result = ParseQuiz.CalcString(workStr);
                System.out.printf("[%d] ", i + 1);
                System.out.println(result);
            }
        }

    }

}