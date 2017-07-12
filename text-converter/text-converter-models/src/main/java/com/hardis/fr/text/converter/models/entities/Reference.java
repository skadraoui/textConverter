package com.hardis.fr.text.converter.models.entities;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/** Classe de référence
 * @author SFKI
 *
 */
@XmlRootElement
@XmlType(propOrder = { "type", "price", "size", "numReference" })
public class Reference implements Serializable {

	private static final long serialVersionUID = -5296295316013257165L;
	private String numReference;
	private long size;
	private float price;
	private char type;

	public Reference() {
	}

	public Reference(char type, float price, long size, String numReference) {
		super();
		this.type = type;
		this.price = price;
		this.size = size;
		this.numReference = numReference;
	}

	public char getType() {
		return type;
	}

	@XmlAttribute(name = "color")
	public void setType(char type) {
		this.type = type;
	}

	public float getPrice() {
		return price;
	}

	@XmlAttribute
	public void setPrice(float price) {
		this.price = price;
	}

	public long getSize() {
		return size;
	}

	@XmlAttribute
	public void setSize(long size) {
		this.size = size;
	}

	public String getNumReference() {
		return numReference;
	}

	@XmlAttribute
	public void setNumReference(String numReference) {
		this.numReference = numReference;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numReference == null) ? 0 : numReference.hashCode());
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + (int) (size ^ (size >>> 32));
		result = prime * result + type;
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
		Reference other = (Reference) obj;
		if (numReference == null) {
			if (other.numReference != null)
				return false;
		} else if (!numReference.equals(other.numReference))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (size != other.size)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

}
