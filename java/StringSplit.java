public class StringSplit {
    public static String[] solution(String s) {
        String[] twoChars = s.split("..");
        if(s.length() % 2 == 1) {
            int last = twoChars.length - 1;
            twoChars[last] += "_";
        }

        return twoChars;
    }

    public static void main(String[] args) {
        for (String s : solution("asdf")) {
            System.out.println(s);
        }
    }
}
