package com.hardis.fr.text.converter.models.entities;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Classe report spécifique pour le format XML
 * 
 * @author SFKI
 *
 */
@XmlRootElement(name = "report")
@XmlType(propOrder = { "references", "errors" })
public class ReportXml extends Report implements Serializable {

	private static final long serialVersionUID = 3127056347921968584L;

	private References references;
	private Errors errors;

	public ReportXml() {
		super();
	}

	public ReportXml(String inputFile, References employees, Errors errors) {
		super(inputFile);
		this.references = employees;
		this.errors = errors;
	}

	public References getReferences() {
		return references;
	}

	public void setReferences(References references) {
		this.references = references;
	}

	public Errors getErrors() {
		return errors;
	}

	public void setErrors(Errors errors) {
		this.errors = errors;
	}

}
