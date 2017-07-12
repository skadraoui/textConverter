package com.hardis.fr.text.converter.models.entities;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

/**
 * Classe qui représente les erreurs
 * 
 * @author SFKI
 *
 */
@XmlRootElement
public class Error {

	private long line;
	private String message;
	private String value;

	public Error() {
	}

	public Error(long lineNumber, String lineContent, String message) {
		super();
		this.line = lineNumber;
		this.value = lineContent;
		this.message = message;
	}

	public long getLine() {
		return line;
	}

	@XmlAttribute
	public void setLine(long line) {
		this.line = line;
	}

	public String getValue() {
		return value;
	}

	@XmlValue
	public void setValue(String value) {
		this.value = value;
	}

	public String getMessage() {
		return message;
	}

	@XmlAttribute
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (line ^ (line >>> 32));
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Error other = (Error) obj;
		if (line != other.line)
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}
