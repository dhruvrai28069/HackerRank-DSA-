import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class MinMaxElements {

    public static void miniMaxSum(List<Integer> arr) {

        long totalSum = 0;
        int minElement = Integer.MAX_VALUE;
        int maxElement = Integer.MIN_VALUE;

        for (int num : arr) {

            totalSum += num;

            if (num < minElement) {
                minElement = num;
            }

            if (num > maxElement) {
                maxElement = num;
            }
        }

        long minSum = totalSum - maxElement;

        long maxSum = totalSum - minElement;

        System.out.println(minSum + " " + maxSum);
    }

}

class Solution1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        MinMaxElements.miniMaxSum(arr);

        bufferedReader.close();
    }
}