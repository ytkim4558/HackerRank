package breakingTheRecords;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


// https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem

public class BreakingTheRecords {
    private static final Scanner scanner = new Scanner(System.in);

    // Complete the breakingRecords function below.
    static int[] breakingRecords(int[] scores) {
        int[] outputs = new int[2];
        int min, max;
        if (scores.length >= 1) {
            min = scores[0];
            max = scores[0];

            for (int score : scores) {
                if (score < min) {
                    outputs[1] += 1;
                    min = score;
                }
                if (score > max) {
                    outputs[0] += 1;
                    max = score;
                }
            }
        }

        return outputs;
    }

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("out/production/hackerrank/breakingTheRecords.txt"));
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[n];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int[] result = breakingRecords(scores);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
