package converter.window;

import converter.Converter;
import converter.utility.RomanUtil;
import converter.utility.WindowTools;

import javax.swing.*;
import java.awt.*;

public class ConverterWindow extends JFrame {
    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_HEIGHT = 300;
    private final JTextField txtInputField;
    private final JTextField txtResultField;

    public ConverterWindow() {
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setLocationRelativeTo(null);

        JPanel panMain = new JPanel(new GridLayout(2, 1));
        JPanel panInput = new JPanel(new FlowLayout());

        txtInputField = new JHintTextField("Number to convert");
        Icon submitArrowImageIcon = WindowTools.scaleImageIcon(
                new ImageIcon("assets/icons/submit_arrow.png"), 20, 20);
        JButton btnConvert = new JButton(submitArrowImageIcon);
        txtResultField = new JHintTextField("Result appears here");
        txtResultField.setEditable(false);

        btnConvert.addActionListener(e -> {
            String textFieldContents = txtInputField.getText();
            if (Converter.validNumerals(textFieldContents)) {
                txtResultField.setText(String.valueOf(Converter.romanToInteger(textFieldContents)));
            } else if (RomanUtil.isNumeric(textFieldContents))
                txtResultField.setText(Converter.integerToRoman(Integer.parseInt(textFieldContents)));
        });

        panInput.add(txtInputField);
        panInput.add(btnConvert);

        panMain.add(panInput);
        panMain.add(txtResultField);

        add(panMain);
        getRootPane().setDefaultButton(btnConvert);
    }
}
