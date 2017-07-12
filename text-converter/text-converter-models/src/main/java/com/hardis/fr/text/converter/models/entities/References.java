package com.hardis.fr.text.converter.models.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;

/**
 * Classe qui encapsule les références pour le format XML
 * @author SFKI
 *
 */
public class References implements Serializable {

	private static final long serialVersionUID = -8846823915719056314L;

	private List<Reference> references = new ArrayList<Reference>();

	public References() {
	}

	public List<Reference> getReferences() {
		return references;
	}

	@XmlElements({ @XmlElement(name = "reference", type = Reference.class) })
	public void setReferences(List<Reference> references) {
		this.references = references;
	}

}
