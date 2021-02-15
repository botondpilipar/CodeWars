import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class DnaStrand {
    public static String makeComplement(String dna) {
        final Map<String, String> baseComplement = Map.of(
                "A", "G",
                "C", "T",
                "G", "A",
                "T", "C");

        return Arrays.stream(dna.split(""))
                .map(baseComplement::get)
                .collect(Collectors.joining());
    }
}
