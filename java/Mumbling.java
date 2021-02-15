import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Mumbling {

    /**
     * This time no story, no theory. The examples below show you how to write function accum:
     *
     * Examples:
     *
     * accum("abcd") -> "A-Bb-Ccc-Dddd"
     * accum("RqaEzty") -> "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"
     * accum("cwAt") -> "C-Ww-Aaa-Tttt"
     */

    public static String accum(String s) {
        AtomicInteger repeatTimes = new AtomicInteger(0);
        return Arrays.stream(s.split(""))
                .map(w -> w.toUpperCase() + w.toLowerCase().repeat(repeatTimes.getAndIncrement()))
                .collect(Collectors.joining("-"));
    }

    public static void main(String[] args) {
        System.out.println(accum("asdf"));
    }
}
