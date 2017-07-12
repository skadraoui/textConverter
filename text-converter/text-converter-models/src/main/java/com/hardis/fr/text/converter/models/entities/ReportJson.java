package com.hardis.fr.text.converter.models.entities;

import java.io.Serializable;
import java.util.List;

/**
 * Classe report spécifique pour le format Json
 * 
 * @author SFKI
 *
 */
public class ReportJson extends Report implements Serializable {

	private static final long serialVersionUID = 3127056347921968584L;

	private List<Reference> references;
	private List<Error> errors;

	public ReportJson() {
	}

	public List<Reference> getReferences() {
		return references;
	}

	public void setReferences(List<Reference> references) {
		this.references = references;
	}

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

}
