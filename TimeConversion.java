import java.io.*;
import java.util.*;
import java.text.*;

class TimeConversion {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */
    public static String timeConversion(String s) {
        // Extract the AM/PM indicator (last two characters)
        String ampm = s.substring(8);

        // Extract the hour part (first two characters)
        String hourString = s.substring(0, 2);

        // Extract the rest of the time (MM:SS)
        String minutesAndSeconds = s.substring(2, 8);

        int hour = Integer.parseInt(hourString);

        // --- Core Conversion Logic ---
        if (ampm.equals("PM")) {
            // For PM times, add 12 unless it's 12 PM (noon)
            if (hour != 12) {
                hour += 12;
            }
        } else { // AM
            // For 12 AM (midnight), convert to 00
            if (hour == 12) {
                hour = 0;
            }
            // For 01 AM to 11 AM, the hour remains the same
        }
        // -----------------------------

        // Format the hour back into a two-digit string (e.g., 0 becomes "00")
        String militaryHour = String.format("%02d", hour);

        // Concatenate the new hour with the original minutes and seconds
        return militaryHour + minutesAndSeconds;
    }

}

class Solution4 {
    public static void main(String[] args) throws IOException {
        // Standard code for reading input from stdin and writing to stdout
        // Note: Using a single class name 'Solution' for the main method is standard practice.
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // This line is often used in platforms like HackerRank to write to a specific file path
        // For a local run, you might replace this with System.out
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        try {
            String s = bufferedReader.readLine();

            // The function is now in the 'Result' class as per standard conventions
            String result = TimeConversion.timeConversion(s);

            // **CORRECTION 1: Write the 'result' string, not the class name.**
            bufferedWriter.write(result);
            bufferedWriter.newLine();
        } finally {
            // Ensure streams are closed
            bufferedReader.close();
            bufferedWriter.close();
        }
    }
}
