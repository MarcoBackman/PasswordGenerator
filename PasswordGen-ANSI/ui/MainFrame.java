package PassGen.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;
import javax.swing.SwingConstants;

import PassGen.calculation.CharSet;

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

public class MainFrame extends JFrame implements ActionListener, MenuKeyListener {

	//final variables
    private static final long serialVersionUID = 0L; //need this for ObjectOutputStream
    final int WIDTH = 400;
    final int HEIGHT = 300;
	//window's screen middle location
	public static int SCREEN_X_MIDDLE;
	public static int SCREEN_Y_MIDDLE;

	//boolean identifier
    boolean authorized;

	//Menu bar and Menu
    JMenuBar menuBar = new JMenuBar();
    JMenu firstMenu, secondMenu, thirdMenu, fourthMenu; //names must be renamed

	JPanel mainPanel;

	VersionDialog version;

    public MainFrame () {
        super("Password generator");
		mainPanel = new MainPanel(this);
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
        MenuBarSetting();
        addMainPanel();
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
    private void MenuBarSetting () {
        setJMenuBar(menuBar);
		menuBar.setBorderPainted(true);
		menuBar.setBackground(CharSet.LIGHT_GRAY);
		menuBar.setOpaque(true);

		Insets insets = new Insets(10, 5, 10, 5);
		menuBar.setMargin(insets);

        firstMenu = new JMenu("File");
		firstMenu.setOpaque(true);
		firstMenu.setBackground(CharSet.LIGHT_GRAY);
        setFileMenu();
        menuBar.add(firstMenu);

        secondMenu = new JMenu("Setting");
		secondMenu.setBackground(CharSet.LIGHT_GRAY);
		secondMenu.setOpaque(true);
        setSetupMenu();
        menuBar.add(secondMenu);

        thirdMenu = new JMenu("Help");
		thirdMenu.setBackground(CharSet.LIGHT_GRAY);
		thirdMenu.setOpaque(true);
        setHelpMenu();
        menuBar.add(thirdMenu);
    }

    private void setFileMenu () {
		JMenuItem open = new JMenuItem("Log");
        open.addActionListener(this);
        open.addMenuKeyListener(this);
        firstMenu.add(open);

        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(this);
        exit.addMenuKeyListener(this);
        firstMenu.add(exit);
    }

    private void setSetupMenu () {
        JMenuItem addNew = new JMenuItem("Setting");
        addNew.addActionListener(this);
        addNew.addMenuKeyListener(this);
        secondMenu.add(addNew);
    }

    private void setHelpMenu () {
        JMenuItem help = new JMenuItem("Help");
        help.addActionListener(this);
        help.addMenuKeyListener(this);
        thirdMenu.add(help);

        JMenuItem version = new JMenuItem("Program version");
        version.addActionListener(this);
        version.addMenuKeyListener(this);
        thirdMenu.add(version);
    }



	/*
	 ********************************************************************
	 *          Adding all panels to the frame (Center section)         *
	 ********************************************************************
	 */

    private void addMainPanel () {
		this.add(mainPanel);
    }

	/*
	 *******************************
	 *         Listeners           *
	 *******************************
	 */
    @Override
    public void menuKeyTyped(MenuKeyEvent e) {

    }

    @Override
    public void menuKeyPressed(MenuKeyEvent e) {

    }

    @Override
    public void menuKeyReleased(MenuKeyEvent e) {

    }

    @Override
    public void actionPerformed (ActionEvent e) {
        Object obj = e.getSource();

		//menu bar
		if (obj.equals(firstMenu.getItem(0))) { //open
			WarningDialog warning = new WarningDialog();
			warning.notReady(this);
        } else if (obj.equals(firstMenu.getItem(1))) { //exit
			System.exit(0);
		} else if (obj.equals(secondMenu.getItem(0))) { //setting
			WarningDialog warning = new WarningDialog();
			warning.notReady(this);
		} else if (obj.equals(thirdMenu.getItem(0))) { //help
			//new VersionDialog(this); causes error - why?
			version = new VersionDialog(this);
		} else if (obj.equals(thirdMenu.getItem(1))) { //version
			version = new VersionDialog(this);
		}
    }


}