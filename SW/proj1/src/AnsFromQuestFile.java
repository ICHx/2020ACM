import java.util.ArrayList;

public class AnsFromQuestFile {

    public static void main(String[] args) {
        // menu

        ArrayList<String> NList = FileOpr.FruitFileOpen();
        int count = NList.size();


        {
            float result = -1;
            for (int i=0; i < count; i++) {
                // file has number list, need splitting
                String s[]=NList.get(i).split("]");
                if(s.length<2){
                    //invalid format
                    FileOpr.FileErr();
                }
                
                result = ParseQuiz.CalcString(s[1]);
                System.out.printf("[%d] ", i + 1);
                System.out.printf("%.3f\n",result);
            }
        }

    }

}