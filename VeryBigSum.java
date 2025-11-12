import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class VeryBigSum {

    public static long aVeryBigSum(List<Long> ar) {
        long total = 0;
        for (long num : ar) {
            total += num;
        }
        return total;
    }

     static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String outputPath = System.getenv("OUTPUT_PATH");
        BufferedWriter bufferedWriter = new BufferedWriter(
                outputPath == null ? new OutputStreamWriter(System.out) : new FileWriter(outputPath)
        );

        int arCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Long> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long result = VeryBigSum.aVeryBigSum(ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}