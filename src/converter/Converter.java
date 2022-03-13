package converter;

import converter.window.ConverterWindow;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Converter {
    private static final String[] NUMERAL_CHARS = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static final int[] NUMERAL_VALUES = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    JFrame frame;

    public Converter() {
        frame = new ConverterWindow();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static int romanToInteger(String numerals) {
        int total = 0;
        List<String> numeralList = Arrays.asList(NUMERAL_CHARS);
        while (!numerals.equals("")) {
            String firstChar = numerals.substring(0, 1);
            if (numerals.length() > 1) {
                String first2Chars = numerals.substring(0, 2);
                if (numeralList.contains(first2Chars)) {
                    total += NUMERAL_VALUES[numeralList.indexOf(first2Chars)];
                    numerals = numerals.substring(2);
                } else {
                    total += NUMERAL_VALUES[numeralList.indexOf(firstChar)];
                    numerals = numerals.substring(1);
                }
            } else {
                total += NUMERAL_VALUES[numeralList.indexOf(firstChar)];
                numerals = numerals.substring(1);
            }
        }
        return total;
    }

    public static String integerToRoman(int number) {
        StringBuilder intAsNumerals = new StringBuilder();
        while (number != 0) {
            for (int i = 0; i < NUMERAL_VALUES.length; i++) {
                int val = NUMERAL_VALUES[i];
                if (number - val >= 0) {
                    number -= val;
                    intAsNumerals.append(NUMERAL_CHARS[i]);
                    break;
                }
            }
        }
        return intAsNumerals.toString();
    }

    public static boolean validNumerals(String numerals) {
        String numeralRegex = "^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";  // regex courtesy of user paxdiablo (stackoverflow)
        Pattern pattern = Pattern.compile(numeralRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(numerals);
        return matcher.find();
    }

    public static void main(String[] args) {
        new Converter();
    }
}
