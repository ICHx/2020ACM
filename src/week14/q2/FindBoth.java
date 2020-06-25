package week14.q2;

import java.io.File;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class FindBoth {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("src/week14/q2/babynames.txt"));
        PrintWriter both = new PrintWriter("src/week14/q2/bothnames.txt");

        Set<BabyName> boyNameSet = new TreeSet<>( BabyName.compareByPopulation());
        Set<BabyName> girlNameSet = new TreeSet<>( BabyName.compareByPopulation());

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

        // print result boy
        {

            for (BabyName n : boyNameSet)
                if (girlNameSet.contains(n)) {
                    both.printf("%s\n", n.name);
                    System.out.printf("%s\n", n.name);
                }
        }

        both.close();

    }
}

enum Gender {
    BOY, GIRL
};

class BabyName {
    String name;
    int population;
    double rate;
    Gender gender;

    BabyName(String n, int p, double r, Gender g) {
        name = n;
        population = p;
        rate = r;
        gender = g;
    }

    static Comparator<BabyName> compareByPopulation() {
        return new Comparator<BabyName>() {
            public int compare(BabyName a, BabyName b) {

                return a.name.compareTo(b.name);
            }
        };
    }

    public boolean equals(BabyName o) {
        if (this.name.equals(o.name)) {
            return true;
        }
        return false;

    }
}