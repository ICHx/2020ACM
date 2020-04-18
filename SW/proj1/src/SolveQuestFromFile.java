import java.util.ArrayList;

public class SolveQuestFromFile {

    public static void main(String[] args) {
        // menu
        System.out.println("\n\n\nMaths Quiz Solver, by TSUI, Hon Fai");
        System.out.println("=============================================");

        System.out.println("Press Enter to Open a problem file\n\n" + "A quiz file contains questions,\n"
                + "with format such as below\n[1]1+1*1");

        System.out.println("=============================================");
        
        
        ArrayList<Quest> entryList = FileOpr.FruitFileOpen();
        // ArrayList<String> QList = FileOpr.FruitFileOpen();
        int count = entryList.size();

        // set answer
        {
            float result = -1;
            for (int i=0; i < count; i++) {
                
                // // file has number list, need splitting
                // String s[]=entryList.get(i).split("]");
                // if(s.length<2){
                //     //invalid format
                //     FileOpr.FileErr();
                // }
                
                result = ParseQuiz.CalcString(entryList.get(i).toString());
                
                // round to 3 decimals
                String result1=String.format("%.3f", result);
                entryList.get(i).setAns(result1);
                
                System.out.printf("[%d] ", entryList.get(i).getSN());
                System.out.printf("%.3f\n",result);
            }
        }
        // save answer
        {
           FileOpr.FruitSlicer(entryList); 
        }

    }

}