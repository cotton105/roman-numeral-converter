import javax.swing.*;
import java.util.Arrays;

public class Converter {
    JFrame frame;

    public Converter() {
        frame = new window.ConverterWindow();
    }

    public boolean validNumerals(String numerals) {
        // TODO: Improve validity check
        String[] romanCharSet = {"I", "V", "X", "L", "C", "D", "M"};
        String[] numeralsArray = numerals.split("");
        boolean valid = true;
        if ( !isNumeric(numerals) ) {
            for ( String c : numeralsArray ) {
                if ( Arrays.stream(romanCharSet).noneMatch(c::equals) ) {
                    valid = false;
                    break;
                }
            }
        }
        return valid;
    }

    private boolean isNumeric(String val) {
        try {
            Integer.parseInt(val);
            return true;
        } catch ( NumberFormatException ex ) {
            ex.printStackTrace();
            return false;
        }
    }


    public static void main(String[] args) {
        new Converter();
    }
}
