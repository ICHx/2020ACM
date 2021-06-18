package week11;

/**
 * q1MagicString
 */
public class q1MagicString {

    public static void main(String[] args) {
        int a = 1, b = 1, c = 7;
        extracted(a, b, c);
    }

    private static String extracted(int a, int b) {
        return extracted(a, b, 0);
    }

    private static String extracted(int a, int b, int c) {
        StringBuffer result = new StringBuffer();
        elem[] array = new elem[3];
        array[0] = new elem('a', a);
        array[1] = new elem('b', b);
        array[2] = new elem('c', c);

        char last = '\0';

        worker: while (true) {
            elem max = new elem(last, -1);
            // pick largest remained !=last
            for (elem elem1 : array) {
                if (max.count <= elem1.count) {
                    if (elem1.name != last)
                        max = elem1;
                }
            }
            // if largest elem != last is 0, end condition
            if (max.count <= 0) {
                break worker;
            }
            // greedy: try 2, if not ok, try 1
            if (max.count >= 2) {
                result.append(max.name);
                max.count--;
            }
            result.append(max.name);
            max.count--;
            last = max.name;

            // pick second largest remained !=last
            //greedy: minimum count for minumum usage
            elem min = new elem(last, Integer.MAX_VALUE);
            for (elem elem1 : array) {
                if (min.count >= elem1.count && elem1.count > 0) {
                    if (elem1.name != last)
                        min = elem1;
                }
            }
            // if second largest elem != last is 0, end condition
            if (min.count <= 0 || min.count == Integer.MAX_VALUE) {
                break worker;
            }
            
            result.append(min.name);
            min.count--;
            last = min.name;
            
            // if max is exhausted, print once more
            if (max.count == 0 && min.count > 0) {
                result.append(min.name);
            }

        }
        System.out.println(result);
        return result.toString();
    }

}

class elem {
    char name;
    int count = 0;

    elem(char name, int count) {
        this.name = name;
        this.count = count;
    }
}