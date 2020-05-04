package tsui.common;

public class DebugHelper {
public static String get2DArrayPrint(int[][] matrix) {
    String output = "";
    for (int[] ints : matrix) {
        for (int j = 0; j < ints.length; j++) {
            output = output + (ints[j] + "\t");
        }
        output = output + "\n";
    }
    return output;
}

public static String get2DArrayPrint(byte[][] matrix) {
    String output = "";
    for (byte[] ints : matrix) {
        for (int j = 0; j < ints.length; j++) {
            output = output + (ints[j] + "\t");
        }
        output = output + "\n";
    }
    return output;
}
}
