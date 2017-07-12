package com.hardis.fr.text.converter.dao;

import java.io.File;
import java.io.IOException;

import com.hardis.fr.text.converter.exceptions.ReportException;
import com.hardis.fr.text.converter.models.entities.Reference;
import com.hardis.fr.text.converter.models.entities.Report;

/**
 * CRUD sur la classe Réference
 * 
 * @author SFKI
 *
 */
public interface ReferenceDAO extends GenericDAO<Reference, String> {

	/**
	 * Parser un fichier text en format XML ou JSON
	 * 
	 * @param file
	 *            fichier à traiter
	 * @param format
	 *            formt à traiter (XML| JSON)
	 * @return Report XML ou JSON selon le format demandé
	 * @throws ReportException
	 *             exception en cas de problème de construction de références
	 * @throws IOException
	 *             Exception en cas de problème de lecture du fichier à traiter
	 */
	public Report getReportFromFile(File file, String format) throws ReportException, IOException;
}
