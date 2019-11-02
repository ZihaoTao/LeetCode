package test;

import java.util.Arrays;
import java.util.Comparator;

public class Test {
    public boolean[][] test(String s) {
        boolean[][] isPal = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j < s.length(); j++) {
                if(i == j) isPal[i][j] = true;
            }
        }
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j <= i; j++) {
                if(i == j + 1) isPal[j][i] = true;
                else isPal[j][i] = s.charAt(j) == s.charAt(i) && (j + 1 > i - 1 || isPal[j + 1][i - 1]);
            }
        }
        return isPal;
    }
    public static void main(String[] args) {
        String s = "aacecaaa";
        boolean[][] res = (new Test()).test(s);
        for(int i = 0; i < res.length; i++) {
            for(int j = 0; j < res[0].length; j++) {
                if(res[i][j]) {
                    System.out.print("T ");
                } else {
                    System.out.print("F ");
                }
            }
            System.out.println();
        }
    }
}
