package com.hardis.fr.text.converter.soa;

import java.io.File;

public interface TextParserSOA {

	/**
	 * G�n�rer un flux en format XML � partir d'un fichier text
	 * 
	 * @param file
	 *            fichier � traiter
	 * @return flux construit en format String
	 */
	public String generateXmlFromText(File file);

	/**
	 * G�n�rer un flux en format Json � partir d'un fichier text
	 * 
	 * @param file
	 *            fichier � traiter
	 * @return flux construit en format String
	 */
	public String generateJsonFromText(File file);

}
