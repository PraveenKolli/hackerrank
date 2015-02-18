package com.be1ive.hackerrank.regexp;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://www.hackerrank.com/contests/regex-practice-1/challenges/ide-identifying-comments
 *
 * Jack wants to build an IDE on his own.
 * Help him build a feature which identifies the comments, in the source code of computer programs.
 * Assume, that the programs are written either in C, C++ or Java.
 * The commenting conventions are displayed here, for your convenience.
 * At this point of time you only need to handle simple and common kinds of comments. You don't need to handle nested comments,
 * or multi-line comments inside single comments or single-comments inside multi-line comments.
 *
 * Your task is to write a program, which accepts as input, a C or C++ or Java program and outputs only the comments from those programs.
 * Your program will be tested on source codes of not more than 200 lines.
 */
public class IdentifyingComments {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pattern pattern = Pattern.compile("((//.*?$)|(/\\*.*?\\*/))", Pattern.MULTILINE + Pattern.DOTALL);
        StringBuilder s = new StringBuilder();
        while (sc.hasNextLine()) {
            s.append(sc.nextLine()).append(System.lineSeparator());
        }
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            //don't know how to delete leading spaces in multiline using aforementioned regexp
            String[] results = matcher.group().split(System.lineSeparator());
            for(String result : results) {
                System.out.println(result.trim());
            }
        }
    }
}
