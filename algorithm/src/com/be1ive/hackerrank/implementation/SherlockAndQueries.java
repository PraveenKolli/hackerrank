package com.be1ive.hackerrank.implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-queries
 *
 * Problem Statement
 *
 * Watson gives to Sherlock an array: A1,A2,⋯,AN. He also gives to Sherlock two other arrays: B1,B2,⋯,BM and C1,C2,⋯,CM.
 * Then Watson asks Sherlock to perform the following program:
 *
 * for i = 1 to M do
 *  for j = 1 to N do
 *      if j % B[i] == 0 then
 *          A[j] = A[j] * C[i]
 *      endif
 *  end do
 * end do
 *
 * Can you help Sherlock and tell him the resulting array A? You should print all the array elements modulo (109+7).
 *
 * Input Format
 * The first line contains two integer numbers N and M. The next line contains N integers, the elements of array A.
 * The next two lines contains M integers each, the elements of array B and C.
 *
 * Output Format
 * Print N integers, the elements of array A after performing the program modulo (109+7).
 *
 * Constraints
 * 1≤N,M≤105
 * 1≤B[i]≤N
 * 1≤A[i],C[i]≤105
 *
 **/
public class SherlockAndQueries {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        sc.nextLine();

        int[] A = new int[N];
        String[] sA = sc.nextLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(sA[i]);
        }

        int[] B = new int[M];
        String[] sB = sc.nextLine().split(" ");
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(sB[i]);
        }

        int[] C = new int[M];
        String[] sC = sc.nextLine().split(" ");
        for (int i = 0; i < M; i++) {
            C[i] = Integer.parseInt(sC[i]);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= M; i++) {
            if (B[i - 1] <= N) {
                Integer mult = map.get(B[i - 1]);

                map.put(B[i - 1], mult == null ? C[i - 1] : (int) ((((long) mult) * C[i - 1]) % 1_000_000_007) );
            }
        }

        for (int Bi : map.keySet()) {
            long mult = (long) map.get(Bi);
            for (int j = Bi; j <= N; j += Bi) {
                A[j - 1] = (int) ((mult * A[j - 1]) % 1_000_000_007);
            }
        }

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < N; ++i){
            sb.append(A[i] + " ");
        }
        System.out.print(sb.toString());
    }
}