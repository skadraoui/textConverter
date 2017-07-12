package com.hardis.fr.text.converter.models.enums;

public class Params {

	private Params() {
	}

	public static enum Colors {
		GREEN('G', "GREEN"), RED('R', "RED"), BLUE('B', "");

		private Colors(char colorCode, String ClolorName) {
			setColorCode(colorCode);
			setColorName(ClolorName);
		}

		private char colorCode;
		private String colorName;

		public char getColorCode() {
			return colorCode;
		}

		public String getColorName() {
			return colorName;
		}
		
		public void setColorCode(char colorCode) {
			this.colorCode = colorCode;
		}
		public void setColorName(String colorName) {
			this.colorName = colorName;
		}
	}

	/*
	 * Constantes
	 */
	public static final String ERREUR_LECTURE_FICHIER = "";
	public static final String INCORRECT_COLOR = "Incorrect value for color";
	public static final String INCORRECT_PRICE = "Incorrect value for price";
	public static final String INCORRECT_SIZE = "Incorrect value for size";
	public static final String INCORRECT_NUM_REFERENCE = "Incorrect value for num reference";
	public static final String INCORRECT_ARGUMENTS_NUMBER = "A reference must have exactly four values separated by ';'";

}
