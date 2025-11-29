import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class BetweenTwoSets {

    private static int gcd(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private static int lcm(int a, int b) {
        if (a == 0 || b == 0) return 0;
        return (a * b) / gcd(a, b);
    }

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int lcmA = a.get(0);
        for (int i = 1; i < a.size(); i++) {
            lcmA = lcm(lcmA, a.get(i));
        }

        int gcdB = b.get(0);
        for (int i = 1; i < b.size(); i++) {
            gcdB = gcd(gcdB, b.get(i));
        }

        int count = 0;
        int multiple = lcmA;

        while (multiple <= gcdB) {
            if (gcdB % multiple == 0) {
                count++;
            }
            multiple += lcmA;
        }

        return count;
    }
}

class Solution8 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int total = BetweenTwoSets.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}