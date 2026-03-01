package ru.shaxowskiy.javaurfuhomework.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 */
public class Anagram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstWord = scanner.nextLine();
        String secondWord = scanner.nextLine();

        System.out.println("Those word is anagram " + isAnagram(firstWord, secondWord));
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        Map<Character, Integer> countS = new HashMap<>();
        Map<Character, Integer> countT = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            countS.put(s.charAt(i), countS.getOrDefault(s.charAt(i), 0) + 1);
            countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0) + 1);
        }
        for (Character c: countS.keySet()){
            if (!Objects.equals(countS.get(c), countT.getOrDefault(c, 0))){
                return false;
            }
        }
        return true;
    }
}
