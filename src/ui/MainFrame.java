package ui;

import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;

import calculation.CharSet;
import ui.dialog.VersionDialog;
import ui.menu.FileMenu;
import ui.menu.HelpMenu;
import ui.menu.SettingMenu;
import util.WarningMessage;

/*
 * Author                             : MarcoBackman
 * Email                              : roni2006@hanmail.net
 * Last modification date             : 1-3-2021
 * Java Version                       : 1.6.0_26
 * Program Version                    : 0.0.1.1 / encoding: ANSI
 * Description                        : Main frame for Password Generator
 *											A main frame of the UI must contain clean
 *                                      	view with user friendly interactions.
 *                                      	Check for any flaws; updates or improvements is appreciated
 * Impact area - class is called from : PassGen.Run;
 *             ---------- class calls : PassGen.ui.MainPanel
 */

public class MainFrame extends JFrame {

	//final variables
    final int WIDTH = 500;
    final int HEIGHT = 300;
	//window's screen middle location
	public static int SCREEN_X_MIDDLE;
	public static int SCREEN_Y_MIDDLE;

    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu, settingMenu, helpMenu;

	JPanel mainPanel;

	VersionDialog version;

    public MainFrame () {
        super("Password generator");
		mainPanel = new MainPanel(this);
        fileMenu = new FileMenu(this);
        settingMenu = new SettingMenu(this);
        helpMenu = new HelpMenu(this);
		frameSetting();
    }

	/*
	 *********************************
	 *          Frame setup          *
	 *********************************
	 */
	private void frameSetting() {
		//image setup
		setIconImage(CharSet.mainIcon.getImage());
		setBackground(CharSet.BLACK);

        setResizable(false);
        setSize(WIDTH, HEIGHT);

        setFocusable(true);
        requestFocusInWindow();

		getScreenLocation(this, WIDTH, HEIGHT);
		setLocation(SCREEN_X_MIDDLE, SCREEN_Y_MIDDLE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        menuBarSetting();
        this.add(mainPanel);

        setVisible(true);
    }

	public static void getScreenLocation(JFrame frame, int WIDTH, int HEIGHT) {
		//window's width and height
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Window window = new Window(frame);
		Point centerPoint = ge.getCenterPoint();

		SCREEN_X_MIDDLE = centerPoint.x - WIDTH / 2;
		SCREEN_Y_MIDDLE = centerPoint.y - HEIGHT / 2;
	}
	/*
	 ****************************************
	 *          Top Menu bar settup         *
	 ****************************************
	 */
    private void menuBarSetting() {
        setJMenuBar(menuBar);
		menuBar.setBorderPainted(true);
		menuBar.setBackground(CharSet.LIGHT_GRAY);
		menuBar.setOpaque(true);

		Insets insets = new Insets(10, 5, 10, 5);
		menuBar.setMargin(insets);

        menuBar.add(fileMenu);
        menuBar.add(settingMenu);
        menuBar.add(helpMenu);
    }
}