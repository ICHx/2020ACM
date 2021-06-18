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

            while (inFile.hasNextInt()) {
                // ?String line = inFile.nextLine();
                // could be changed from int to string
                int line = inFile.nextInt();
                workList.add(line);
            }
            inFile.close();
            return workList;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            FileErr();
        }
        return null;
    }

    public static ArrayList<Quest> FruitFileOpen() {

        File text = chooser();

        Scanner inFile;
        try {
            ArrayList<Quest> workList = new ArrayList<>();
            inFile = new Scanner(text);

            while (inFile.hasNextLine()) {
                // need to be changed from int to string
                String line = inFile.nextLine();

                if (line.equals("")) {
                    continue;
                }

                if (line.substring(0, 1).equals("A")) {
                    // Meeting answer: all questions are read already
                    break;
                }

                line = line.substring(1);

                String s[] = line.split("]");

                if (s.length < 2) {
                    //invalid format
                    FileOpr.FileErr();
                }

                Quest entry = new Quest(s[1]);
                int serial = Integer.parseInt(line.replaceAll("\\].*", ""));
                entry.setSN(serial);

                workList.add(entry);
            }
            inFile.close();
            return workList;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            FileErr();
        }
        return null;
    }

    public static void FruitStash(Quest entry[]) {
        //write problem file
        File qF = chooser();
        // File qF = new File("SW/proj1/src/problem.txt");

        try {

            FileWriter qFile = new FileWriter(qF);

            String string = null;

            for (int i = 0; i < entry.length; i++) {
                string = "[" + (i + 1) + "]" + entry[i];

                qFile.append(string);

                qFile.append(System.getProperty("line.separator"));

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

    public static void FruitSlicer(ArrayList<Quest> entry) {
        //todo handle if already has answer[]
        //TODO write problem file with answer
        System.out.println("\nWhere to save the answers?");
        File qF = chooser();

        try {

            FileWriter qFile = new FileWriter(qF);

            qFile.append(System.getProperty("line.separator"));
            qFile.append("Answers\n==========================================");
            qFile.append(System.getProperty("line.separator"));

            String string = null;
            for (int i = 0; i < entry.size(); i++) {
                string = "[" + entry.get(i).getSN() + "]" + entry.get(i) + "= " + entry.get(i).getAns();

                qFile.append(string);

                qFile.append(System.getProperty("line.separator"));

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

    public static void FileErr() {
        System.out.println("E2: Invalid file or no file chosen");
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