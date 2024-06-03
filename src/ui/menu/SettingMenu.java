package ui.menu;


import calculation.CharSet;
import ui.menu.items.SettingMenuItem;
import util.WarningMessage;

import javax.swing.*;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingMenu extends JMenu implements ActionListener, MenuKeyListener {

    private final JFrame parentFrame;

    public SettingMenu(JFrame parentFrame) {
        super("setting");
        this.parentFrame = parentFrame;
        setOpaque(true);
        setBackground(CharSet.LIGHT_GRAY);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (obj.equals(this.getItem(0))) { //setting
            WarningMessage warning = new WarningMessage();
            warning.notReady(parentFrame);
        }
    }

    @Override
    public void menuKeyTyped(MenuKeyEvent e) {

    }

    @Override
    public void menuKeyPressed(MenuKeyEvent e) {

    }

    @Override
    public void menuKeyReleased(MenuKeyEvent e) {

    }
}
