import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.Math;

class DigitalDifference {


    public static int diagonalDifference(List<List<Integer>> arr) {
        int n = arr.size();
        int primarySum = 0;
        int secondarySum = 0;

        for (int i = 0; i < n; i++) {

            primarySum += arr.get(i).get(i);

            secondarySum += arr.get(i).get(n - 1 - i);
        }

        return Math.abs(primarySum - secondarySum);
    }
}

class Solve {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(scanner.nextInt());
            }
            arr.add(row);
        }

        int result = DigitalDifference.diagonalDifference(arr);

        System.out.println(result);

        scanner.close();
    }
}