package andrewPig;
import javax.swing.*;
import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Andrew {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.print("How many question for the Quiz: ");
        int numberOfQuestion = input.nextInt();
        String[] questions = new String[numberOfQuestion];
        System.out.println("1 is Easy mode, with numbers less than 100");
        System.out.println("2 is Medium mode, with numbers greater than 100 or double numbers");
        System.out.println("3 is Hard mode, with all the above and fix-points numbers" );
        System.out.print("Enter the difficulty: ");
        int i = input.nextInt();
        for(int j = 0; j < numberOfQuestion; j++) {
            questions[j] = generateQuestion(i);
        }

        readFileByLines("D:\\SEProjects\\MathQuizGenerator\\SE-MathQuizGenerator&Solve\\src\\settings.txt");
        writeFileByLines("D:\\SEProjects\\MathQuizGenerator\\SE-MathQuizGenerator&Solve\\src\\problem.txt", 2);
    }

    public static void readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new FileReader(file));
            String tempString;
            while ((tempString = reader.readLine()) != null) {
                String[][] FilePath = new String[2][2];
                for(int i = 0; i < FilePath.length; i++) {
                    FilePath[i] = tempString.split("=");
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    public static void writeFileByLines(String fileName, int n) throws IOException {
        int number = 1;
        OutputStream os = new FileOutputStream(fileName);
        PrintWriter pw = new PrintWriter(os);
        for(int i = 0; i < n; i++) {
            String s = " " + number;
            pw.println(s);
            number++;
        }
        pw.close();
        os.close();
    }

    public static String generateQuestion(int i) {
        String[] operators = {"+", "-", "*", "/"}; // Operators
        switch (i) {
            case 1:
                // Easy mode, with numbers less than 100
                int numberOfOperands = (int)(Math.random() * 8);
                while(numberOfOperands < 2) {
                    numberOfOperands = (int)(Math.random() * 8);
                }
                int Operands = numberOfOperands;
                int numberOfOperators = numberOfOperands - 1;
                String[] question = new String[numberOfOperands + numberOfOperators];


                while(Operands >= 0) {
                    int count = Operands + numberOfOperators - 1;
                    if (count % 2 == 0) {
                        question[count] = randomNumber(1);
                        Operands--;
                    } else {
                        int operator = (int)(Math.random() * 4);
                        question[count] = operators[operator];
                        numberOfOperators--;
                    }
                }

                break;
            case 2:
                // Medium mode, with numbers greater than 100 or double numbers
                i = (int)(Math.random() * 10);
                while(i < 1) {
                    i = (int)(Math.random() * 10);
                }
                System.out.println();
                System.out.print(randomNumber(2) + " ");
                for(int j = 0; j < i; j++) {
                    int operator = (int)(Math.random() * 10);
                    while (operator > 3) {
                        operator = (int)(Math.random() * 10);
                    }
                    System.out.print(operators[operator] + " " + randomNumber(2) + " ");
                }
                break;
            default:
                // Hard mode, with fix-points numbers
                i = (int)(Math.random() * 10);
                while(i < 1) {
                    i = (int)(Math.random() * 10);
                }
                System.out.println();
                System.out.print(randomNumber(3) + " ");
                for(int j = 0; j < i; j++) {
                    int operator = (int)(Math.random() * 10);
                    while (operator > 3) {
                        operator = (int)(Math.random() * 10);
                    }
                    System.out.print(operators[operator] + " " + randomNumber(3) + " ");
                }
                break;
        }
        return operators[1];
    }

    public static String randomNumber(int difficulty) {
        switch (difficulty) {
            case 1:                  // Generate number less than 100
                return generateLessThan100();
            case 2:                  // Generate number greater than 100 or double number
                int x = (int)(Math.random() * 10);
                if (x < 5) {
                    return generateGreaterThan100();
                }
                return generateDoubleNumber();
            default:                 // Generate Fix-Point number
                x = (int)(Math.random() * 10);
                if (x < 3) {
                    return generateLessThan100();
                } else if (x < 6) {
                    return generateGreaterThan100();
                } else if (x < 9) {
                    return generateDoubleNumber();
                } else {
                    return generateFixPointNumber();
                }
        }
    }

    public static String generateLessThan100() {
        int x = (int)(Math.random() * 10 + Math.random() * 27 + Math.random() * 57);
        while (x > 100) {
            x = (int)(Math.random() * 10 + Math.random() * 27);
        }
        return Integer.toString(x);
    }
    public static String generateGreaterThan100() {
        int x = (int)(Math.random() * 100 + Math.random() * 57 + Math.random() * 77);
        while (x < 100) {
            x = (int)(Math.random() * 100 + Math.random() * 57 + Math.random() * 77);
        }
        return Integer.toString(x);
    }
    public static String generateDoubleNumber() {
        DecimalFormat df = new DecimalFormat("0.000");
        double x = (Math.random() * 10 + Math.random() * 37);
        double y = (Math.random() * 10 + Math.random() * 37);
        return df.format(x/y);
    }
    public static String generateFixPointNumber() {
        String x = String.valueOf((int)(Math.random() * 10 + Math.random() * 27));
        String y = String.valueOf((int)(Math.random() * 10));
        String z = String.valueOf((int)(Math.random() * 10));
        return x + "_" + y + "|" + z;
    }
}