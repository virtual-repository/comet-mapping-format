/**
 * (c) 2014 FAO / UN (project: comet-core-vr-model)
 */
package org.fao.fi.comet.mapping.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 * 11 Apr 2014   Fiorellato     Creation.
 *
 * @version 1.0
 * @since 11 Apr 2014
 */
@XmlType(name="Element")
@XmlAccessorType(XmlAccessType.FIELD)
public class Element<TYPE> implements Serializable {
	private static final long serialVersionUID = 2149883627044381192L;

	@XmlElement(name="ElementIdentifier")
	private ElementIdentifier _id;
	
	@XmlElement(name="ElementData")
	private TYPE _data;

	/**
	 * Class constructor
	 *
	 */
	public Element() {
		super();
	}
	
	/**
	 * @param id
	 */
	public Element(ElementIdentifier id) {
		super();
		this._id = id;
	}

	/**
	 * @param data
	 */
	public Element(TYPE data) {
		super();
		this._data = data;
	}

	/**
	 * @param id
	 * @param data
	 */
	public Element(ElementIdentifier id, TYPE data) {
		super();
		this._id = id;
		this._data = data;
	}

	/**
	 * @return the 'id' value
	 */
	public final ElementIdentifier getId() {
		return this._id;
	}

	/**
	 * @param id the 'id' value to set
	 */
	public final void setId(ElementIdentifier id) {
		this._id = id;
	}

	/**
	 * @return the 'data' value
	 */
	public final TYPE getData() {
		return this._data;
	}

	/**
	 * @param data the 'data' value to set
	 */
	public final void setData(TYPE data) {
		this._data = data;
	}
	
	public Element<TYPE> with(String providerId, String elementId) {
		return this.with(new ElementIdentifier(providerId, elementId));
	}
	
	 public Element<TYPE> with(ElementIdentifier elementIdentifier) {
		this.setId(elementIdentifier);
		
		return this;
	}
	
	public Element<TYPE> wrapping(TYPE data) {
		this._data = data;
		
		return this;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this._data == null) ? 0 : this._data.hashCode());
		result = prime * result + ((this._id == null) ? 0 : this._id.hashCode());
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
		@SuppressWarnings("rawtypes")
		Element other = (Element) obj;
		if (this._data == null) {
			if (other._data != null)
				return false;
		} else if (!this._data.equals(other._data))
			return false;
		if (this._id == null) {
			if (other._id != null)
				return false;
		} else if (!this._id.equals(other._id))
			return false;
		return true;
	}
}