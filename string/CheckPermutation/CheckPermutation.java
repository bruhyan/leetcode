import java.util.Arrays;

// Given 2 strings, write a function to determine if one is a permutation of the other.
// assume strings are a-z

// In order for 2 strings to be permutation of one another:
// 1) they must be same length
// 2) they must have the same number of the same characters
// e.g. aabb, abab = true
// e.g. aabb, ababa = false

public class CheckPermutation {

    public static void main(String[] args) {
        String s1 = "aabb";
        String s2 = "a";

        System.out.println(checkPermutation(s1, s2));
    }

    // runtime complexity: O(n) where n is the length of one of the string
    // space complexity: O(n) because we created additional char arrays for the
    // string
    public static boolean checkPermutation(String s1, String s2) {
        if (s1.equals("") && s2.equals("")) {
            return true;
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        int[] charOccurrences = new int[26];
        Arrays.fill(charOccurrences, 0);

        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();

        for (char c : s1Arr) {
            int index = c - 'a';
            charOccurrences[index]++;
        }

        for (char c : s2Arr) {
            int index = c - 'a';
            charOccurrences[index]--;
        }

        for (int o : charOccurrences) {
            if (o != 0) {
                return false;
            }
        }

        return true;
    }
}
