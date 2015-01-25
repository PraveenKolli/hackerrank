package com.be1ive.hackerrank.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * https://www.hackerrank.com/challenges/longest-increasing-subsequent
 *
 * Problem Statement
 *
 * In this challenge you simply have to find the length of the longest strictly increasing sub-sequence of the given sequence.
 *
 * Input Format
 *
 * In the first line of input, there is a single number N.
 * In the next N lines input the value of a[i].
 *
 * Output Format
 *
 * In a single line, output the length of the longest increasing sub-sequence.
 *
 **/
public class LongestIncreasingSubsequence {

    private static Integer greaterBinarySearch(int[] a, int elem) {

        int start = 0;
        int end = a.length;
        int middle = start + (end - start) / 2;
        while (start <= end) {
            middle = start + (end - start) / 2;

            if (a[middle] < elem) {
                start = middle + 1;
            } else if (a[middle] > elem) {
                end = middle - 1;
            } else {
                while (++middle < a.length) {
                    if (a[middle] > elem) {
                        return middle;
                    }
                }
                return null;
            }
        }

        if (a[middle] < elem) {
            while (++middle < a.length) {
                if (a[middle] > elem) {
                    return middle;
                }
            }
            return null;
        } else {
            while (--middle >= 0) {
                if (a[middle] <= elem) {
                    return middle + 1;
                }
            }
            return middle + 1;
        }
    }

    /**
     * Intuition: dp[i] is a number, on which increasing sub-sequence with length i ends.
     *            initialize dp[0] = - MAX_VALUE and dp[i] = MAX_VALUE.
     *            calculate for a[0], a[1] ...
     *
     * Complexity: : O(N*log(N))
     **/
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        int N = Integer.parseInt(reader.readLine());

        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(reader.readLine());
        }

        int[] dp = new int[N + 1];
        dp[0] = -Integer.MAX_VALUE;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        int max = 1;
        for (int i = 0; i < N; i++) {
            Integer j = greaterBinarySearch(dp, a[i]);
            if (j != null && dp[j - 1] < a[i] && dp[j] > a[i]) {
                dp[j] = a[i];

                if (max < j) {
                    max = j;
                }
            }
        }

        writer.println(max);
        writer.flush();
        writer.close();
    }
}