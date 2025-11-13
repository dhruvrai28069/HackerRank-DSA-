import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CompareTriplets {

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int aliceScore = 0;
        int bobScore = 0;

        for (int i = 0; i < 3; i++) {
            if (a.get(i) > b.get(i)) {
                aliceScore++;
            } else if (a.get(i) < b.get(i)) {
                bobScore++;
            }
        }

        return Arrays.asList(aliceScore, bobScore);
    }
}

class Solution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> a = new ArrayList<>();
        a.add(scanner.nextInt());
        a.add(scanner.nextInt());
        a.add(scanner.nextInt());

        List<Integer> b = new ArrayList<>();
        b.add(scanner.nextInt());
        b.add(scanner.nextInt());
        b.add(scanner.nextInt());

        List<Integer> result = CompareTriplets.compareTriplets(a, b);

        System.out.println(result.get(0) + " " + result.get(1));

        scanner.close();
    }
}
