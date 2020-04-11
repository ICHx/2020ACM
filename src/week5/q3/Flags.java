/**
 * * take input: row column
 * * then is the array of dot and * , each line is a row.
 */
package week5.q3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * flags
 */
public class Flags {

    // private static Scanner osc = new Scanner(System.in);
    private static File text = new File("src/week5/q3/case16.txt");

    public static void main(String[] args) throws FileNotFoundException {
        Scanner fsc = new Scanner(text);

        System.out.println("row and column");
        int row = fsc.nextInt();
        int col = fsc.nextInt();
        fsc.nextLine();

        System.out.println("get map");
        char[][] map = new char[row][col];

        // for (int i = 0; i < map.length; i++) {
        // char[] map_row = map[i];
        // String line_temp = fsc.nextLine();
        // for (int j = 0; j < map_row.length; j++) {
        // if (line_temp.charAt(j) != '\n')
        // map_row[j] = line_temp.charAt(j);
        // }
        // }

        // ! [done]initialize the map
        // ! [done]set flag(char and number problem)

        short[][] flagMap = new short[row][col];
        for (int i = 0; i < flagMap.length; i++) {
            short[] map_row = flagMap[i];
            String line_temp = fsc.nextLine();
            for (int j = 0; j < map_row.length; j++) {
                if (line_temp.charAt(j) != '\n')
                    if (line_temp.charAt(j) == '*')
                        setFLAG(i, j, flagMap, row, col);
            }

        }

        // Display 0 to '-'
        // set 15+ to 'F'

        for (int i = 0; i < row; i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < col; j++) {
                if (flagMap[i][j] == 0) {
                    line.append("-");
                } else if (flagMap[i][j] > 10) {
                    line.append("F");
                } else
                    line.append(flagMap[i][j]);
            }
            System.out.println(line.toString());
        }
        fsc.close();
    }

    private static void setFLAG(int i, int j, short[][] map, int row, int col) {
        // def boundCheck:
        // 0 1 store i,j start bound
        // 2 3 store i,j end bound

        int[] stor = new int[4];
        // 1. left bound j= 0
        stor[1] = Math.max(j - 1, 0);
        // 2. uppr bound i= 0
        stor[0] = Math.max(i - 1, 0);

        // 3. rigt bound j= col-1
        stor[3] = Math.min(j + 1, col - 1);
        // 4. lowr bound i= row-1
        stor[2] = Math.min(i + 1, row - 1);

        // traverse columns, then rows
        // do increment to 8 directions,
        for (int k1 = stor[0]; k1 <= stor[2]; k1++) {
            for (int k2 = stor[1]; k2 <= stor[3]; k2++) {
                map[k1][k2] += 1;
            }
        }
        // ?mark (i,j) to display F later
        map[i][j] = 15;

    }

}