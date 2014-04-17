/**
 * (c) 2014 FAO / UN (project: comet-mapping-format)
 */
package org.fao.fi.comet.mapping.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Place your class / interface description here.
 *
 * History:
 *
 * ------------- --------------- -----------------------
 * Date			 Author			 Comment
 * ------------- --------------- -----------------------
 * 17 Apr 2014   Fiorellato     Creation.
 *
 * @version 1.0
 * @since 17 Apr 2014
 */
@XmlType(name="DataProvider")
@XmlAccessorType(XmlAccessType.FIELD)
public class DataProvider implements Serializable {
	/** Field serialVersionUID */
	private static final long serialVersionUID = 5860563937581245902L;

	@XmlAttribute(name="identifier")
	private String _identifier;
	
	@XmlAttribute(name="type")
	private String _type;
	
	@XmlElement(name="Description")
	private String _description;

	/**
	 * Class constructor
	 */
	public DataProvider() {
		super();
	}

	/**
	 * Class constructor
	 *
	 * @param identifier
	 * @param type
	 * @param description
	 */
	public DataProvider(String identifier, String type, String description) {
		super();
		this._identifier = identifier;
		this._type = type;
		this._description = description;
	}
	
	/**
	 * Class constructor
	 *
	 * @param identifier
	 * @param type
	 */
	public DataProvider(String identifier, String type) {
		this(identifier, type, null);
	}

	/**
	 * @return the 'identifier' value
	 */
	public String getIdentifier() {
		return this._identifier;
	}

	/**
	 * @param identifier the 'identifier' value to set
	 */
	public void setIdentifier(String identifier) {
		this._identifier = identifier;
	}

	/**
	 * @return the 'type' value
	 */
	public String getType() {
		return this._type;
	}

	/**
	 * @param type the 'type' value to set
	 */
	public void setType(String type) {
		this._type = type;
	}

	/**
	 * @return the 'description' value
	 */
	public String getDescription() {
		return this._description;
	}

	/**
	 * @param description the 'description' value to set
	 */
	public void setDescription(String description) {
		this._description = description;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this._description == null) ? 0 : this._description.hashCode());
		result = prime * result + ((this._identifier == null) ? 0 : this._identifier.hashCode());
		result = prime * result + ((this._type == null) ? 0 : this._type.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DataProvider other = (DataProvider) obj;
		if (this._description == null) {
			if (other._description != null)
				return false;
		} else if (!this._description.equals(other._description))
			return false;
		if (this._identifier == null) {
			if (other._identifier != null)
				return false;
		} else if (!this._identifier.equals(other._identifier))
			return false;
		if (this._type == null) {
			if (other._type != null)
				return false;
		} else if (!this._type.equals(other._type))
			return false;
		return true;
	}
}
