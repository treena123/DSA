package performanceMeasurement;

public class StringUtils {

    public static long countCharWithStreams(String input, char ch) {
        return input.chars().filter(c -> c == ch).count();
    }

    public static long countCharWithLoop(String input, char ch) {
        long count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }
}
