package converter.utility;

public class RomanUtil {

    private RomanUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean isNumeric(String val) {
        try {
            Integer.parseInt(val);
            return true;
        } catch ( NumberFormatException ex ) {
            return false;
        }
    }
}
