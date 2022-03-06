import java.util.*;

public class UniqueCharsInString {
    public static void main(String[] args) {
        String input = "abcdef";
        boolean res = isCharsUniqueInString(input);
        System.out.println(res);

    }

    // returns true if string contains unique characters
    // assumption string only contain alphabets a-z
    public static boolean isCharsUniqueInString(String s) {
        char[] sArr = s.toCharArray();
        boolean[] charExist = new boolean[26];
        Arrays.fill(charExist, false);

        for (char x : sArr) {
            int index = x - 'a';
            if (charExist[index]) {
                return false;
            } else {
                charExist[index] = true;
            }
        }

        return true;
    }
}
