import java.util.ArrayList;


public class GenQuest {
    public static final int MAXLEVEL = 3;
    
    private int level = 1; // default level
    
    // initialize on creation
    public GenQuest() {
        // denote the level : from 1 to MAXLEVEL
        payload(level);
    }

    public GenQuest(int level) {
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

    private String question;
    final static char[] opr = { '+', '-', '*', '/' };

    public void payload(int level) {
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

    public static void generateNum(int choice, ArrayList<String> numbers) {
        switch (choice) {
            //  generate an int between 1 to 100
            case 0: {
                int num1;
                num1 = (int) (Math.random() * 100) + 1;
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
                depth = (int) (Math.random() * 4) + 1;
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

    // AssemblyQuiz is invoked by 
    public String AssemblyQuiz(ArrayList<String> numbers, ArrayList<Character> operators) {
        StringBuilder workStr = new StringBuilder();

        for (int i = 0; i < operators.size(); i++) {
            workStr.append(numbers.get(i));
            workStr.append(" " + operators.get(i) + " ");
        }
        workStr.append(numbers.get(operators.size()));
        return workStr.toString();
    }

}