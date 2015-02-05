package com.be1ive.hackerrank.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-cost
 *
 * Problem Statement
 *
 * Array A contains the elements, A1,A2...AN. And array B contains the elements, B1,B2...BN. There is a relationship between Ai and Bi, ∀ 1 ≤ i ≤ N, i.e.,
 * any element Ai lies between 1 and Bi.
 * Let cost S of an array A is defined as: ∑|A[i]−A[i−1]|
 * You have to print the largest possible value of S.
 *
 * Input Format
 *
 * The first line contains, T, the number of test cases. Each test case contains an integer, N, in first line.
 * The second line of each test case contains N integers that denote the array B.
 *
 * Output Format
 *
 * For each test case, print the required answer in one line.
 *
 **/
public class SherlockAndCost {

    /**
     * Complexity: : O(N)
     **/
    public static void main(String[] args) throws Exception {
        PrintWriter writer = new PrintWriter(System.out);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(reader.readLine());

            int[] b = new int [N];
            String[] s = reader.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                b[j] = Integer.parseInt(s[j]);
            }

            long[][] dp = new long[2][N];
            for (int j = 1; j < N; j++) {
                dp[0][j] = Math.max(dp[0][j - 1] + Math.abs(b[j] - b[j - 1]),
                        dp[1][j - 1] + Math.abs(b[j] - 1));


                dp[1][j] = Math.max(dp[0][j - 1] + Math.abs(b[j - 1] - 1),
                        dp[1][j - 1] + Math.abs(1 - 1));
            }


            writer.println(Math.max(dp[0][N - 1], dp[1][N - 1]));
        }
        writer.flush();
        writer.close();

    }

}
