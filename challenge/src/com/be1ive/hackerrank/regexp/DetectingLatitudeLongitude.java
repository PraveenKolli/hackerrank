package com.be1ive.hackerrank.regexp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.regex.Pattern;

/**
 * https://www.hackerrank.com/contests/regex-practice-1/challenges/detecting-valid-latitude-and-longitude
 *
 * Problem Statement
 *
 * Given a line of text which possibly contains the latitude and longitude of a point,
 * can you use regular expressions to identify the latitude and longitude referred to (if any)?
 *
 * Format: (X, Y) where -90<=X<=+90 and -180<=Y<=180.
 */
public class DetectingLatitudeLongitude {

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        int n = Integer.parseInt(reader.readLine());
        Pattern pattern = Pattern.compile("^\\([+-]?((([1-9]|[1-8][0-9])(\\.[0-9]+)?)|90(\\.0+)?), [-+]?((([1-9][0-9]?|1[0-7][0-9])(\\.[0-9]+)?)|180(\\.0+)?)\\)$");
        while (--n >= 0) {
            String s = reader.readLine();
            if (pattern.matcher(s).matches()) {
                writer.println("Valid");
            } else {
                writer.println("Invalid");
            }
        }
        writer.flush();
        writer.close();
    }
}
