package com.hardis.fr.text.converter.parser;

import com.hardis.fr.text.converter.models.enums.Params;

/**
 * class contenant les méthodes permettant de valider le format des lignes dans
 * le fichier.
 * 
 * @author SFKI
 *
 */
public class ParserDonnees {

	private ParserDonnees() {

	}

	/**
	 * parser la référence pour vérifier si le contenu respecte bien le format
	 * attendu
	 * 
	 * @param reference
	 * @return true si la ligne référence est correcte, false sinon
	 */
	public static boolean parseReference(String reference) {
		StringBuilder stringBuilder = new StringBuilder("");
		stringBuilder.append(Params.Colors.BLUE.getColorCode()).append("|").append(Params.Colors.GREEN.getColorCode())
				.append("|").append(Params.Colors.RED.getColorCode());
		return reference.matches("(\\d+);(" + stringBuilder.toString() + ");([+-]?([0-9]*[.])?[0-9]+);(\\d+)");

	}

}