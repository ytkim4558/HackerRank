package gradientstudents;
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

//link : https://www.hackerrank.com/challenges/grading/problem
public class GradientStudents {
    /*
     * Complete the gradingStudents function below.
     */
    static int[] gradingStudents(int[] grades) {
        /*
         * Write your code here.
         */
        for(int i = 0; i<grades.length; ++i) {
            if(grades[i] >= 38) {
                grades[i] = roundNextMultiple5(grades[i]);
            }

        }
        return grades;
    }

    static int roundNextMultiple5(int num) {
        assert(num>=10); // it should be bigger than 10 or same.
        int nextMultiple5;
        if(num % 10 <= 5) nextMultiple5 = num/10*10+5;
        else nextMultiple5 = num/10*10+10;
        if (nextMultiple5 - num < 3) return nextMultiple5;
        else return num;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bw = new BufferedWriter(new FileWriter("out/production/hackerrank/gradientstudents/gradientstudents.txt"));

        int n = Integer.parseInt(scan.nextLine().trim());

        int[] grades = new int[n];

        for (int gradesItr = 0; gradesItr < n; gradesItr++) {
            int gradesItem = Integer.parseInt(scan.nextLine().trim());
            grades[gradesItr] = gradesItem;
        }

        int[] result = gradingStudents(grades);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bw.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bw.write("\n");
            }
        }

        bw.newLine();

        bw.close();
    }
}
