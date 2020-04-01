import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main
 */

public class Main {
    /*-
     * REQ 1. Generate N numbers 
     * 1a. decimals 
     * 1b. fractions 
     * 1c. mixed fraction 带分数
     * 
     * 2. Generate N-1 operators 
     * 3. Later: do difficult definition
     */

    public static void main(String[] args) {

        // final int N = 3; // to be read from file: done

        Generate entry = new Generate();// construct with file stream
        ArrayList<Integer> NList = Main.FileOpen();
        for (Integer N : NList) {
            //
            entry.payload(N);
        }

    }

    private static ArrayList<Integer> FileOpen() {
        File text = new File("SW\\proj1\\src\\case.txt");
        // File text = new
        // File("C:\\Users\\ricts\\IdeaProjects\\2020ACM\\SW\\proj1\\src\\case.txt");
        Scanner inFile;
        try {
            ArrayList<Integer> workList = new ArrayList<Integer>();
            inFile = new Scanner(text);

            int lineNumber = 1;
            while (inFile.hasNextInt()) { //to has next() later
                // TODO: String line = inFile.nextLine();
                // will be changed from int to string
                int line = inFile.nextInt();
                System.out.println("line " + lineNumber + " :" + line);
                workList.add(line);
                lineNumber++;
            }
            inFile.close();
            return workList;

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.exit(2);
        }
        return null;
    }

}