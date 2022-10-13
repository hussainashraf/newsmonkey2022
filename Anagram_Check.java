package RedHat_Assingment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Anagram_Check {
    /*
    * Code to check two string are anagram to each other or not
    * Brute Force Approach
    * Time Complexity O(N*logN) for sortng
    * Space Complexity O(1)for auxilary space
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //Taking input from user
        String s1 = sc.next();
        String s2 = sc.next();
//        boolean ans = checkAnagram(s1, s2); //Function to check given string is anagram or not
        boolean ans = OptimizedcheckAnagram(s1, s2); // Optimized Solution
        if (ans == true) {
            System.out.println("String is anagram");
        } else {
            System.out.println("String is not anagram");
        }
    }

    public static boolean checkAnagram(String s1, String s2) {
        //if length of string is not equal then it returns false(Not anagram)
        if (s1.length() != s2.length()) {
            return false;
        }
        char ch1[] = s1.toCharArray();
        char ch2[] = s2.toCharArray();

        // sorting the character according to the ascii value
        Arrays.sort(ch1);
        Arrays.sort(ch2);

        //if the string are same but the content of string are not same then return false
        for (int i = 0; i < ch1.length; i++) {
            if (ch1[i] != ch2[i]) {
                return false;
            }
        }
        return true;
    }
    /*
    OptimizedSolution
    Time Complexity = O(N)
    Space Complexity  = O(1) for hashmap
    */
    public static boolean OptimizedcheckAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) { //checking length
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        /*
        * We Use Hashmap for optimized solution where we set key as character and value as integer
        * iterate over string 1 and put the unique character in map along with 1 and if character is already present
        * then we increment 1 in the map
        */
        for (int i = 0; i < s1.length(); i++) {
            if (map.containsKey(s1.charAt(i))) {
                map.put(s1.charAt(i), map.get(s1.charAt(i)) + 1);
            } else {
                map.put(s1.charAt(i), 1);
            }

        }
        /*
        * now loop over string 2
        * if contain same character so it subtract -1
        * or if we encountered any unique character in string 2 then it return false(not anagram)
        */
        for (int i = 0; i < s2.length(); i++) {
            if (map.containsKey(s2.charAt(i))) {
                map.put(s2.charAt(i), map.get(s2.charAt(i)) - 1);
            } else {
                return false;
            }
        }
        /*
        *we check if map key are all zero then its anagram it any of the key is not zero then its non anagran
        */
        Set<Character> keys = map.keySet();
        for (Character key : keys) {
            if (map.get(key) != 0) {
                return false;
            }
        }
        return true;

    }


}
