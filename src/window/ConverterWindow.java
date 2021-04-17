package window;

import javax.swing.*;
import java.awt.*;

public class ConverterWindow extends JFrame {
    JButton btnConvert;
    JTextField txtInputField;

    public ConverterWindow() {
        JPanel panInputs = new JPanel(new GridLayout(3, 1));

        JLabel labInput = new JLabel("Input numeral to convert (either Roman or Arabic)");
        txtInputField = new JTextField();
        btnConvert = new JButton("Convert");

        panInputs.add(labInput);
        panInputs.add(txtInputField);
        panInputs.add(btnConvert);

        btnConvert.addActionListener(new ButtonListener(ButtonListener.CONVERT));

    }

}
