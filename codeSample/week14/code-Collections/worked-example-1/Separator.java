import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Separator {

    // add entries to 2 seperated set
    
    //! Optional:
        // accumulate 2 sums
        // recalculate ratio
    
    // print results into 2 files
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("week14/code-Collections/worked-example-1/babynames.txt"));
        PrintWriter boy = new PrintWriter("week14/code-Collections/worked-example-1/boynames.txt");
        PrintWriter girl = new PrintWriter("week14/code-Collections/worked-example-1/girlnames.txt");

        Set<BabyName> boyNameSet = new TreeSet<>(BabyName.compareByPopulation());
        Set<BabyName> girlNameSet = new TreeSet<>(BabyName.compareByPopulation());

        int[] accumulatePopulation = { 0, 0 };

        while (in.hasNextLine()) {
            String[] s = in.nextLine().split("\\s+");
            if (s.length >= 7) {
                BabyName boyName = new BabyName(s[1], Integer.parseInt(s[2]), Double.parseDouble(s[3]), Gender.BOY);

                BabyName girlName = new BabyName(s[4], Integer.parseInt(s[5]), Double.parseDouble(s[6]), Gender.GIRL);
                boyNameSet.add(boyName);
                accumulatePopulation[0] += boyName.population;
                girlNameSet.add(girlName);
                accumulatePopulation[1] += girlName.population;
            }
        } // end while

        // recalculate rates
        for (BabyName bb : boyNameSet) {
            bb.rate = (double) 100 * bb.population / accumulatePopulation[0];
        }
        for (BabyName bb : girlNameSet) {
            bb.rate = (double) 100 * bb.population / accumulatePopulation[1];
        }

        // print result boy
        {
            int index = 0;
            for (BabyName n : boyNameSet)
                boy.printf("%d %s %d %.4f\n", ++index, n.name, n.population, n.rate);
        }
        boy.close();
        // print result girl
        {
            int index = 0;
            for (BabyName n : girlNameSet)
                girl.printf("%d %s %d %.4f\n", ++index, n.name, n.population, n.rate);
        }
        girl.close();
    }
}

// enum Gender { BOY, GIRL };

// class BabyName {
// String name;
// int population;
// double rate;
// Gender gender;

// BabyName (String n, int p, double r, Gender g) {
// name = n;
// population = p;
// rate = r;
// gender = g;
// }

// // static Comparator<BabyName> compareByPopulation () {
// // return new Comparator<BabyName>() {
// // public int compare (BabyName a, BabyName b) {
// // if (b.population != a.population)
// // return b.population - a.population; //population first
// // return a.name.compareTo( b.name); //then names
// // }
// // };
// }
// }