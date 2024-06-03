package ui.menu.items;

import javax.swing.*;
import javax.swing.event.MenuKeyListener;
import java.awt.event.ActionListener;

public class SettingMenuItem  extends JMenuItem implements MenuItem {
    SettingMenuItem(String itemName,
                 ActionListener actionListener,
                 MenuKeyListener menuKeyListener) {
        super(itemName);
        this.addActionListener(actionListener);
        this.addMenuKeyListener(menuKeyListener);
    }
}
