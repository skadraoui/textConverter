package com.hardis.fr.text.converter.traitement;

import com.hardis.fr.text.converter.exceptions.ReportException;
import com.hardis.fr.text.converter.models.entities.Reference;
import com.hardis.fr.text.converter.models.enums.Params;

public class LineParser {

	/**
	 * Séparateur de bloc d'une ligne du fichier à traiter
	 */
	private static final String SEPARATEUR_BLOC = ";";

	private LineParser() {

	}

	/**
	 * Récupére un objet de type Reference remplie avec les données d'une ligne
	 * du fichier en cours de traitement
	 * 
	 * @param ligneReference
	 *            ligne lue
	 * @return objet référence construit
	 * @throws ReportException
	 *             une exception si le format attendu des blocs de la référence
	 *             ne corresponds pas aux formats attendues
	 */
	public static Reference formaterLigneReference(String ligneReference) throws ReportException {
		String[] elts = ligneReference.split(SEPARATEUR_BLOC);
		if (elts.length != 4) {
			throw new ReportException(Params.INCORRECT_ARGUMENTS_NUMBER);
		}
		Reference result = new Reference();

		long reference;
		try {
			reference = Long.valueOf(elts[0]);
			if (elts[0].length() != 10) {
				throw new ReportException(Params.INCORRECT_NUM_REFERENCE);
			}
			result.setNumReference(String.valueOf(reference));
		} catch (NumberFormatException numberFormatException) {
			throw new ReportException(Params.INCORRECT_NUM_REFERENCE);
		}
		result.setNumReference(elts[0]);
		if (getColorByCode(elts[1].charAt(0)) != null) {
			result.setType(elts[1].charAt(0));
		} else {
			throw new ReportException(Params.INCORRECT_COLOR);
		}
		float price;
		try {
			price = Float.valueOf(elts[2]);
			result.setPrice(price);
		} catch (NumberFormatException numberFormatException) {
			throw new ReportException(Params.INCORRECT_PRICE);
		}
		long size;
		try {
			size = Long.valueOf(elts[3]);
			result.setSize(size);
		} catch (NumberFormatException numberFormatException) {
			throw new ReportException(Params.INCORRECT_SIZE);
		}

		return result;
	}

	/**
	 * récuperer un enum Color correspondant au type de la référence
	 * 
	 * @param colorCodecode
	 *            couleur récupéré
	 * @return la couleure correspondante
	 */
	public static Params.Colors getColorByCode(char colorCode) {
		for (Params.Colors color : Params.Colors.values()) {
			if (color.getColorCode() == colorCode) {
				return color;
			}
		}
		return null;
	}

}