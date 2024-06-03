package ui.menu.items;

import javax.swing.*;
import javax.swing.event.MenuKeyListener;
import java.awt.event.ActionListener;

public class FileMenuItem extends JMenuItem implements MenuItem {
    public FileMenuItem(String itemName,
                        ActionListener actionListener,
                        MenuKeyListener menuKeyListener) {
        super(itemName);
        this.addActionListener(actionListener);
        this.addMenuKeyListener(menuKeyListener);
    }
}
