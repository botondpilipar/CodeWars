import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DigPow {

    public static long digPow(int n, int p) {
        String[] seq = Integer.toString(n).split("");
        List<Integer> ints = Arrays.stream(seq).map(Integer::getInteger).collect(Collectors.toList());
        int sum = 0;

        for(String c : seq) {
            sum += (int)Math.pow(Integer.getInteger(c), p);
            p += 1;
        }

        return -1;
    }

    public static void main(String[] args) {

    }
}
