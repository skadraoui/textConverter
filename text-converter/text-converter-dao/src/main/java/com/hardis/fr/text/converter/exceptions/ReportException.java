package com.hardis.fr.text.converter.exceptions;

/**
 * Exception spécifique sur la contruction de la classe Report
 * 
 * @author SFKI
 *
 */
public class ReportException extends Exception {

	private static final long serialVersionUID = 5803068808816201064L;

	/**
	 * @param message le message d'erreure de l'exception
	 */
	public ReportException(String message) {
		super(message);
	}

}
