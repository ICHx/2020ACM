import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class FileOpr {

    public static ArrayList<Integer> SeedFileOpen() {

        File text = chooser();
        // File text = new File("SW/proj1/src/case.txt");

        Scanner inFile;
        try {
            ArrayList<Integer> workList = new ArrayList<Integer>();
            inFile = new Scanner(text);

            int lineNumber = 1;
            while (inFile.hasNextInt()) {
                // ?String line = inFile.nextLine();
                // could be changed from int to string
                int line = inFile.nextInt();
                if (Main.DEBUG == 1)
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

    public static void FruitFileStash(GenQuest entry[]) {

        File qF = chooser();
        // File qF = new File("SW/proj1/src/problem.txt");

        try {

            FileWriter qFile = new FileWriter(qF);

            String string = null;
            for (int i = 0; i < entry.length; i++) {
                string = "[" + (i + 1) + "]" + entry[i];

                qFile.append(string);

                qFile.write(System.getProperty("line.separator"));

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

        File text = chooser();
        // File text = new File("SW/proj1/src/problem.txt");

        Scanner inFile;
        try {
            ArrayList<String> workList = new ArrayList<>();
            inFile = new Scanner(text);

            int lineNumber = 1;
            while (inFile.hasNextLine()) {
                // need to be changed from int to string
                String line = inFile.nextLine();
                if (Main.DEBUG == 1)
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

    public static void FileErr() {
        System.out.println("E2: Invalid file or no file choosen");
        System.exit(2);
    }

    private static File chooser() {
        // source:
        // https://www.codejava.net/java-se/swing/show-simple-open-file-dialog-using-jfilechooser
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            return selectedFile;
        } else {
            FileErr();
        }
        return null;
    }

}