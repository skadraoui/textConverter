package com.hardis.fr.text.converter.models.entities;

import java.io.Serializable;

/**
 * Classe Report mère
 * 
 * @author SFKI
 *
 */
public class Report implements Serializable {
	private static final long serialVersionUID = 6982136113172059050L;
	private String inputFile;

	public Report() {
	}

	public Report(String inputFile) {
		this.inputFile = inputFile;
	}

	public String getInputFile() {
		return inputFile;
	}

	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	}

}
