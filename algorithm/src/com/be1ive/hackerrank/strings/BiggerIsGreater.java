package com.be1ive.hackerrank.strings;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/bigger-is-greater
 *
 * Problem Statement
 *
 * Given a word w, rearrange the letters of w to construct another word s in such a way that, s is lexicographically greater than w.
 * In case of multiple possible answers, find the lexicographically smallest one.
 *
 * Input Format
 * The first line of input contains t, number of test cases. Each of the next t lines contains w.
 *
 * Constraints
 * 1 ≤ t ≤ 105
 * 1 ≤ |w| ≤ 100
 * w will contain only lower case english letters and its' length will not exceed 100.
 *
 * Output Format
 * For each testcase, output a string lexicographically bigger than w in a separate line.
 * In case of multiple possible answers, print the lexicographically smallest one and if no answer exists, print no answer.
 *
 */
public class BiggerIsGreater {


    /**
     * Complexity: : O(N*log(N))
     **/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            String str = sc.next();
            char[] s = str.toCharArray();
            int length = s.length;


            int i = length - 1;
            while (i > 0 && s[i] <= s[i - 1]) {
               i--;
            }

            if (i != 0) {
                int j = i;
                int k = i;
                while (j < length) {
                    if (s[j] > s[i - 1] && s[j] < s[k]) {
                        k = j;
                    }
                    j++;
                }

                char tmp = s[i - 1];
                s[i - 1] = s[k];
                s[k] = tmp;
                Arrays.sort(s, i, length);

                String bigger = new String(s);
                System.out.println(bigger);
            } else {
                System.out.println("no answer");
            }
        }
    }
}
