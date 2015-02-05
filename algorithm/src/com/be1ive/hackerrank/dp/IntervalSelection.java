package com.be1ive.hackerrank.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * https://www.hackerrank.com/challenges/interval-selection
 *
 * Problem Statement
 *
 * You are given a list of N intervals.
 * The challenge is to select the largest subset of intervals, such that, no three intervals in the subset share a common point.
 *
 * Input Format
 *
 * The first line contains the number of cases, T. Then T cases follow.
 * Each case contains the number N on the first line followed by N lines containing integers ai and bi.
 * The ith line denotes the starting and ending points of the ith interval.
 *
 * Output Format
 *
 * Output T lines, one for each test case, containing the desired answer for the corresponding test case.
 *
 **/
public class IntervalSelection {

    public static class Interval implements Comparable<Interval> {

        public final int a, b;

        public Interval(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Interval that) {
            int cmp = Integer.compare(this.b, that.b);

            if (cmp == 0) {
                return Integer.compare(this.a, that.a);
            } else {
                return cmp;
            }
        }

        @Override
        public String toString() {
            return "Line{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }

    /**
     * Intuition: sort all intervals by their end points then go from left to right and check overlapping
     * Complexity: : O(N*log(N))
     **/
    public static void main( String args[] ) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        int T = Integer.parseInt(reader.readLine());

        for(int t = 0; t < T; t++){

            int N;
            N = Integer.parseInt(reader.readLine());

            int A[] = new int[N];
            int B[] = new int[N];
            Interval[] I = new Interval[N];

            for(int i = 0; i < N; i++){
                String[] s = reader.readLine().split(" ");
                A[i] = Integer.parseInt(s[0]);
                B[i] = Integer.parseInt(s[1]);
                I[i] = new Interval(A[i], B[i]);
            }

            Arrays.sort(I);

            int result = 1;
            int permitStart = 1;
            Interval interval = I[0];
            for (int i = 1; i<N; i++) {
                if (I[i].a >= permitStart) {
                    result++;
                    if (interval.b >= I[i].a) {
                        permitStart = interval.b + 1;
                    }
                    interval = I[i];
                }
            }

            writer.println(result);
        }
        writer.flush();
        writer.close();
    }
}
