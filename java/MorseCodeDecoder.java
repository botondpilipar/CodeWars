import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MorseCodeDecoder {
    /**
     * Morse code letters
     *      A	. _	 	    N	_ .
     *  	B	_ . . .	 	O	_ _ _
     *  	C	_ . _ .	 	P	. _ _ .
     *  	D	_ . .	 	Q	_ _ . _
     *  	E	.	 	    R	. _ .
     *  	F	. . _ .	 	S	. . .
     *  	G	_ _ .	 	T	_
     *  	H	. . . .	 	U	. . _
     *  	I	. .	 	    V	. . . _
     *  	J	. _ _ _	 	W	. _ _
     *  	K	_ . _	 	X	_ . . _
     *  	L	. _ . .	 	Y	_ . _ _
     *  	M	_ _	 	    Z	_ _ . .
     *
     *  Morse code numbers
     *      1	. _ _ _ _	 	6	_ . . . .
     *  	2	. . _ _ _	 	7	_ _ . . .
     *  	3	. . . _ _	 	8	_ _ _ . .
     *  	4	. . . . _	 	9	_ _ _ _ .
     *  	5	. . . . .	 	0	_ _ _ _ _
     */
    public static String decode(String morseCode) {
       Map<String, String> translator = new HashMap<>();
        translator.put(".-", "A");       translator.put("-...", "B");
        translator.put("-.-.", "C");     translator.put("-..", "D");
        translator.put(".", "E");        translator.put("..-.", "F");
        translator.put("--.", "G");       translator.put("....", "H");
        translator.put("..", "I");       translator.put(".---", "J");
        translator.put("-.-", "K");      translator.put(".-..", "L");
        translator.put("--", "M");       translator.put("-.", "N");
        translator.put("---", "O");      translator.put(".--.", "P");
        translator.put("--.-", "Q");     translator.put(".-.", "R");
        translator.put("...", "S");      translator.put("-", "T");
        translator.put("..-", "U");      translator.put("...-", "V");
        translator.put(".--", "W");      translator.put("-..-", "X");
        translator.put("-.--", "Y");     translator.put("--..", "Z");
        translator.put("··---···", "SOS");
        translator.put("--..--", ",");   translator.put("..--..", "?");
        translator.put("-....-", "-");    translator.put("-.--.", "(");
        translator.put("-...-", "=");
        // translator.put("-..-", "*");
        translator.put(".-.-.-", ".");    translator.put("-.-.-.", ";");
        translator.put("-..-.", "/");     translator.put(".----.", "'");
        translator.put("..--.-", "_");   translator.put("-.--.-", ")");
        translator.put(".-.-", "+");     translator.put(".--.-.", "@");

        return Arrays.stream(morseCode.strip().split("   "))
                .map(s -> Arrays.stream(s.split(" "))
                    .filter(str -> str == null || str.isBlank())
                    .map(translator::get)
                    .collect(Collectors.joining()))
                .collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {

    }
}
