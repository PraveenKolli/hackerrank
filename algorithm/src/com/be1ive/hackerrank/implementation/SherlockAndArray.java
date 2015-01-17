package com.be1ive.hackerrank.implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-array
 *
 * Problem Statement
 * Watson gives an array A1,A2...AN to Sherlock.
 * Then he asks him to find if there exists an element in the array, such that, the sum of elements on its left is equal to the sum of elements on its right.
 * If there are no elements to left/right, then sum is considered to be zero.
 * Formally, find an i, such that, A1+A2...Ai-1 = Ai+1+Ai+2...AN.
 *
 * Input Format
 * The first line contains T, the number of test cases. For each test case, the first line contains N, the number of elements in the array A.
 * The second line for each testcase contains N space separated integers, denoting the array A.
 *
 * Output Format
 * For each test case, print YES if there exists an element in the array, such that, the sum of elements on its left is equal to the sum of elements on its right, else print NO.
 *
 * Constraints
 * 1 ≤ T ≤ 10
 * 1 ≤ N ≤ 105
 * 1 ≤ Ai ≤ 2*104 for 1 ≤ i ≤ N
 **/
public class SherlockAndArray {

    /**
     * Intuition: we can store subsums for source array A such as sum[i] = A[0] + A[1] + ... + A[i], and then
     *            left sum for i-th element equals sum[i - 1]
     *            right sum for i-th element equals sum[n] - sum[i]
     *
     * Complexity: O(T*N)
     *
     * Memory: O(N)
     **/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(--T >= 0) {
            int N = sc.nextInt();
            int[] sum = new int[N];
            for (int i = 0; i < N; i++) {
                sum[i] = sc.nextInt() + ( i > 0 ? sum[i - 1] : 0);
            }

            boolean find = false;
            for (int i = 0; i < N; i++) {
                if (( i > 0 ? sum[i - 1] : 0) == sum[N - 1] - sum[i]) {
                    find = true;
                    break;
                }
            }

            if (find) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

}
