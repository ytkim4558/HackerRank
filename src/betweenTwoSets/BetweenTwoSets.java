package betweenTwoSets;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/between-two-sets/problem


//The elements of the first array are all factors of the integer being considered
//The integer being considered is a factor of all elements of the second array

//Input Format
//
    //The first line contains two space-separated integers describing the respective values of n, the number of elements in array a, and m, the number of elements in array b.
    //The second line contains  distinct space-separated integers describing a0, a1, ...., an-1.
    //The third line contains  distinct space-separated integers describing b0, b1, ..., bm-1.
//
//Output Format
//
    //Print the number of integers that are considered to be between a and b.


//Sample Input
//
//2 3 (행의 원소 개수)
//2 4 (첫번째 행 원소들)
//16 32 96 (두번째 행 원소들)
//Sample Output
//
//3

// Explanation
//2 and 4 divide evenly into 4, 8, 12 and 16.
//4, 8 and 16 divide evenly into 16, 32, 96.
//
//4, 8 and 16 are the only three numbers for which each element of A is a factor and each is a factor of all elements of B.

// My solve
// 첫번째 행의 공배수면서 두번쨰 행의 공약수가 되는 수를 찾아야한다.
// 공배수의 경우 무제한으로 있을 것이므로 두번째행의 공약수를 먼저 구하고 그중 첫번째 행의 공배수가 되는 수들을 찾는다.
// 위의 찾은 수들의 개수를 구한다.

public class BetweenTwoSets {

    /*
     * Complete the getTotalX function below.
     */
    static int getTotalX(int[] a, int[] b) {
        /*
         * Write your code here.
         */

        // b의 공약수가 되는 것을 찾기
        ArrayList<Integer> gcd = getGCD(b);

        // b의 공약수중 a의 공배수 되는 것을 구하기 (a의 가장 큰수보다 크거나 같고, b의 가장 작은수보다 작거나 같은 수들로)
        ArrayList<Integer> lcd = getLCDWithArray(a, gcd);

        return lcd.size();
    }

    /**
     *
     * b 행렬 원소의 공약수를 arr 원소중에서 구함
     * @param b 공약수를 구할 배열
     * @param arr
     * @return
     */
    static ArrayList<Integer> getLCDWithArray(int[] b, ArrayList<Integer> arr) {
        ArrayList<Integer> lcd = new ArrayList<>();
        //
        for(int arri : arr) {
            boolean mismatch = false; // 공약수가 안되는 조건이 있는지 확인
            for(int bi: b) {
                if(arri % bi != 0) {
                    mismatch = true;
                    break;
                }
            }
            if(!mismatch) {
                lcd.add(arri);
                System.out.println(arri);
            }
        }
        return lcd;
    }

    static ArrayList<Integer> getGCD(int[] a) {

        int max = getMax(a);
        ArrayList<Integer> gcd = new ArrayList<Integer>();
        for(int i=max; i>=1; --i) {
            boolean mismatch = false; // 공약수가 안되는 조건이 있는지 확인
            for(int ai: a) {
                if(ai % i != 0) {
                    mismatch = true;
                    break;
                }
            }
            if(!mismatch) {
                gcd.add(i);
            }
        }
        return gcd;
    }

    static int getMax(int[] a) {
        int max = 0;
        for(int i: a) {
            if(i > max) {
                max = i;
            }
        }
        return max;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bw = new BufferedWriter(new FileWriter("out/production/hackerrank/betweenTwoSets.txt"));

        String[] nm = scan.nextLine().split(" ");

        int n = Integer.parseInt(nm[0].trim());

        int m = Integer.parseInt(nm[1].trim());

        int[] a = new int[n];

        String[] aItems = scan.nextLine().split(" ");

        for (int aItr = 0; aItr < n; aItr++) {
            int aItem = Integer.parseInt(aItems[aItr].trim());
            a[aItr] = aItem;
        }

        int[] b = new int[m];

        String[] bItems = scan.nextLine().split(" ");

        for (int bItr = 0; bItr < m; bItr++) {
            int bItem = Integer.parseInt(bItems[bItr].trim());
            b[bItr] = bItem;
        }

        int total = getTotalX(a, b);

        bw.write(String.valueOf(total));
        bw.newLine();

        bw.close();
    }
}