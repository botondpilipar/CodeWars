import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ReverseWords {
    public static String reverseString(final String str) {
        return new StringBuilder(str).reverse().toString();
    }
    public static String reverseWords(final String original)
    {
        return Arrays.stream(original.split(" "))
                .map(ReverseWords::reverseString)
                .collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        String reversed = ReverseWords.reverseWords("indians scattered on dawn's highway bleeding");
        System.out.println(reversed);
        System.out.println(ReverseWords.reverseWords("not my fault"));
        System.out.println(ReverseWords.reverseWords("The"));
    }
}
