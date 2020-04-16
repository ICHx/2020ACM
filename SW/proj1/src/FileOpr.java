import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * FileOpr
 */
public class FileOpr {

    public static ArrayList<Integer> SeedFileOpen() {
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
            e.printStackTrace();
            System.exit(2);
        }
        return null;
    }

    public static ArrayList<Integer> FruitFileOpen() {
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
            e.printStackTrace();
            System.exit(2);
        }
        return null;
    }

}