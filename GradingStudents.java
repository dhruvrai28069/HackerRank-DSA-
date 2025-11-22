import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class GradingStudents {

    public static List<Integer> gradingStudents(List<Integer> grades) {

        List<Integer> finalGrades = new ArrayList<>();

        for(int grade : grades){

            if(grade < 38){
                finalGrades.add(grade);
            } else {

                int nextMultiple = ((grade / 5) * 5) + 5;

                int difference = nextMultiple - grade;

                if(difference < 3){
                    finalGrades.add(nextMultiple);
                } else {
                    finalGrades.add(grade);
                }
            }
        }

        return finalGrades;
    }
}

class Solution5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = GradingStudents.gradingStudents(grades);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
