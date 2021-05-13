package converter.utility;

public class RomanUtil {
    public static int indexOf(int[] searchArray, int searchItem) {
        for (int i=0; i<searchArray.length; i++) {
            if (searchItem == searchArray[i]) return i;
        }
        return -1;
    }

    public static int indexOf(char[] searchArray, char searchItem) {
        for (int i=0; i<searchArray.length; i++) {
            if (searchItem == searchArray[i]) return i;
        }
        return -1;
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
