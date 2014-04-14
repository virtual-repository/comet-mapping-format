/**
 * (c) 2014 FAO / UN (project: comet-core-vr-model)
 */
package org.fao.fi.comet.vr.model;

import java.io.Serializable;

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
@SuppressWarnings("serial")
@XmlType(name="Element")
public class Element<TYPE extends Serializable> implements Serializable {
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
	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
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
