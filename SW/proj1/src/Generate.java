import java.util.ArrayList;

public class Generate {
    public Generate() {
    }
    
    
    
    public void payload(int N) {
        final char[] opr = { '+', '-', '*', '/' };

        ArrayList<String> numbers = new ArrayList<>();
        ArrayList<Character> operators = new ArrayList<>();

        // generate a number between 1 to 100

        for (int i = 0; i < N; i++) {
            int num1;
            num1 = (int) (Math.random() * 100) + 1;
            numbers.add(String.valueOf(num1));
        }

        for (int i = 0; i < N - 1; i++) {
            int num1;
            num1 = (int) (Math.random() * 4);
            operators.add(opr[num1]);

        }
        String question;
        question = QuizPrint(numbers, operators);
        System.out.println(question); //to be redirected to file
    }
    
    public String QuizPrint(ArrayList<String> numbers, ArrayList<Character> operators) {
        StringBuilder workStr = new StringBuilder();

        
        for (int i = 0; i < operators.size(); i++) {
            workStr.append(numbers.get(i));
            workStr.append(operators.get(i));
        }
        workStr.append(numbers.get(operators.size()));

        return workStr.toString();
    }

}