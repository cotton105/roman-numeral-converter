import javax.swing.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Converter {
    private static Map<Character, Integer> numeralMapping = new HashMap<>();
    JFrame frame;
    // Specify values of Roman numerals in a map
    static {
        numeralMapping.put('I', 1);
        numeralMapping.put('V', 5);
        numeralMapping.put('X', 10);
        numeralMapping.put('L', 50);
        numeralMapping.put('C', 100);
        numeralMapping.put('D', 500);
        numeralMapping.put('M', 1000);
        numeralMapping = Collections.unmodifiableMap(numeralMapping);
    }


    public Converter() {
        frame = new window.ConverterWindow();
    }

    public int romanToArabic(String numerals) {
        int total = 0;
        int chunk = 0;
        for ( int i=1; i<numerals.length()-1; i++ ) {
            int c = numeralMapping.get(numerals.charAt(i-1));
            int nextC = numeralMapping.get(numerals.charAt(i));

        }

        return total;

    }

    public String arabicToRoman(int number) {
        return null;
    }

    public boolean validNumerals(String numerals) {
        String numeralRegex = "^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";  // regex courtesy of user paxdiablo (stackoverflow)
        Pattern pattern = Pattern.compile(numeralRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(numerals);
        return matcher.find();
    }

    private boolean isNumeric(String val) {
        try {
            Integer.parseInt(val);
            return true;
        } catch ( NumberFormatException ex ) {
            return false;
        }
    }

    public static void main(String[] args) {
        new Converter();
    }

}
