/**
 * (c) 2014 FAO / UN (project: comet-mapping-format)
 */
package org.fao.fi.comet.mapping.model.data;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * Place your class / interface description here.
 *
 * History:
 *
 * ------------- --------------- -----------------------
 * Date			 Author			 Comment
 * ------------- --------------- -----------------------
 * 13 May 2014   Fiorellato     Creation.
 *
 * @version 1.0
 * @since 13 May 2014
 */
@XmlType(name="Property")
@XmlAccessorType(XmlAccessType.FIELD)
public class Property implements Serializable {
	/** Field serialVersionUID */
	private static final long serialVersionUID = -6887342784737790644L;
	
	@XmlAttribute(name="name", required=true)
	private String _name;
	
	@XmlAttribute(name="type", required=true)
	private String _type;
	
	@XmlAttribute(name="value", required=false)
	private String _value;
	
	/**
	 * Class constructor
	 *
	 */
	public Property() {
		super();
	}

	/**
	 * Class constructor
	 *
	 * @param name
	 * @param type
	 * @param value
	 */
	public Property(String name, String type, String value) {
		super();
		this._name = name;
		this._type = type;
		this._value = value;
	}

	/**
	 * @return the 'name' value
	 */
	public String getName() {
		return this._name;
	}

	/**
	 * @param name the 'name' value to set
	 */
	public void setName(String name) {
		this._name = name;
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
	 * @return the 'value' value
	 */
	public String getValue() {
		return this._value;
	}

	/**
	 * @param value the 'value' value to set
	 */
	public void setValue(String value) {
		this._value = value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this._name == null) ? 0 : this._name.hashCode());
		result = prime * result + ((this._type == null) ? 0 : this._type.hashCode());
		result = prime * result + ((this._value == null) ? 0 : this._value.hashCode());
		return result;
	}

	/* (non-Javadoc)
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
		Property other = (Property) obj;
		if (this._name == null) {
			if (other._name != null)
				return false;
		} else if (!this._name.equals(other._name))
			return false;
		if (this._type == null) {
			if (other._type != null)
				return false;
		} else if (!this._type.equals(other._type))
			return false;
		if (this._value == null) {
			if (other._value != null)
				return false;
		} else if (!this._value.equals(other._value))
			return false;
		return true;
	}
}
