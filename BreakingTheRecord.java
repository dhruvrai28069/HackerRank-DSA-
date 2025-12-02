import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class BreakingTheRecords {


    public static List<Integer> breakingRecords(List<Integer> scores) {
        // 1. Initialize records with the first game's score
        int minScore = scores.get(0);
        int maxScore = scores.get(0);

        // 2. Initialize counters for how many times records were broken
        int minBreaks = 0;
        int maxBreaks = 0;

        // 3. Iterate through the rest of the scores (starting from index 1)
        for (int i = 1; i < scores.size(); i++) {
            int currentScore = scores.get(i);

            if (currentScore > maxScore) {
                // High score broken
                maxScore = currentScore;
                maxBreaks++;
            } else if (currentScore < minScore) {
                // Low score broken
                minScore = currentScore;
                minBreaks++;
            }
        }

        // 4. Return result as a list: [maxBreaks, minBreaks]
        // Note: Arrays.asList is a quick way to create a fixed-size list
        return Arrays.asList(maxBreaks, minBreaks);
    }

}

class Solution9 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // NOTE: If running locally, you might need to replace System.getenv("OUTPUT_PATH")
        // with a specific file path or use System.out
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = BreakingTheRecords.breakingRecords(scores);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}