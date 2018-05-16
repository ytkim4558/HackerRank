package bombermangame;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
public class BombermanGame {
    // Complete the bomberMan function below.
    static String[] bomberMan(int n, String[] grid) {
        int r = grid.length;
        String a;
        int c = grid[0].length();

        if (n==1) return grid; // after 1second is same
        else if(n%2==0) return changeToallO(grid); // after 2second will all 'O' .. also all after 2n sec are same.
        else {
            // there are two types. A type(3, 7, 11 sec.. 4n-1), B type(5, 9sec, .... 4n+1)
            // first need to get A type
            String[] newGridA = bombdetonated(c, grid);
            if(n%4==3) return newGridA;

            else {
                String[] newGridB = bombdetonated(c, newGridA);
                return newGridB;
            }
        }
    }

    static String[] changeToallO(String[] grid) {
        String[] allO = new String[grid.length];
        for(int i=0; i<grid.length; ++i) {
            allO[i] = "";
            for(int j =0; j<grid[i].length(); ++j) {
                allO[i] += "O";
            }
        }
        return allO;
    }

    static String[] bombdetonated(int c, String[] grid) {
        String []newGrid = changeToallO(grid);
        for(int i=0; i<grid.length; ++i) {
            for(int j =0; j<grid[i].length(); ++j) {
                if(grid[i].charAt(j)=='O') {
                    if((j+1) % c != 1 && j-1 >= 0) { // if j is not most left element
                        // newGrid[i].charAt(j-1) = '.';
                        newGrid[i] = changeCharAt(newGrid[i], j-1, '.');
                    }
                    if((j+1) % c != 0 && j+1 < grid[i].length()) { // if j is not most right element
                        // newGrid[i].charAt(j+1) = '.';
                        newGrid[i] = changeCharAt(newGrid[i], j+1, '.');
                    }
                    if(i-1 >= 0) { // if i-1 is not over top
                        // newGrid[i-1].charAt(j) = '.';
                        newGrid[i-1] = changeCharAt(newGrid[i-1], j, '.');
                    }
                    if(i+1 < grid.length) { // if i+1 is not below bottom
                        // newGrid[i+1].charAt(j) = '.';
                        newGrid[i+1] = changeCharAt(newGrid[i+1], j, '.');
                    }
                    // newGrid[i].charAt(j) = '.';
                    newGrid[i] = changeCharAt(newGrid[i], j, '.');
                }
            }

        }
        return newGrid;
    }

    static String changeCharAt(String s, int n, char c) {
        String before = "";
        String after = "";
        if(n >= 0 && n < s.length()) before = s.substring(0, n);
        if(n+1 >= 0 && n+1 < s.length()) after = s.substring(n+1, s.length());
        return before + c + after;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("out/production/hackerrank/bombermangame/bomberManOutput.txt"));
        BufferedReader bufferedReader = new BufferedReader(new FileReader( "src/bombermangame/bomberManInput.txt"));

//        String[] rcn = scanner.nextLine().split(" ");
        String[] rcn = bufferedReader.readLine().split(" ");

        int r = Integer.parseInt(rcn[0]);

        int c = Integer.parseInt(rcn[1]);

        int n = Integer.parseInt(rcn[2]);

        String[] grid = new String[r];

//        for (int i = 0; i < r; i++) {
//            String gridItem = scanner.nextLine();
//            grid[i] = gridItem;
//        }
        for (int i = 0; i < r; i++) {
            String gridItem = bufferedReader.readLine();
            grid[i] = gridItem;
        }

        bufferedReader.close();

        String[] result = bomberMan(n, grid);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();

        System.out.println("show the result file : out/bomberManOutput.txt");
    }
}
