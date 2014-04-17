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
import javax.xml.bind.annotation.XmlValue;

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
@XmlType(name="MatcherConfigurationProperty")
@XmlAccessorType(XmlAccessType.FIELD)
public class MatcherConfigurationProperty  implements Serializable {
	/** Field serialVersionUID */
	private static final long serialVersionUID = -424572262353072964L;

	@XmlAttribute(name="name") private String _name;
	@XmlAttribute(name="type") private String _type;
	
	@XmlElement(name="Description")
	private String _description;
	
	@XmlValue
	private Object _value;

	/**
	 * Class constructor
	 *
	 */
	public MatcherConfigurationProperty() {
		super();
	}

	/**
	 * Class constructor
	 *
	 * @param name
	 * @param type
	 * @param description
	 * @param value
	 */
	public MatcherConfigurationProperty(String name, String type, String description, Object value) {
		super();
		this._name = name;
		this._type = type;
		this._description = description;
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

	/**
	 * @return the 'value' value
	 */
	public Object getValue() {
		return this._value;
	}

	/**
	 * @param value the 'value' value to set
	 */
	public void setValue(Object value) {
		this._value = value;
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
		result = prime * result + ((this._name == null) ? 0 : this._name.hashCode());
		result = prime * result + ((this._type == null) ? 0 : this._type.hashCode());
		result = prime * result + ((this._value == null) ? 0 : this._value.hashCode());
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
		MatcherConfigurationProperty other = (MatcherConfigurationProperty) obj;
		if (this._description == null) {
			if (other._description != null)
				return false;
		} else if (!this._description.equals(other._description))
			return false;
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
