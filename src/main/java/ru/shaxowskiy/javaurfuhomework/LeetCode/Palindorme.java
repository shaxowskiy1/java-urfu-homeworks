package ru.shaxowskiy.javaurfuhomework.LeetCode;

import java.util.Scanner;

public class Palindorme {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstWord = scanner.nextLine();

        System.out.println("That word is palindrome " + isPalindrome(firstWord));
    }

    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {

            while(!Character.isLetterOrDigit(s.charAt(i))){
                if(i >= j){
                    return true;
                }
                i++;
            }
            while(!Character.isLetterOrDigit(s.charAt(j))){
                if(i >= j){
                    return true;
                }
                j--;
            }
            if ((Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))) && (isAlphaNumber(s.charAt(i), s.charAt(j)))) {
                i++;
                j--;
            } else if (s.charAt(i) != s.charAt(j)) {
                System.out.println("Not a palindrome. Letters: " + s.charAt(i) + s.charAt(j));
                return false;
            }
        }
        return true;
    }

    private static boolean isAlphaNumber(char c, char c1) {
        if(!Character.isLetterOrDigit(c) || !Character.isLetterOrDigit(c1)){
            return false;
        }
        return true;
    }
}
