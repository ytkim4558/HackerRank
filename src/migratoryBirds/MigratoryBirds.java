package migratoryBirds;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/migratory-birds/problem 풀이
public class MigratoryBirds {

    // Complete the migratoryBirds function below.
    static int migratoryBirds(int[] ar) {
        int[] typeCounts = new int[ar.length];
        int maxTypeCount = -1;
        int maxType = Integer.MAX_VALUE;
        for(int type: ar) {
            typeCounts[type] = typeCounts[type] + 1;
            if(typeCounts[type] >= maxTypeCount) {
                maxTypeCount = typeCounts[type];
            }
        }
        for(int type: ar) {
            if(typeCounts[type] == maxTypeCount && type < maxType) {
                maxType = type;
            }
        }

        return maxType;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("out/production/hackerrank/migratoryBirds.txt"));

        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = migratoryBirds(ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
