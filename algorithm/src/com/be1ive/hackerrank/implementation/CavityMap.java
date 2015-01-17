package com.be1ive.hackerrank.implementation;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/cavity-map
 *
 * Problem Statement
 *
 * You are given a square n×n map. Each cell of the map has a value in it denoting the depth of the appropriate area.
 * We will call a cell of the map a cavity if and only if this cell is not on the border of the map and each cell adjacent to it has strictly smaller depth.
 * Two cells are adjacent if they have a common side.
 *
 * You need to find all the cavities on the map and depict them with character X.
 *
 * Input Format
 *
 * The first line contains an integer n (1≤n≤100), denoting the size of the map. Each of the following n lines contains n positive digits without spaces.
 * A digit (1-9) denotes the depth of the appropriate area.
 *
 * Output Format
 *
 * Output n lines, denoting the resulting map. Each cavity should be replaced with character X.
 *
 **/
public class CavityMap {


    /**
     * Intuition: just check boundaries
     *
     * Complexity: O(N^2)
     **/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }

        // O(N^2)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < 1 || i > n - 2 ||
                        j < 1 || j > n - 2)
                {
                    System.out.print(map[i][j]);
                } else if (map[i][j] > map[i][j + 1] && map[i][j] > map[i][j - 1] &&
                        map[i][j] > map[i + 1][j] && map[i][j] > map[i - 1][j])
                {
                    System.out.print("X");
                } else {
                    System.out.print(map[i][j]);
                }
            }
            System.out.println("");
        }
    }
}