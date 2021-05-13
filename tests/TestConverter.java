import org.junit.jupiter.api.Test;
import converter.Converter;

import static org.junit.jupiter.api.Assertions.*;

public class TestConverter {
//    private final Converter converter = new Converter();
    private final int[] conversionTestSetArabic = new int[] {
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
    void testAccurateRomanToArabicConversion() {
        for (int i=0; i<conversionTestSetRoman.length; i++)
            assertEquals(conversionTestSetArabic[i], Converter.romanToArabic(conversionTestSetRoman[i]));
    }

    @Test
    void testAccurateArabicToRomanConversion() {
        for (int i=0; i<conversionTestSetArabic.length; i++)
            assertEquals(conversionTestSetRoman[i], Converter.arabicToRoman(conversionTestSetArabic[i]));
    }

    @Test
    void testValidRomanNumerals() {
        for (int i=0; i<conversionTestSetRoman.length; i+=2)
            assertTrue(Converter.validNumerals(conversionTestSetRoman[i]));
        for (String numerals : invalidNumeralsTestSet)
            assertFalse(Converter.validNumerals(numerals));
    }
}
