package maskinganagrams;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


// link : https://www.hackerrank.com/challenges/ctci-making-anagrams/problem
public class MaskingAnagrams {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int[] alphabetsA = new int[26]; // for counting a's alphabets
        int[] alphabetsB = new int[26]; // for counting b's alphabets
        Arrays.fill(alphabetsA, 0);
        Arrays.fill(alphabetsB, 0);

        for(int i = 0; i<a.length(); i++) {
            ++alphabetsA[a.charAt(i)-'a'];
        }

        for(int i = 0; i<b.length(); i++) {
            ++alphabetsB[b.charAt(i)-'a'];
        }

        int sum = 0;
        for(int i = 0; i<26; ++i) {
            int difference = alphabetsA[i] - alphabetsB[i];
            sum += difference >= 0 ? difference : -1 * difference;
        }

        System.out.println(sum);

        scanner.close();
    }
}
