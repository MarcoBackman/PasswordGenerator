package ui.menu;

import calculation.CharSet;
import ui.menu.items.FileMenuItem;
import util.WarningMessage;

import javax.swing.*;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileMenu extends JMenu implements ActionListener, MenuKeyListener {

    private final FileMenuItem logMenuItem;
    private final FileMenuItem exitMenuItem;
    private final JFrame parentFrame;


    private void addFileItems() {
        add(logMenuItem);
        add(exitMenuItem);
    }

    public FileMenu(JFrame parentFrame) {
        super("file");
        this.parentFrame = parentFrame;
        setOpaque(true);
        setBackground(CharSet.LIGHT_GRAY);

        logMenuItem = new FileMenuItem("log", this, this);
        exitMenuItem = new FileMenuItem("exit", this, this);

        addFileItems();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (obj.equals(this.getItem(0))) { //log
            WarningMessage warning = new WarningMessage();
            warning.notReady(parentFrame);
        } else if (obj.equals(this.getItem(1))) { //exit
            System.exit(0);
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
