package calculation;

import java.lang.Math;

/*
 * Author                             : MarcoBackman
 * Email                              : roni2006@hanmail.net
 * Last modification date             : 1-4-2021
 * Java Version                       : 1.6.0_26
 * Program Version                    : 0.0.1.1 / encoding: UTF-8
 * Description                        : Password random key generator follows below rules.
 *										- Space is only created no more than once.
 *										- Replacement of each type of character will occur once to make sure
 *										     preffered type is included in the key -> see replaceChar().
 *									    - Hot key function is temporary disabled due to output problem
 *											 -> Hotkey such as 'delete' will print non-readable output on the screen
 *										- Might need improvement on random function.
 * Impact area - class is called from : PassGen.ui.MainPanel;
 *             ---------- class calls : PassGen.calculation.CharSet;
 *
 */

public class Generate {

	String resultKey = "";

	boolean[] select = new boolean[6];

	char[] numArr,
           lowAlphaArr,
	       upAlphaArr,
	       specialArr,
	       hotKeyArr;

	//default
	public Generate() {
		numArr = CharSet.getNumber();
		lowAlphaArr = CharSet.getLowAlpha();
		upAlphaArr = CharSet.getUpAlpha();
		specialArr = CharSet.getSpecialChar();
		hotKeyArr = CharSet.getHotkey();

		select[0] = CharSet.allowLower;
		select[1] = CharSet.allowUpper;
		select[2] = CharSet.allowSpecial;
		select[3] = CharSet.allowSpace;
		select[4] = CharSet.allowHotKey;
		select[5] = CharSet.allowNumber;
	}

	//used for debugging purposes
	public Generate(boolean allowLowerCase,
				    boolean allowUpperCase,
				    boolean allowSpecialChar,
				    boolean allowSpace,
				    boolean allowHotkey,
					boolean allowNumber) {
		numArr = CharSet.getNumber();
		lowAlphaArr = CharSet.getLowAlpha();
		upAlphaArr = CharSet.getUpAlpha();
		specialArr = CharSet.getSpecialChar();
		hotKeyArr = CharSet.getHotkey();

		select[0] = CharSet.allowLower = allowLowerCase;
		select[1] = CharSet.allowUpper = allowUpperCase;
		select[2] = CharSet.allowSpecial = allowSpecialChar;
		select[3] = CharSet.allowSpace = allowSpace;
		select[4] = CharSet.allowHotKey = allowHotkey;
		select[5] = CharSet.allowNumber = allowNumber;
	}

	//Call this method to make overall key string
	//length must be more than 6
	public String generate(int keySize) {
		//must modify -> selected char type must be included at least one
		for (int i = 0; i < keySize; i++) {
			resultKey += rotateRandom();
		}
		//returns string data that contains at least once of selected character type
		return replaceChar(resultKey);
	}

	//select character type randomly and return selected
	//!! warning this will fall in to the infinite loop when
	//	    all of the 'select' array's element is false
	private char rotateRandom() {
		int index = (int)(Math.random() * select.length);
		//will not enter into infinite loop unless everything is not true
		while (!select[index]) { // must make sure at least one on the element is true
			index = (int)(Math.random() * select.length);
		}

		if (index == 0) { //lowercase selected
			return getRandomLowAlpha();
		} else if (index == 1) { //uppercase selected
			return getRandomUpAlpha();
		} else if (index == 2) { //special selected
			return getRandomSpecialChar();
		} else if (index == 3) { //space selected
			select[3] = false; //will use only single space character
			return getSpace();
		} else { //number selected
			return getRandomNumber();
		}
	}

	private String replaceChar(String key) {

		int index = (int)(Math.random() * key.length());
		boolean[] check = new boolean[key.length()];

		if (CharSet.allowSpace) { //prevents skipping space replacement
		    select[3] = true;
		}
		
		//initialize
		for (int i = 0; i < key.length(); i++)
			check[i] = false;

		if (select[0]) { //lowercase
			while (check[index]) {
				index = (int)(Math.random() * key.length());
				check[index] = true;
				//swap
				key = swapLetter(key, index, getRandomLowAlpha());
			}
		}

		if (select[1]) { //uppercase
			while (check[index]) {
				index = (int)(Math.random() * key.length());
				check[index] = true;
				//swap
				key = swapLetter(key, index, getRandomUpAlpha());
			}
		}

		if (select[2]) { //spcial
			while (check[index]) {
				index = (int)(Math.random() * key.length());
				check[index] = true;
				//swap
				key = swapLetter(key, index, getRandomSpecialChar());
			}
		}

		if (select[3]) { //space
			while (check[index]) {
				index = (int)(Math.random() * key.length());
				check[index] = true;
				//swap
				key = swapLetter(key, index, getSpace());
			}
		}
		/*
		if (select[4]) { //hotkey
			while (check[index]) {
				index = (int)(Math.random() * key.length());
				check[index] = true;
				//swap
				key = swapLetter(key, index, getRandomHotKey());
			}
		}
		*/
		if (select[5]) { //number
			while (check[index]) {
				index = (int)(Math.random() * key.length());
				check[index] = true;
				//swap
				key = swapLetter(key, index, getRandomNumber());
			}
		}
		return key;
	}

	private String swapLetter(String str, int index, char letter) {
		String newString = "";
		newString += (str.substring(0, index) + letter +  str.substring(index + 1));
		return newString;
	}

	private char getRandomNumber() {
		int index = (int)((Math.random()) * numArr.length);
		return numArr[index];
	}

	private char getRandomLowAlpha() {
		int index = (int)((Math.random()) * lowAlphaArr.length);
		return lowAlphaArr[index];
	}

	private char getRandomUpAlpha() {
		int index = (int)((Math.random()) * upAlphaArr.length);
		return upAlphaArr[index];
	}

	private char getRandomSpecialChar() {
		int index = (int)((Math.random()) * specialArr.length);
		return specialArr[index];
	}

	private char getSpace() {
		return CharSet.getSpace();
	}

	private char getRandomHotKey() {
		int index = (int)((Math.random()) * hotKeyArr.length);
		return hotKeyArr[index];
	}

	public String getKeyResult() {
		return resultKey;
	}

}