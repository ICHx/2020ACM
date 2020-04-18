import java.util.ArrayList;


public class Quest {
    public static final int MAXLEVEL = 3;
    private int level=1;
    
    //Serial, only important when importing questions from file
    private int SERIAL=-1;
    public void setSN(int SN) {
        //for future references
        this.SERIAL=SN;
        return;
    }
    public int getSN() {
        //for future references
        return this.SERIAL;}
    
    
    // initialize with generated question
    public Quest(String Question) {
        // denote the level : from 1 to MAXLEVEL
        this.question=Question;
    }
    
    // initialize on creation
    public Quest(int level) {
        if (level > MAXLEVEL || level < 1) {
            // incorrect input of level
            System.out.println("E1: Invalid level :" + level);
            System.exit(1);
        }
        this.level = level;
        payload(level);
    }

    @Override
    public String toString() {
        //for future references
        return question;
    }
    
    public void setAns(String ans) {
        //for future references
        this.answer=ans;
        return;
    }
        public String getAns() {
        //for future references
        return this.answer;
    }

    private String question;
    private String answer;
    
    
    
    final static char[] opr = { '+', '-', '*', '/' };

    private void payload(int level) {
        int numOfElements = (int) ((level +1) * 1.5f);
        ArrayList<String> numbers = new ArrayList<>();
        ArrayList<Character> operators = new ArrayList<>();

        //*start of number generate

        // 1. Generate integer [done]
        // 2. Generate float [done]
        // 3. Generate compound-fraction : 1 + 1/2 = 1_1|2 [done]
        // 4. Randomly choose[done]
        // 5. difficulty [done]

        int numChoice = (int) (Math.random() * level);
        for (int i = 0; i < numOfElements; i++) {
            generateNum(numChoice, numbers);
            numChoice = (int) (Math.random() * level);

        }

        //*end of number generate

        for (int i = 0; i < numOfElements - 1; i++) {
            int num1;
            num1 = (int) (Math.random() * 4);
            operators.add(opr[num1]);

        }
        this.question = this.AssemblyQuiz(numbers, operators);
    }

    private void generateNum(int choice, ArrayList<String> numbers) {
        switch (choice) {
            //  generate an int between 1 to 10^(level+1)
            case 0: {
                int num1;
                num1 = (int) (Math.random() * Math.pow(10,level+1) ) + 1;
                numbers.add(String.valueOf(num1));
                return;
            }

            // generate a decimal between 1 to 10
            // optional: random length between 1-4
            case 1: {
                int num1, num2, depth;
                float result = 0;
                num1 = (int) (Math.random() * 100) + 1;
                num2 = (int) (Math.random() * 10) + 1;
                depth = (int) (Math.random() * (level+2)) + 1;
                depth = (int) Math.pow(10, depth);
                result = (float) num1 / num2 * depth;
                result = (int) result;
                result = result / depth;

                String temp = String.valueOf(result);
                numbers.add(temp);
                return;
            }

            //compound fraction in 10_12|31 or 12|43
            case 2: {
                int num1, num2, num3;
                num1 = (int) (Math.random() * 50) + 0;
                num2 = (int) (Math.random() * 50) + 1;
                num3 = (int) (Math.random() * 50) + 1;

                while (num2 >= num3) {
                    //exchange numerator and denominator
                    if (num2 == num3) {
                        num3 = (int) (Math.random() * 50) + 1;
                    } else {
                        int temp = num2;
                        num2 = num3;
                        num3 = temp;
                    }
                }
                if (num1 == 0) {
                    numbers.add(num2 + "|" + num3);
                } else {
                    numbers.add(num1 + "_" + num2 + "|" + num3);
                }
                return;
            }

            default: {
                System.out.println("WTF?" + choice);
                assert false;
            }
        }
    }

    private String AssemblyQuiz(ArrayList<String> numbers, ArrayList<Character> operators) {
        StringBuilder workStr = new StringBuilder();

        for (int i = 0; i < operators.size(); i++) {
            workStr.append(numbers.get(i));
            workStr.append(" " + operators.get(i) + " ");
        }
        workStr.append(numbers.get(operators.size()));
        return workStr.toString();
    }

}