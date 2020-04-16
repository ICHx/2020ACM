import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileOpr {

    public static ArrayList<Integer> SeedFileOpen() {
        File text = new File("SW/proj1/src/case.txt");

        Scanner inFile;
        try {
            ArrayList<Integer> workList = new ArrayList<Integer>();
            inFile = new Scanner(text);

            int lineNumber = 1;
            while (inFile.hasNextInt()) {
                // ?String line = inFile.nextLine();
                // could be changed from int to string
                int line = inFile.nextInt();
                System.out.println("line " + lineNumber + " :" + line);
                workList.add(line);
                lineNumber++;
            }
            inFile.close();
            return workList;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            FileErr();
        }
        return null;
    }

    public static void FruitFileStash(GenQuest entry[])  {

        File qF = new File("SW/proj1/src/problem.txt");
        // File ansF = new File("SW/proj1/src/ans.txt");
        
        try {
            
            FileWriter qFile = new FileWriter(qF);
            // FileWriter aFile = new FileWriter(ansF);
            
            ArrayList<String> workList = new ArrayList<>();
            String string=null;
            for (int i = 0; i < entry.length; i++) {
                string = "["+(i+1)+"]" + entry[i];
         
                    qFile.append(string);
  
                qFile.write(System.getProperty("line.separator"));
                
                // //answer sheet
                // string = "["+(i+1)+"] =";
                // aFile.append(string);
                // aFile.write(System.getProperty("line.separator"));
            }
            qFile.close();
            // aFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            FileErr();
        } catch (IOException e) {
            e.printStackTrace();
            FileErr();
        }
    }

    public static ArrayList<String> FruitFileOpen() {

        File text = new File("SW/proj1/src/problem.txt");

        Scanner inFile;
        try {
            ArrayList<String> workList = new ArrayList<>();
            inFile = new Scanner(text);

            int lineNumber = 1;
            while (inFile.hasNextLine()) {
                // need to be changed from int to string
                String line = inFile.nextLine();
                System.out.println("line " + lineNumber + " :" + line);
                workList.add(line);
                lineNumber++;
            }
            inFile.close();
            return workList;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            FileErr();
        }
        return null;
    }
private static void FileErr() {
    System.out.println("E2: Invalid file");
    System.exit(2);
}
}