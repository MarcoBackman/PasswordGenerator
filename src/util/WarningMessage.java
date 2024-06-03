package util;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import calculation.CharSet;
import calculation.Generate;
import ui.MainFrame;

/*
 * Author                             : MarcoBackman
 * Email                              : roni2006@hanmail.net
 * Last modification date             : 1-4-2021
 * Java Version                       : 1.6.0_26
 * Program Version                    : 0.0.1.1 / encoding: ANSI
 * Description                        : A dialog function set to notify warning to the user 
 * Impact area - class is called from : PassGen.ui.MainFrame; PassGen.ui.MainPanel;
 *             ---------- class calls :
 *
 */

public class WarningMessage {

	public void settingChecked(JFrame frame) {
		CheckDialog warningFrame = new CheckDialog(frame, "   Have you checked the setting?   ");
	}

	public void unkownError(JFrame frame) {
		ErrorDialog warningFrame = new ErrorDialog(frame, "Unknown error");
	}

	public void notReady(JFrame frame) {
		ErrorDialog warningFrame = new ErrorDialog(frame, "  Unsupported feature.  ");
	}

	public void importError(JFrame frame) {
		ErrorDialog warningFrame = new ErrorDialog(frame, "File import error.");
	}

	public void exportError(JFrame frame) {
		ErrorDialog warningFrame = new ErrorDialog(frame, "File export error.");
	}

	public void spaceCheckBoxWarning(JFrame frame) {
		ErrorDialog warningFrame = new ErrorDialog(frame, "Space only password is disabled.");
	}

	public void noCheckBoxWarning(JFrame frame) {
		ErrorDialog warningFrame = new ErrorDialog(frame, "Select more than one types.");
	}

	private static class ErrorDialog extends JDialog implements ActionListener {
		final int WIDTH = 200;
		final int HEIGHT = 200;

		//Components
		JButton confirmButton = new JButton("Confirm");
		JLabel label;

		JPanel mainPanel;

		ErrorDialog(JFrame frame, String text) {
			super((Frame)frame, "Error", Dialog.ModalityType.DOCUMENT_MODAL);
			dialogSetup(frame);
			addPanels();
			setPopupText(text);
			activateListener();
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
			mainPanel.add(label = new JLabel(""));
			confirmButton.setFont(new Font("", Font.PLAIN, 8));
			confirmButton.setPreferredSize(new Dimension(80, 30));
			confirmButton.setBackground(CharSet.BUTTON_BACKGROUND);
			mainPanel.add(confirmButton);
			mainPanel.setFocusable(true);
		}

		public void setPopupText(String context) {
			label.setText(context);
			validate();
		}

		public void activateListener() {
			confirmButton.addActionListener(this);
		}

		@Override
		public void actionPerformed (ActionEvent e) {
			Object obj = e.getSource();
			//buttons
			if (obj.equals(confirmButton)) {
				//removing setFocusable will cause no child found error
				//setFocusable(false); //resumes focus to main frame instead of dialog frame
				processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
			}
		}
	}

	private static class CheckDialog extends JDialog implements ActionListener {
		final int WIDTH = 200;
		final int HEIGHT = 200;

		//Components
		JButton confirmButton = new JButton("Confirm");
		JButton cancelButton = new JButton("Cancel");
		JLabel label;

		JPanel mainPanel;

		CheckDialog(JFrame frame, String text) {
			super((Frame)frame, "Warning", Dialog.ModalityType.DOCUMENT_MODAL);
			dialogSetup(frame);
			addPanels();
			setPopupText(text);
			activateListener();
			add(mainPanel);
			setVisible(true);
		}

		private void dialogSetup(JFrame frame) {
			setResizable(false);
			setSize(WIDTH, HEIGHT);
			//setRootPane(JRootPane.PLAIN_DIALOG);
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
			mainPanel.add(label = new JLabel(""));

			//buttons
			confirmButton.setFont(new Font("", Font.PLAIN, 11));
			confirmButton.setPreferredSize(new Dimension(80, 30));
			confirmButton.setBackground(CharSet.RED_BACKGROUND);
			cancelButton.setFont(new Font("", Font.PLAIN, 11));
			cancelButton.setPreferredSize(new Dimension(80, 30));
			cancelButton.setBackground(CharSet.BUTTON_BACKGROUND);
			mainPanel.add(confirmButton);
			mainPanel.add(cancelButton);
			mainPanel.setFocusable(true);

		}

		public void setPopupText(String context) {
			label.setText(context);
			validate();
		}

		public void activateListener() {
			confirmButton.addActionListener(this);
			cancelButton.addActionListener(this);
		}

		@Override
		public void actionPerformed (ActionEvent e) {
			Object obj = e.getSource();
			//buttons
			if (obj.equals(confirmButton)) {
				//run generation
				Generate gen = new Generate();
				CharSet.generatedKey = gen.generate(CharSet.keyLength);
				processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
			} else if (obj.equals(cancelButton)) {
				processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
			}
		}
	}
}