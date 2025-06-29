package com.carlosdlr.algorithm.cs.foundation;

import java.util.*;

public class Testing {

    public static void main(String[] args) {

//        4)
//        Length of the longest substring without repeating characters
//        Given a string str, find the length of the longest substring without repeating characters.
//
//                Example:
//        For “ABDEFGABEF”, the longest substring are “BDEFGA” and “DEFGAB”, with length 6.
//
//        For “BBBB” the longest substring is “B”, with length 1.
//
//        For “GEEKSFORGEEKS”, there are two longest substrings shown in the below diagrams, with length 7

           char[] strArr = "GEEKSFORGEEKS".toCharArray();

           Set<Character> characters = new HashSet<Character>();
           int highestLength = 0;
           for (int i = 0; i < strArr.length; i++) {
               if(!characters.contains(strArr[i])) {
                   characters.add(strArr[i]);
               }

               if(characters.size() > highestLength) {
                   highestLength = characters.size();
               }
           }

           System.out.println(highestLength);

           //characters.stream().forEach(c -> System.out.println(c));



    }
}
