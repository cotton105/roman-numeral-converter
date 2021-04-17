package window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    public static final int CONVERT = 0;
    private final int action;

    public ButtonListener(int action) {
        this.action = action;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch ( action ) {
            case CONVERT:

        }
    }
}
