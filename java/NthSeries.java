import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.IntStream;

public class NthSeries {

    public static String seriesSum(int n) {
        BigDecimal decimalForm =  new BigDecimal(
                Double.toString(
                IntStream.iterate(1, i -> i + 3)
                .limit(n)
                .asDoubleStream()
                .map(i -> 1 / i)
                .sum()));
        return decimalForm.setScale(2, RoundingMode.HALF_UP)
                .toString();
    }
}
