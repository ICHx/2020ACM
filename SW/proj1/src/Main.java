import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public final static int DEBUG = 0;
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
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // menu
        System.out.println("\n\n\nMaths Quiz Generator, by TSUI, Hon Fai");
        System.out.println("=============================================");

        System.out.println("Press Enter to Open a seed file\n\n" + "A Seed File is a file containing a single column,\n"
                + "each row represent a level choice (from 1 to 3).");

        System.out.println("Or Enter \"open\" to get answer for existing questions");
        System.out.println("=============================================");
        {
            String choice = sc.nextLine().trim().toLowerCase();
            if (choice.equals("open")) {
                AnsFromQuestFile.main(args);
                return;
            }
        }
        ArrayList<Integer> NList = FileOpr.SeedFileOpen();

        int count = NList.size();
        GenQuest[] entry = new GenQuest[count];

        {
            int i = 0;
            for (Integer N : NList) {
                entry[i] = new GenQuest(N);
                System.out.printf("[%d] ", i + 1);
                System.out.println(entry[i]);
                i++;
                // equivalent to
                // ? System.out.println(entry[i].toString());
            }
        }
        System.out.println("Save Problem?(y/n)");
        String choice = sc.next().trim().toLowerCase();
        if (choice.equals("y")) {
            FileOpr.FruitFileStash(entry);
        }
        sc.nextLine();
        // clear newline

        System.out.println("Press Enter to reveal answer");
        sc.nextLine();
        System.out.println("=============================================");
        {
            float result = -1;

            for (int i = 0; i < entry.length; i++) {
                // internal array has no number list
                String workStr = entry[i].toString();
                result = ParseQuiz.CalcString(workStr);
                System.out.printf("[%d] ", i + 1);
                System.out.printf("%.3f\n",result);
            }
        }

    }

}