/**
 * (c) 2014 FAO / UN (project: comet-mapping-format)
 */
package org.fao.fi.comet.mapping.model.data;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

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
@XmlRootElement(name="PropertyList")
@XmlAccessorType(XmlAccessType.FIELD)
public class PropertyList implements Serializable {
	/** Field serialVersionUID */
	private static final long serialVersionUID = 3946176221665200660L;

	@XmlElement(name="Property")
	private List<Property> _properties;

	/**
	 * Class constructor
	 *
	 */
	public PropertyList() {
		super();
	}

	/**
	 * Class constructor
	 *
	 * @param properties
	 */
	public PropertyList(List<Property> properties) {
		super();
		this._properties = properties;
	}

	/**
	 * @return the 'properties' value
	 */
	public List<Property> getProperties() {
		return this._properties;
	}

	/**
	 * @param properties the 'properties' value to set
	 */
	public void setProperties(List<Property> properties) {
		this._properties = properties;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this._properties == null) ? 0 : this._properties.hashCode());
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
		PropertyList other = (PropertyList) obj;
		if (this._properties == null) {
			if (other._properties != null)
				return false;
		} else if (!this._properties.equals(other._properties))
			return false;
		return true;
	}
}
