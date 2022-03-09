import java.util.*;

// Write a method to replace all spaces in a string with '%20'.
// You may assyme the string has sufficient space at the end to hold additional characters
// and that you are given the "true" length of the string.

//e.g.
// Input: "Mr John Smith    ", 13
// Output: "Mr%20John%20Smith"

public class URLify {
    public static void main(String[] args) {
        String input = "Mr John Smith    ";
        int len = 13;
        System.out.println(urlify(input, len));
    }

    public static String urlify(String input, int len) {
        char[] inputArr = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : inputArr) {
            if (len == 0) {
                break;
            }
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
            --len;
        }
        return sb.toString();
    }
}
