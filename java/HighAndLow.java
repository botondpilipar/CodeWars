import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class HighAndLow {
    public static String highAndLow(String numbers) {
        IntSummaryStatistics stats = Arrays.stream(numbers.split(" "))
                .mapToInt(Integer::parseInt)
                .summaryStatistics();
        return new StringBuilder()
                .append(stats.getMax())
                .append(" ")
                .append(stats.getMin())
                .toString();
    }

    public static void main(String[] args) {

    }
}
