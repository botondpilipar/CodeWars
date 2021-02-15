import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class XO {
    public static <T> long frequency(T elem, T[] array) {
        return Arrays.stream(array)
                .filter(t -> t.equals(elem))
                .count();
    }

    private static <V> Map<V, Long> findFrequencies(final Collection<V> items)
    {
        return items.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
    public static boolean getXO (String str) {
        String[] letters = str.toLowerCase().split("");
        Map<String, Long> frequencyMap = findFrequencies(Arrays.asList(letters));
        return frequencyMap.get("x") == frequencyMap.get("o");
    }
}