import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    public static int simpleArraySum(List<Integer> ar) {

        int sum = 0;

        for (int number : ar) {
            sum += number;
        }

        return sum;
    }
}
public class SimpleArraySum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String outputPath = System.getenv("OUTPUT_PATH");
        if (outputPath == null) {

            outputPath = "stdout";
        }

        BufferedWriter bufferedWriter;
        if ("stdout".equals(outputPath)) {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        } else {
            bufferedWriter = new BufferedWriter(new FileWriter(outputPath));
        }

        int arCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.simpleArraySum(ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}