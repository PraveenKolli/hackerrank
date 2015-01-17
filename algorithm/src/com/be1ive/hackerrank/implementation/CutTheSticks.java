package com.be1ive.hackerrank.implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/cut-the-sticks
 *
 * Problem Statement
 *
 * You are given N sticks, where each stick is of positive integral length.
 * A cut operation is performed on the sticks such that all of them are reduced by the length of the smallest stick.
 * Suppose we have 6 sticks of length*
 * 5 4 4 2 2 8
 * then in one cut operation we make a cut of length 2 from each of the 6 sticks. For next cut operation 4 sticks are left (of non-zero length), whose length are
 * 3 2 2 6
 * Above step is repeated till no sticks are left.
 * Given length of N sticks, print the number of sticks that are cut in subsequent cut operations.
 *
 * Input Format
 * The first line contains a single integer N.
 * The next line contains N integers: a0, a1,...aN-1 separated by space, where ai represents the length of ith stick.
 *
 * Output Format
 * For each operation, print the number of sticks that are cut in separate line.
 *
 * Constraints
 * 1 ≤ N ≤ 1000
 * 1 ≤ ai ≤ 1000
 **/
public class CutTheSticks {

    /**
     * Intuition: sort all sticks and then in one loop count stick cuts
     *
     * Complexity: O(N*log(N))
     **/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] sticks = new int[N];
        while (--N >= 0) {
            sticks[N] = sc.nextInt();
        }



        // O(N*log(N))
        Arrays.sort(sticks);

        int count = sticks.length;
        // O(N)
        for (int i = 1; i < sticks.length;) {
            System.out.println(count);
            while (i < sticks.length && sticks[i] == sticks[i  - 1]) {
                count--;
                i++;
            }
            count--;
            i++;
        }
        if (count > 0) {
            System.out.println(count);
        }

    }

}
