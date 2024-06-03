package ui.menu.items;

import javax.swing.*;
import javax.swing.event.MenuKeyListener;
import java.awt.event.ActionListener;

public class HelpMenuItem extends JMenuItem implements MenuItem {
    public HelpMenuItem(String itemName,
                        ActionListener actionListener,
                        MenuKeyListener menuKeyListener) {
        super(itemName);
        this.addActionListener(actionListener);
        this.addMenuKeyListener(menuKeyListener);
    }
}
