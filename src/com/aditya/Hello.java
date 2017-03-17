package com.aditya;

import java.util.Collections;
import java.util.HashMap;

/**
 * Created by adityaaggarwal on 28/2/17.
 */
public class Hello {
    public static void main(String[] args){
        //printDuplicates("HELLO");
        //printDuplicates("HOW ARE YOU DOING");
        permutation("", "123");
    }
    public static void printDuplicates(String sentence){
        char[] charArray = sentence.toCharArray();

        HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
        for(Character c : charArray){
            if(charMap.containsKey(c) ){
                charMap.put(c, charMap.get(c) + 1);
            }
            else
                charMap.put(c, 1);
        }
        System.out.println(Collections.singletonList(charMap));
    }
    public static void permutation(String w, String string){
        System.out.println(string);

            for (int i = 0; i < string.length(); i++) {
                permutation(w +  string.charAt(i), string.substring(0, i) + string.substring(i + 1, string.length()));
            }

    }
}
