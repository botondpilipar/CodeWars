import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class WhichAreIn {
    /**
     * Given two arrays of strings a1 and a2 return a sorted array r in lexicographical order of the strings of a1 which are substrings of strings of a2.
     *
     * #Example 1: a1 = ["arp", "live", "strong"]
     *
     * a2 = ["lively", "alive", "harp", "sharp", "armstrong"]
     *
     * returns ["arp", "live", "strong"]
     *
     * #Example 2: a1 = ["tarp", "mice", "bull"]
     *
     * a2 = ["lively", "alive", "harp", "sharp", "armstrong"]
     *
     * returns []
     */

    public static Boolean isSubstring(String sub, String whole) {
        if (whole.length() < sub.length()) {
            return false;
        } else if (whole.length() == sub.length()) {
            return sub.compareTo(whole) == 0;
        } else if (whole.charAt(0) != sub.charAt(0)) {
            return isSubstring(sub, whole.substring(whole.indexOf((sub.charAt(0)))));
        } else {
            return sub.compareTo(whole.substring(0, sub.length())) == 0
                    || isSubstring(sub, whole.substring(whole.indexOf((sub.charAt(0)))));
        }
    }

    public static String[] inArray(String[] array1, String[] array2) {
        return Arrays.stream(array1)
                .filter(word -> Arrays.stream(array2)
                                    .anyMatch(whole -> isSubstring(word, whole)))
                .sorted(String::compareTo)
                .toArray(String[]::new);
    }

    public static void main(String[] args) {

    }
}
