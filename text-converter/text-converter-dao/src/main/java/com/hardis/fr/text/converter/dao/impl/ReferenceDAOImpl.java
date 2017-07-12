package com.hardis.fr.text.converter.dao.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import com.hardis.fr.text.converter.dao.ReferenceDAO;
import com.hardis.fr.text.converter.exceptions.ReportException;
import com.hardis.fr.text.converter.models.entities.Error;
import com.hardis.fr.text.converter.models.entities.Errors;
import com.hardis.fr.text.converter.models.entities.Reference;
import com.hardis.fr.text.converter.models.entities.References;
import com.hardis.fr.text.converter.models.entities.Report;
import com.hardis.fr.text.converter.models.entities.ReportJson;
import com.hardis.fr.text.converter.models.entities.ReportXml;
import com.hardis.fr.text.converter.traitement.LineParser;

/**
 * Implémentation de CRUD Reference + methode spécifique
 * 
 * @author SFKI
 *
 */
public class ReferenceDAOImpl implements ReferenceDAO {

	public Report getReportFromFile(File file, String format) throws ReportException, IOException {
		Report report = new Report();
		Scanner scanner = new Scanner(file);
		try {
			report = traiterLignes(scanner, format);
			report.setInputFile(file.toString());
			return report;
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	/**
	 * Traiter les lignes du fichier d'import un par un bet renvoyer un report
	 * 
	 * @param scanner
	 *            scanner de lecture du flux
	 * @param format
	 *            format souhaité (XML|JSON)
	 * @return report fabriqué à partir du contenu du fichier
	 */
	private Report traiterLignes(Scanner scanner, String format) {
		References references = new References();
		Errors errors = new Errors();
		List<Reference> referencesList = new ArrayList<Reference>();
		List<Error> errorsList = new ArrayList<Error>();
		long lineNumber = 0;
		// parcours du flux ligne par ligne
		while (scanner.hasNext()) {
			lineNumber++;
			String ligneReference = scanner.nextLine();
			// if (ParserDonnees.parseReference(ligneReference)) {
			try {
				Reference reference = LineParser.formaterLigneReference(ligneReference);
				referencesList.add(reference);

			} catch (ReportException reportException) {
				// en cas d'erreurconstruire un objet Error
				Error erreur = new Error();
				erreur.setLine(lineNumber);
				erreur.setMessage(reportException.getMessage());
				erreur.setValue(ligneReference);
				errorsList.add(erreur);
			}
			// }
		}
		if (format == null | format.isEmpty()) {
			return null;
		}
		// Selon le format demandé, construire l'objet approprié
		if ("XML".equals(format.toUpperCase())) {
			ReportXml reportXml = new ReportXml();

			references.setReferences(referencesList);
			errors.setErrors(errorsList);
			reportXml.setReferences(references);
			reportXml.setErrors(errors);
			return reportXml;
		} else if ("JSON".equals(format.toUpperCase())) {
			ReportJson reportJson = new ReportJson();

			reportJson.setReferences(referencesList);
			reportJson.setErrors(errorsList);
			return reportJson;
		} else {
			return null;
		}

	}

	public void create(Reference objet) {
		// TODO Auto-generated method stub

	}

	public Reference getObjectByPrimaryKey(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<Reference> retreive() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Reference update(Reference object) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Reference object) {
		// TODO Auto-generated method stub

	}

}
