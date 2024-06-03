package ui.dialog;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.MainFrame;

/*
 * Author                             : MarcoBackman
 * Email                              : roni2006@hanmail.net
 * Last modification date             : 1-3-2021
 * Java Version                       : 1.6.0_26
 * Program Version                    : 0.0.1.1 / encoding: ANSI
 * Description                        : Version dialog for password generator
 * Impact area - class is called from :
 *             ---------- class calls :
 *
 */

class HelpDialog extends JDialog {
	final int WIDTH = 230;
	final int HEIGHT = 220;

	//Components
	JLabel versionLabel,
		   releaseDateLabel,
		   authorLabel,
		   address;

	JPanel mainPanel;

	HelpDialog(JFrame frame) {
		super((Frame)frame, "Help", Dialog.ModalityType.DOCUMENT_MODAL);
		dialogSetup(frame);
		setLabel();
		addPanels();
		add(mainPanel);
		setVisible(true);
	}

	private void dialogSetup(JFrame frame) {
		setResizable(false);
		setSize(WIDTH, HEIGHT);
		setFocusable(true);
		requestFocusInWindow();

		//setUndecorated(true);
		setDefaultLookAndFeelDecorated(false);
		MainFrame.getScreenLocation(frame, WIDTH, HEIGHT);
		setLocation(MainFrame.SCREEN_X_MIDDLE, MainFrame.SCREEN_Y_MIDDLE);
	}

	private void addPanels() {
		//adding components to the main panel
		mainPanel = new JPanel();
		//mainPanel.setLayout();
		mainPanel.add(versionLabel);
		mainPanel.add(releaseDateLabel);
		mainPanel.add(authorLabel);
		mainPanel.add(address);
		mainPanel.setFocusable(true);
	}
	
	private void setLabel() {
		versionLabel = new JLabel("1. 'HotKey' produces output issues");
		releaseDateLabel = new JLabel("Last Modification: Jan 3rd, 2021");
		authorLabel = new JLabel("Author: MarcoBackman");
		address = new JLabel("Contact: roni2006@hanmail.net");
		versionLabel.setPreferredSize(new Dimension(210, 40));
		releaseDateLabel.setPreferredSize(new Dimension(210, 40));
		authorLabel.setPreferredSize(new Dimension(210, 40));
		address.setPreferredSize(new Dimension(210, 40));
	}
}