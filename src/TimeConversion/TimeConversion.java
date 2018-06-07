package TimeConversion;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/time-conversion/problem
public class TimeConversion {
    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */

        if(s.contains("A")) { // AM
            int hour = Integer.parseInt(s.substring(0, 2));

            // 12이상인 경우.. 예: 12:00:00 인경우 00:00:00으로 바꿔야하므로 12를 뺀다
            if (hour >= 12) hour-=12;
            String hourString = String.valueOf(hour);

            // 10보다 작은 경우 앞에 0을 붙인다. 예) 9:30:30 -> 09:30:30 으로 형식 맞추기 위함
            if (hour <= 9) hourString = "0" + hourString;
            return hourString + s.substring(2, s.length() - 2);
        } else { // PM
            int hour = Integer.parseInt(s.substring(0, 2));
            if(hour<12) hour+=12;
            String hourString = String.valueOf(hour);
            return hourString + s.substring(2, s.length() - 2);
        }

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
