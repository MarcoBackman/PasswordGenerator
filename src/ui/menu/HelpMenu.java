package ui.menu;

import calculation.CharSet;
import ui.dialog.VersionDialog;
import ui.menu.items.HelpMenuItem;

import javax.swing.*;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpMenu extends JMenu implements ActionListener, MenuKeyListener {

    private final HelpMenuItem aboutMenuItem;
    private final HelpMenuItem versionMenuItem;
    private final JFrame parentFrame;

    private void addFileItems() {
        add(aboutMenuItem);
        add(versionMenuItem);
    }

    public HelpMenu(JFrame parentFrame) {
        super("help");
        this.parentFrame = parentFrame;
        setOpaque(true);
        setBackground(CharSet.LIGHT_GRAY);

        aboutMenuItem = new HelpMenuItem("about", this, this);
        versionMenuItem = new HelpMenuItem("version", this, this);

        addFileItems();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (obj.equals(this.getItem(0))) { //about
            //new VersionDialog(this); causes error - why?
            new VersionDialog(parentFrame);
        } else if (obj.equals(this.getItem(1))) { //version
            new VersionDialog(parentFrame);
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
