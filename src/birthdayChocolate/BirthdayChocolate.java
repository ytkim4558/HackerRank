package birthdayChocolate;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BirthdayChocolate {

    // Complete the solve function below.
    static int solve(int[] s, int d, int m) {
        int sum = 0;
        int resultCnt = 0;
        int cnt = 0;
        int[] temp = new int[m];
        for(int i: s) {
            ++cnt;
            sum -= temp[cnt % m];
            temp[cnt % m] = i;
            sum += i;

            if(cnt >= m && sum == d) {
                ++resultCnt;
            }
            System.out.println("cnt: "+ cnt + ", i: " + i + ", sum: " + sum + ", resultCnt : " + resultCnt);
        }

        return resultCnt;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("out/production/hackerrank/brithdayChocolate.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] s = new int[n];

        String[] sItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int sItem = Integer.parseInt(sItems[i]);
            s[i] = sItem;
        }

        String[] dm = scanner.nextLine().split(" ");

        int d = Integer.parseInt(dm[0]);

        int m = Integer.parseInt(dm[1]);

        int result = solve(s, d, m);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
