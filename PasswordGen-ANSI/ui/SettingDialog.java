package PassGen.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Point;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import PassGen.calculation.CharSet;

/*
 * Author                             : MarcoBackman
 * Email                              : roni2006@hanmail.net
 * Last modification date             : 1-3-2021
 * Java Version                       : 1.6.0_26
 * Program Version                    : 0.0.1.1 / encoding: ANSI
 * Description                        : Setting dialog for password generator
 * Impact area - class is called from : PassGen.ui.SettingDialog;
 *             ---------- class calls :
 *
 */

class SettingDialog extends JDialog implements ActionListener {
	final int WIDTH = 250;
	final int HEIGHT = 250;
	final int MINIMUM_LEN = 6;
	final int MAXIMUM_LEN = 20;

	boolean[] check = new boolean[5];

	JFrame parent;

	//Components
	JButton confirmButton = new JButton("Confirm");
	JButton cancelButton = new JButton("Cancel");

	JPanel mainPanel;
	JPanel upperPanel, lowerPanel;

	JCheckBox numberCheckBox,
		      lowerCheckBox,
			  higherCheckBox,
			  specialCheckBox,
			  spaceCheckBox;

	JComboBox maxKeyLen;

	WarningDialog waning = new WarningDialog();

	//JTextField keyLenTextField;

	SettingDialog(JFrame frame) {
		super((Frame)frame, "¼³Á¤", Dialog.ModalityType.DOCUMENT_MODAL);
		setIconImage(CharSet.mainIcon.getImage());
		dialogSetup(frame);
		parent = frame;

		//set components first
		setComponent();
		setComboBoxGen();
		setCheckBox();

		//add panel
		addPanels();

		activateListener();

		//finalize
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
		JLabel lenLabel = new JLabel("Password length:");
		JLabel requiredKey;

		//main panel setting
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(2, 0));

		//lower first row
		JPanel firstRow = new JPanel();
		firstRow.add(lenLabel);
		firstRow.add(maxKeyLen);

		//lower right third row
		JPanel corner = new JPanel();
		corner.add(confirmButton);
		corner.add(cancelButton);

		//lower third row
		JPanel thirdRow = new JPanel();
		thirdRow.setLayout(new GridLayout(0, 2));
		thirdRow.add(new JPanel());
		thirdRow.add(corner);

		//upper first row
		JPanel upFirstRow = new JPanel();
		upFirstRow.add(new JLabel("Number"));
		upFirstRow.add(new JLabel("Under"));
		upFirstRow.add(new JLabel("Upper"));
		upFirstRow.add(new JLabel("Speci"));
		upFirstRow.add(new JLabel("Space"));

		//upper second row
		JPanel upSecondRow = new JPanel();
		upSecondRow.add(numberCheckBox);
		upSecondRow.add(lowerCheckBox);
		upSecondRow.add(higherCheckBox);
		upSecondRow.add(specialCheckBox);
		upSecondRow.add(spaceCheckBox);

		//upper panel setting
		upperPanel = new JPanel();
		upperPanel.setLayout(new GridLayout(2, 0));
		upperPanel.add(upFirstRow);
		upperPanel.add(upSecondRow);


		//lowerpanel setting
		lowerPanel = new JPanel();
		lowerPanel.setLayout(new GridLayout(3, 0));
		lowerPanel.add(firstRow);
		lowerPanel.add(new JPanel());//empty
		lowerPanel.add(thirdRow);



		//adding upper panel's compnent
		mainPanel.add(upperPanel);

		//adding lower panel's property
		mainPanel.add(lowerPanel);
		mainPanel.setFocusable(true);
	}

	private void setComboBoxGen() {
		for (int i = MINIMUM_LEN - 1; i < MAXIMUM_LEN; i++) {
			maxKeyLen.addItem((Object)(i + 1));
		}
	}

	private void setCheckBox() {
		numberCheckBox = new JCheckBox(null, null, true);
		numberCheckBox.setBorderPaintedFlat(true);
		lowerCheckBox = new JCheckBox();
		higherCheckBox = new JCheckBox();
		specialCheckBox = new JCheckBox();
		spaceCheckBox  = new JCheckBox();
	}

	private void setComponent() {
		confirmButton.setFont(new Font("", Font.PLAIN, 8));
		confirmButton.setPreferredSize(new Dimension(50, 30));
		confirmButton.setBackground(CharSet.BUTTON_BACKGROUND);

		cancelButton.setFont(new Font("", Font.PLAIN, 8));
		cancelButton.setPreferredSize(new Dimension(50, 30));
		cancelButton.setBackground(CharSet.RED_BACKGROUND);

		maxKeyLen = new JComboBox();
	}

	public void activateListener() {
		numberCheckBox.addActionListener(this);
		lowerCheckBox.addActionListener(this);
		higherCheckBox.addActionListener(this);
		specialCheckBox.addActionListener(this);
		spaceCheckBox.addActionListener(this);
		confirmButton.addActionListener(this);
		cancelButton.addActionListener(this);
	}

	public boolean confirmCheckBoxes() {
		if (!numberCheckBox.isSelected() &&
			!lowerCheckBox.isSelected() &&
			!higherCheckBox.isSelected() &&
			!specialCheckBox.isSelected() &&
			!spaceCheckBox.isSelected()) {
				waning.noCheckBoxWarning(parent);
			return false;
		} else if (spaceCheckBox.isSelected()) { //only spaces are not allowed
			if (!numberCheckBox.isSelected() &&
				!lowerCheckBox.isSelected() &&
				!higherCheckBox.isSelected() &&
				!specialCheckBox.isSelected()) {
					waning.spaceCheckBoxWarning(parent);
				return false;
			}
		}
		return true;
	}

	private void setCheck() {
		CharSet.allowNumber = numberCheckBox.isSelected();
		CharSet.allowLower = lowerCheckBox.isSelected();
		CharSet.allowUpper = higherCheckBox.isSelected();
		CharSet.allowSpecial = specialCheckBox.isSelected();
		CharSet.allowSpace = spaceCheckBox.isSelected();

		CharSet.keyLength = (int)maxKeyLen.getSelectedItem();
	}

	@Override
	public void actionPerformed (ActionEvent e) {
		Object obj = e.getSource();
		//buttons
		if (obj.equals(confirmButton)) {
			setCheck();
			processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		} else if (obj.equals(cancelButton)) {
			//goes with previous setting
			processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		} else if (!obj.equals(numberCheckBox)) {
			if (!confirmCheckBoxes()) {
				numberCheckBox.setSelected(true);
			}
		} else if (!obj.equals(lowerCheckBox)) {
			if (!confirmCheckBoxes()) {
				lowerCheckBox.setSelected(true);
			}
		} else if (!obj.equals(higherCheckBox)) {
			if (!confirmCheckBoxes()) {
				higherCheckBox.setSelected(true);
			}
		} else if (!obj.equals(spaceCheckBox)) {
			if (!confirmCheckBoxes()) {
				spaceCheckBox.setSelected(true);
			}
		} else if (!obj.equals(specialCheckBox)) {
			if (!confirmCheckBoxes()) {
				specialCheckBox.setSelected(true);
			}
		}
	}
}