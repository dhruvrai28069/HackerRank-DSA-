import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class PlusMinus {

    public static void plusMinus(List<Integer> arr) {
        int n = arr.size();

        double positiveCount = 0;
        double negativeCount = 0;
        double zeroCount = 0;

        for (int num : arr) {
            if (num > 0) {
                positiveCount++;
            } else if (num < 0) {
                negativeCount++;
            } else {
                zeroCount++;
            }
        }

        System.out.printf("%.6f%n", positiveCount / n);
        System.out.printf("%.6f%n", negativeCount / n);
        System.out.printf("%.6f%n", zeroCount / n);
    }
}

class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            PlusMinus.plusMinus(arr);
        } catch (Exception e) {

            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            bufferedReader.close();
        }
    }
}

