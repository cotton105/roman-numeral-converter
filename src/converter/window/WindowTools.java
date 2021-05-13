package converter.window;

import javax.swing.*;
import java.awt.*;

public class WindowTools {
    public static ImageIcon scaleImageIcon(ImageIcon icon, double scaleAmount) {
        Image img = icon.getImage();
        int newWidth = (int)(img.getWidth(null) * scaleAmount);
        int newHeight = (int)(img.getHeight(null) * scaleAmount);
        Image scaledImg = img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImg);
    }

    public static ImageIcon scaleImageIcon(ImageIcon icon, int newWidth, int newHeight) {
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImg);
    }
}
