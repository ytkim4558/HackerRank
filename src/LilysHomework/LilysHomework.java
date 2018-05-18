package lilyshomework;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// link : https://www.hackerrank.com/challenges/lilys-homework/problem
public class LilysHomework {
    // Complete the lilysHomework function below.
    static int lilysHomework(int[] arr) {
        // 1. find unsorted arr small element alpha.
        // 2. find more smaller element beta than alpha.
        // 3. find unsorted arr big element A.
        // 4. find more bigger element B than A.
        // 5. swap B and beta if beta is smaller than B.


        return loopSwap(arr);
    }

    static int loopSwap(int[] arr) {
        int smallestIndex = -1;
        int bigIndex = -1;
        int smallValue = 0;
        int biggestIndex = -1;
        int bigValue = 0;
        boolean isUnsortedSmallFound = false, isUnsortedBigFound = false;
        int swapCnt = 0;
        while(true) {
            for(int i = 0; i<arr.length; ++i) {
                if(!isUnsortedSmallFound) {
                    if( i+1 < arr.length && arr[i] > arr[i+1]) {
                        isUnsortedSmallFound = true;
                        smallestIndex = i;
                        smallValue = arr[i];
                    }
                    if(i-1 >= 0 && arr[i] < arr[i-1]) {
                        isUnsortedSmallFound = true;
                        smallestIndex = i;
                        smallValue = arr[i];
                    }
                } else if(arr[i] < smallValue ) {
                    smallValue = arr[i];
                    smallestIndex = i;
                }
                if(!isUnsortedBigFound && i-1 >= 0) {
                    if(i+1 < arr.length && arr[i+1] < arr[i]) {
                        isUnsortedBigFound = true;
                        biggestIndex = i;
                        bigValue = arr[i];
                    }
                    if(i-1 >= 0 && arr[i-1] > arr[i]) {
                        isUnsortedBigFound = true;
                        biggestIndex = i;
                        bigValue = arr[i];
                    }
                } else if(arr[i] > bigValue ) {
                    bigValue = arr[i];
                    biggestIndex = i;
                }

            }
            if(smallValue < bigValue && smallestIndex > biggestIndex) {
                arr = swap(arr, smallestIndex, biggestIndex);
                System.out.println("small" + arr[smallestIndex]);
                System.out.println("big" + arr[biggestIndex]);
                ++swapCnt;
                smallestIndex = -1;
                bigIndex = -1;
                smallValue = 0;
                biggestIndex = -1;
                bigValue = 0;
                isUnsortedSmallFound = false;
                isUnsortedBigFound = false;
            } else {
                break;
            }
            printArray(arr);
        }
        printArray(arr);
        return swapCnt;

    }

    static void printArray(int[] arr) {
        for(int i=0; i<arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    static int[] swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        return arr;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("out/production/hackerrank/lilyshomework/lilyshomework.txt"));
        BufferedReader bufferedReader = new BufferedReader(new FileReader( "src/lilyshomework/lilyshomeworkInput.txt"));


//        int n = scanner.nextInt();
        int n = Integer.parseInt(bufferedReader.readLine());
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

//        String[] arrItems = scanner.nextLine().split(" ");
        String[] arrItems = bufferedReader.readLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = lilysHomework(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
