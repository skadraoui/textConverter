package com.hardis.fr.text.converter.soa;

import java.io.File;

public interface TextParserSOA {

	/**
	 * Générer un flux en format XML à partir d'un fichier text
	 * 
	 * @param file
	 *            fichier à traiter
	 * @return flux construit en format String
	 */
	public String generateXmlFromText(File file);

	/**
	 * Générer un flux en format Json à partir d'un fichier text
	 * 
	 * @param file
	 *            fichier à traiter
	 * @return flux construit en format String
	 */
	public String generateJsonFromText(File file);

}
