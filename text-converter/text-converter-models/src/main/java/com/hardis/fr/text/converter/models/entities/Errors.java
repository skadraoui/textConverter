package com.hardis.fr.text.converter.models.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;

/**
 * cette classe encapsule les erreurs pour le format XML
 * @author SFKI
 *
 */
public class Errors implements Serializable {

	private static final long serialVersionUID = 7597584318035703746L;
	
	private List<Error> errors = new ArrayList<Error>();

	public Errors() {
	}

	public List<Error> getErrors() {
		return errors;
	}

	@XmlElements({ @XmlElement(name = "error", type = Error.class) })
	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

}
