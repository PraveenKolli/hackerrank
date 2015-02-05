package com.be1ive.hackerrank.implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/service-lane
 *
 * Problem Statement
 *
 * Calvin is driving his favorite vehicle on the 101 freeway.
 * He notices that the check engine light of his vehicle is on, and he wants to service it immediately to avoid any risks.
 * Luckily, a service lane runs parallel to the highway. The length of the highway and the service lane is N units.
 * The service lane consists of N segments of unit length, where each segment can have different widths.
 * Calvin can enter into and exit from any segment. Let's call the entry segment as index i and the exit segment as index j.
 * Assume that the exit segment lies after the entry segment(j>i) and i ≥ 0. Calvin has to pass through all segments from index i to indexj (both inclusive).
 * Paradise Highway
 * Calvin has three types of vehicles - bike, car and truck, represented by 1, 2 and 3 respectively.
 * These numbers also denote the width of the vehicle. We are given an array width[] of length N, where width[k] represents the width of kth segment of our service lane.
 * It is guaranteed that while servicing he can pass through at most 1000 segments, including entry and exit segments.
 * If width[k] is 1, only the bike can pass through kth segment.
 * If width[k] is 2, the bike and car can pass through kth segment.
 * If width[k] is 3, any of the bike, car or truck can pass through kth segment.
 * Given the entry and exit point of Calvin's vehicle in the service lane, output the type of largest vehicle which can pass through the service lane (including the entry & exit segment)
 *
 * Input Format
 * The first line of input contains two integers - N & T, where N is the length of the freeway, and T is the number of test cases.
 * The next line has N space-separated integers which represents the width array.
 *
 * T test cases follow. Each test case contains two integers - i & j, where i is the index of segment through which Calvin enters the service lane and j is the index of the lane segment where he exits.
 *
 * Output Format
 * For each test case, print the number that represents the largest vehicle type that can pass through the service lane.
 *
 * Note
 * Calvin has to pass through all segments from index i to indexj (both inclusive).
 *
 * Constraints
 * 2 <= N <= 100000
 * 1 <= T <= 1000
 * 0 <= i < j < N
 * 2 <= j-i+1 <= min(N,1000)
 * 1 <= width[k] <= 3, where 0 <= k < N
 **/
public class ServiceLane {

    /**
     * Intuition: overall task is to find minimum on service lane path for given boundaries,
     *            we can do it using pre build minimum segment tree on our array it has O(N) complexity, then
     *            just compute minimum it has O(N*log(N)) complexity
     *
     * Complexity build: O(N)
     * Complexity query: O(log(N))
     **/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int T = sc.nextInt();
        int[] w = new int[N];
        for (int i = 0; i < N; i++) {
            w[i] = sc.nextInt();
        }

        // O(N)
        MinSegmentTree mst = new MinSegmentTree(w);
        while (--T >= 0) {
            System.out.println(mst.min(sc.nextInt(), sc.nextInt()));
        }
    }

    public static class MinSegmentTree {

        private int[] segmentTree;
        private int[] store;
        private int capacity;

        public MinSegmentTree(int[] store) {

            // ~ O(log(n))
            this.capacity = 1;
            while (this.capacity < store.length) {
                this.capacity <<= 1;
            }

            this.store = new int[this.capacity];
            //
            // ~ O(2*n)
            for (int i = 0; i < this.capacity; i++) {
                this.store[i] = Integer.MAX_VALUE;
            }
            //
            // O(n)
            System.arraycopy(store, 0, this.store, 0, store.length);

            //
            // ~ O(4*n)
            this.segmentTree = new int[2 * this.capacity - 1];

            build(0, this.capacity - 1, 0);

        }

        public void set(int i, int value) {
            int index = segmentTree.length - capacity + i;
            segmentTree[index] = value;

            rebuild(parent(index));
        }

        public int min(int l, int r) {
            return min(l, r, 0, capacity - 1, 0);
        }

        public int min(int l, int r, int s, int e, int i) {
            if (s == l && e == r) {
                return segmentTree[i];
            } else {
                int mid = s + (e - s) / 2;
                int left = left(i);
                int right = right(i);

                if (l <= mid && r > mid) {
                    return Math.min(min(l, mid, s, mid, left), min(mid + 1, r, mid + 1, e, right));
                } else if (l <= mid && r <= mid) {
                    return min(l, r, s, mid, left);
                } else {
                    return min(l, r, mid + 1, e, right);
                }

            }

        }

        private void rebuild(int i) {
            if (i < segmentTree.length && i >= 0) {
                int left = left(i);
                int right = right(i);

                segmentTree[i] = Math.min(segmentTree[left], segmentTree[right]);
                rebuild(parent(i));
            }
        }

        private int build (int l, int h, int i) {
            if (l <= h) {
                int mid = l + (h - l) / 2;
                int left = left(i);
                int right = right(i);

                int min;
                if (left < segmentTree.length && right < segmentTree.length) {
                    min = Math.min(build(l, mid, left), build(mid + 1, h, right));
                } else {
                    min = store[mid];
                }
                segmentTree[i] = min;
                return min;
            } else {
                return Integer.MAX_VALUE;
            }
        }

        private static int parent(int i) {
            return ((i + 1) >> 1) - 1;
        }


        private static int left(int i) {
            return ((i + 1) << 1) - 1;
        }


        private static int right(int i) {
            return ((i + 1) << 1);
        }

    }
}
