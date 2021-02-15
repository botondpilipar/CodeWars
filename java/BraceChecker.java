import java.util.*;
import java.util.stream.Collectors;

public class BraceChecker {
    final Map<Character, Character> pairs = Collections.unmodifiableMap(Map.of('{', '}', '(', ')', '[', ']'));

    public boolean isOpening(char c) {
        return pairs.containsKey(c);
    }

    public boolean isClosing(char c) {
        return pairs.containsValue(c);
    }
    public boolean isInRightOrder(char opening, char closing) {
        return pairs.containsKey(opening) && pairs.get(opening) == closing;
    }
    public boolean isValid(String braces) {
        // Add code here
        Deque<Character> checker = new ArrayDeque<>();
        braces.chars().forEach(c -> {
            char first = (char)c;
            if(isClosing(first)
                    && isOpening(checker.getLast())
                    && isInRightOrder(checker.getLast(), first)) {
                checker.pop();
            } else {
                checker.push((char)c);
            }
        });
        return checker.isEmpty();
    }

    public static void main(String[] args) {
        BraceChecker checker = new BraceChecker();
        System.out.println(checker.isValid("(){[]}"));
        System.out.println(checker.isValid("({)"));
        System.out.println(checker.isValid("()"));
    }
}
