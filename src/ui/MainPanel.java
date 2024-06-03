package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import calculation.CharSet;
import ui.dialog.SettingDialog;
import util.WarningMessage;

/*
 * Author                             : MarcoBackman
 * Email                              : roni2006@hanmail.net
 * Last modification date             : 1-3-2021
 * Java Version                       : 1.6.0_26
 * Program Version                    : 0.0.1.1 / encoding: ANSI
 * Description                        : A main panel for Password Generator Frame
 * Impact area - class is called from : classfile.ui.MainFrame;
 *             ---------- class calls :
 *
 */

class MainPanel extends JPanel implements MouseListener, ActionListener {

	final private Font TEXT_FONT = new Font("TimesRoman", Font.BOLD, 20);
	final private Font BUTTON_FONT = new Font("TimesRoman", Font.BOLD, 12);

	JFrame parent;
	JButton setButton, genButton;

	JTextField textField;

	SettingDialog settingScreen;

	protected MainPanel(JFrame frame) {
		this.parent = frame;
		this.setLayout(new GridLayout(4, 0, 0, 0));

		this.add(new JPanel() { //empty
			@Override
			public void setBackground(Color bg) {
				super.setBackground(CharSet.GRAY);
			}
		});
		this.add(textPanel()); //text field
		this.add(new JPanel() { //empty with gray color background
			@Override
			public void setBackground(Color bg) {
				super.setBackground(CharSet.GRAY);
			}
		});
		this.add(buttonPanel()); //empty with gray color background

		//set listener
		activateListener();
	}

	JPanel textPanel() {
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new GridBagLayout());
		textPanel.setBackground(CharSet.GRAY);

		//text field
		textField = new JTextField("Password Result");
		textField.setEditable(false);
		textField.setFont(TEXT_FONT);
		textField.setPreferredSize(new Dimension(350, 40));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBackground(CharSet.LIGHT_GRAY);
		textField.setForeground(CharSet.WHITE);

		//add component
		textPanel.add(textField, new GridBagConstraints());
		textPanel.setBackground(CharSet.GRAY);
		textPanel.setForeground(CharSet.WHITE);
		return textPanel;
	}

	JPanel buttonPanel() {
		JPanel lowerPanel = new JPanel();
		JPanel lowerCenterPanel = new JPanel();
		JPanel lowerRightPanel = new JPanel();

		//button setup
		setButton = new JButton("Setting");
		genButton = new JButton("Generate Password");
		setButton.setBackground(CharSet.LIGHTER_GRAY);
		setButton.setFocusable(false);
		setButton.setFont(BUTTON_FONT);
		setButton.setPreferredSize(new Dimension(100, 40));
		genButton.setBackground(CharSet.ORANGE);
		genButton.setFocusable(false);
		genButton.setFont(BUTTON_FONT);
		genButton.setPreferredSize(new Dimension(180, 40));

		//lowerCenterPanel setup
		lowerCenterPanel.setBackground(CharSet.GRAY);
		lowerCenterPanel.add(setButton);

		//lowerRightPanel setup
		lowerRightPanel.setBackground(CharSet.GRAY);
		lowerRightPanel.add(genButton);

		//lowerPanel setup
		lowerPanel.setLayout(new GridLayout(0, 3, 0, 0));
		lowerPanel.add(new JPanel() { //empty with gray color background
			@Override
			public void setBackground(Color bg) {
				super.setBackground(CharSet.GRAY);
			}
		});
		lowerPanel.add(lowerCenterPanel);
		lowerPanel.add(lowerRightPanel);

		return lowerPanel;
	}

	protected SettingDialog getSetting() {
		return settingScreen;
	}

	/*
	 *******************************************
	 *          Button Listenr setup           *
	 *******************************************
	 */
	public void activateListener() {
		setButton.addActionListener(this);
		genButton.addActionListener(this);
;
	}

    public void disactivateListener() {
		setButton.removeActionListener(this);
		genButton.removeActionListener(this);
	}

    @Override
    public void actionPerformed (ActionEvent e) {
        Object obj = e.getSource();
		//buttons
		if (obj.equals(setButton)) {
			//setting dialog
			if (settingScreen == null) {
				settingScreen = new SettingDialog(this.parent);
			} else {
				settingScreen.setVisible(true);
			}

		} else if (obj.equals(genButton)) {
			//run calculation
			WarningMessage check = new WarningMessage();
			check.settingChecked(this.parent);
			textField.setText(CharSet.generatedKey);
			validate();
		}

    }

    @Override
    public void mousePressed (MouseEvent e) {

    }

    @Override
    public void mouseReleased (MouseEvent e) {

    }

    @Override
    public void mouseEntered (MouseEvent e) {

    }

    @Override
    public void mouseExited (MouseEvent e) {

    }

    @Override
    public void mouseClicked (MouseEvent e) {

    }

}