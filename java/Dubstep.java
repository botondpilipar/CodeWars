import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Dubstep {
    public static String SongDecoder (String song){
       // Examplu input: WUBWUBIWUBAMWUBWUBX
        return Arrays.stream(song.split("WUB"))
                .filter(Predicate.not(String::isEmpty))
                .map(String::trim)
                .collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        System.out.println(SongDecoder("RWUBWUBWUBLWUB"));
        System.out.println(SongDecoder("WUBWUBIWUBWUBAMWUBLEGEND"));
    }
  }