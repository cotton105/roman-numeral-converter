import utility.RomanUtil;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Converter {
    private static final int[] numeralValues = new int[] {1000, 500, 100, 50, 10, 5, 1};
    private static final char[] numeralChars = new char[] {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
    JFrame frame;


    public Converter() {
        frame = new window.ConverterWindow();
    }

    public int romanToArabic(String numerals) {
        int total = 0;
        for (int i=numerals.length()-1; i>=0; i--) {
            int c = numeralMapping(numerals.charAt(i));
            int prevC = 0;
            if (i > 0) prevC = numeralMapping(numerals.charAt(i-1));
            if (prevC >= c || prevC == 0)
                total += c;
            else {
                if (i-2 >= 0) {
                    int prevPrevC = numeralMapping(numerals.charAt(i-2));
                    if (prevPrevC < c) {
                        total += c-prevC-prevPrevC;
                        i--;
                    } else total += c-prevC;
                } else
                    total += c-prevC;
                i--;
            }
        }
        return total;
    }

    private int numeralMapping(char numeral) {
        return numeralValues[RomanUtil.indexOf(numeralChars, numeral)];
    }

    private char numeralMapping(int number) {
        return numeralChars[RomanUtil.indexOf(numeralValues, number)];
    }

    //TODO: Improve conversion of digits with 4/9.
    public String arabicToRoman(int number) {
        StringBuilder numeralBuilder = new StringBuilder();
        int[] numberDigits = splitIntIntoDigits(number);
        for (int i=numberDigits.length-1; i>0; i--)
            numberDigits[numberDigits.length-1-i] *= Math.pow(10, i);
        for (int i=numberDigits.length-1; i>=0; i--) {
            int digit = numberDigits[i];
            if (digit == 4) numeralBuilder.insert(0, "IV");
            else if (digit == 9) numeralBuilder.insert(0, "IX");
            else if (digit == 40) numeralBuilder.insert(0, "XL");
            else if (digit == 90) numeralBuilder.insert(0, "XC");
            else if (digit == 400) numeralBuilder.insert(0, "CD");
            else if (digit == 900) numeralBuilder.insert(0, "CM");
            else {
                StringBuilder chunk = new StringBuilder();
                while (digit > 0) {
                    int largestNumeralFactor = largestNumeralFactor(digit);
                    chunk.append(numeralMapping(largestNumeralFactor));
                    digit -= largestNumeralFactor;
                }
                numeralBuilder.insert(0, chunk);
            }
        }

        return numeralBuilder.toString();
    }

    private int[] splitIntIntoDigits(int number) {
        int numberDigitCount = String.valueOf(number).length();
        int[] digits = new int[numberDigitCount];
        for (int i=digits.length-1; i>=0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }

    private int largestNumeralFactor(int number) {
        for (int numeralValue : numeralValues) {
            if (number / numeralValue > 0)
                return numeralValue;
        }
        return 0;
    }

    private int largestUnitFactor(int number) {
        if (number/1000 >= 1) return 1000;
        if (number/100 >= 1) return 100;
        if (number/10 >= 1) return 10;
        return 1;
    }

    public boolean validNumerals(String numerals) {
        String numeralRegex = "^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";  // regex courtesy of user paxdiablo (stackoverflow)
        Pattern pattern = Pattern.compile(numeralRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(numerals);
        return matcher.find();
    }

    public static void main(String[] args) {
        new Converter();
    }
}
