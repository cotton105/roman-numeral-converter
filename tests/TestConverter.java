import org.junit.jupiter.api.Test;
import converter.Converter;

import static org.junit.jupiter.api.Assertions.*;

class TestConverter {
    private final int[] conversionTestSetInteger = new int[] {
            3, 3999, 2021, 1984,
            39, 246, 789, 2421,
            160, 207, 1009, 1066,
            1776, 1918, 1954, 2014};
    private final String[] conversionTestSetRoman = new String[] {
            "III", "MMMCMXCIX", "MMXXI", "MCMLXXXIV",
            "XXXIX", "CCXLVI", "DCCLXXXIX", "MMCDXXI",
            "CLX", "CCVII", "MIX", "MLXVI",
            "MDCCLXXVI", "MCMXVIII", "MCMLIV", "MMXIV"};
    private final String[] invalidNumeralsTestSet = new String[] {
            "IIII", "IXXMM",
            "XXIXIX", "DCCXLXXIX",
            "LCX", "IMX",
            "MDCCXLXVI", "MCLMIV",
            "TEST", "INVALID", "FAIL", "ROMAN"};

    @Test
    void testAccurateRomanToIntegerConversion() {
        for (int i=0; i<conversionTestSetRoman.length; i++)
            assertEquals(conversionTestSetInteger[i], Converter.romanToInteger(conversionTestSetRoman[i]));
    }

    @Test
    void testAccurateIntegerToRomanConversion() {
        for (int i = 0; i< conversionTestSetInteger.length; i++)
            assertEquals(conversionTestSetRoman[i], Converter.integerToRoman(conversionTestSetInteger[i]));
    }

    @Test
    void testValidRomanNumerals() {
        for (int i=0; i<conversionTestSetRoman.length; i+=2)
            assertTrue(Converter.validNumerals(conversionTestSetRoman[i]));
        for (String numerals : invalidNumeralsTestSet)
            assertFalse(Converter.validNumerals(numerals));
    }
}
