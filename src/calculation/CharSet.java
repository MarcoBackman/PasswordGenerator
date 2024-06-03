package calculation;

import java.awt.Color;

import javax.swing.ImageIcon;

/*
 * Author                             : MarcoBackman
 * Email                              : roni2006@hanmail.net
 * Last modification date             : 1-3-2021
 * Java Version                       : 1.6.0_26
 * Program Version                    : 0.0.1.1 / encoding: ANSI
 * Description                        : Icon sets with other static variables
 *                                         that other classes need to access simultaniously.
 *                                      Also contains graphic constants.
 *										Also contains methods that sets ASCII characters into arrays
 * Impact area - class is called from : --static-- can be called from everywhere
 *             ---------- class calls :
 *
 */

public class CharSet {

	public static final String FRAME_IMAGE = "../../../img/NAVYLOGO_02.png"; //do not use absolute directory location.
	public static final String LABEL_LOGO = "../../../img/LabelLogo_mini.png"; //do not use absolute directory location.

	//IMAGE ICONS
	public static ImageIcon mainIcon = new ImageIcon(CharSet.FRAME_IMAGE);
	public static ImageIcon labelIcon = new ImageIcon(CharSet.LABEL_LOGO);

	//Black color series - goes brigher in descent
	public static final Color BLACK = Color.BLACK;
	public static final Color DARK_GRAY = Color.DARK_GRAY;
	public static final Color GRAY = new Color(100, 100, 100);
	public static final Color LIGHT_GRAY = new Color(160, 160, 160);
	public static final Color LIGHTER_GRAY = new Color(215, 215, 215);
	public static final Color WHITE = Color.WHITE;

	public static final Color FRAME_BACKGROUND = new Color(135, 175, 221);
	public static final Color FILE_TAB_BACKGROUND = new Color(209, 222, 240);
	public static final Color CANCEL_BACKGROUND = new Color(231, 138, 138);
	public static final Color CENTER_FRAME_BACKGROUND = new Color(217, 217, 217);
	public static final Color BUTTON_BACKGROUND = new Color(197, 214, 237);
	public static final Color BUTTON_PRESSED = new Color(16, 127, 181);
	public static final Color STANDER_BACKGROUND = new Color(140, 176, 219);
	public static final Color RED_BACKGROUND = Color.RED;
	public static final Color ORANGE = new Color(245, 172, 37);

	public static int keyLength = 6;

	public static boolean allowNumber = true;
	public static boolean allowLower = false;
	public static boolean allowUpper = false;
	public static boolean allowSpecial = false;
	public static boolean allowSpace = false;
	public static boolean allowHotKey = false;

	public static String generatedKey = "";

	//returns numbers in character
	public static char[] getNumber() {
		char[] temp = new char[10];
		int j = 0;
		for (int i = 48; i <= 57; i++) {
			temp[j] = (char)i;
			j++;
		}
		return temp;
	}

	//returns lower case alphabet letters
	public static char[] getLowAlpha() {
		char[] temp = new char[26];
		int j = 0;
		for (int i = 97; i <= 122; i++) {
			temp[j] = (char)i;
			j++;
		}
		return temp;
	}

	//returns upper case alphabet letters
	public static char[] getUpAlpha() {
		char[] temp = new char[26];
		int j = 0;
		for (int i = 65; i <= 90; i++) {
			temp[j] = (char)i;
			j++;
		}
		return temp;
	}

	//returns special characters
	public static char[] getSpecialChar() {
		char[] temp = new char[38];
		int j = 0;
		for (int i = 33; i <= 47; i++) {
			temp[j] = (char)i;
			j++;
		}
		for (int i = 58; i <= 64; i++) {
			temp[j] = (char)i;
			j++;
		}
		for (int i = 91; i <= 96; i++) {
			temp[j] = (char)i;
			j++;
		}
		for (int i = 123; i <= 126; i++) {
			temp[j] = (char)i;
			j++;
		}
		return temp;
	}

	//returns space character
	public static char getSpace() {
		return ' ';
	}

	//returns hotkey characters
	public static char[] getHotkey() {
		char[] temp = new char[33];
		int j = 0;
		for (int i = 0; i <= 31; i++) {
			temp[j] = (char)i;
			j++;
		}
		temp[j] = (char)127;
		return temp;
	}
}