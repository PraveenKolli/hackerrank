package com.be1ive.hackerrank.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * https://www.hackerrank.com/challenges/sam-and-substrings
 *
 * Problem Statement
 *
 * Samantha and Sam are playing a game.
 * They have 'N' balls in front of them, each ball numbered from 0 to 9, except the first ball which is numbered from 1 to 9.
 * Samantha calculates all the sub-strings of the number thus formed, one by one.
 * If the sub-string is S, Sam has to throw 'S' candies into an initially empty box.
 * At the end of the game, Sam has to find out the total number of candies in the box, T.
 * As T can be large, Samantha asks Sam to tell T % (109+7) instead.
 * If Sam answers correctly, he can keep all the candies. Sam can't take all this Maths and asks for your help.
 *
 * Input Format
 *
 * A single line containing a string of numbers that appear on the first, second, third ball and so on.
 *
 * Output Format
 *
 * A single line which is the number of candies in the box, T % (109+7)
 *
 **/

public class SamAndSubStrings {

    /**
     * Complexity: : O(N)
     **/
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        String N = reader.readLine();

        long[] dp = new long[N.length()];
        dp[0] = Integer.parseInt(N.substring(0, 1));
        for (int i = 1; i < N.length(); i++) {
            dp[i] = ((10 * dp [i - 1]) % 1_000_000_007l +
                    ((i + 1) * Integer.parseInt(N.substring(i, i + 1))) % 1_000_000_007) % 1_000_000_007l;

        }

        long sum = 0;
        for (int i = 0; i < N.length(); i++) {
            sum = (sum + dp[i]) % 1_000_000_007l;
        }

        writer.println(sum);
        writer.flush();
        writer.close();
    }

}
