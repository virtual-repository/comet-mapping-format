/**
 * (c) 2014 FAO / UN (project: comet-core-vr-model)
 */
package org.fao.fi.comet.mapping.model;

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
 * 11 Apr 2014   Fiorellato     Creation.
 *
 * @version 1.0
 * @since 11 Apr 2014
 */
@XmlType(name="ElementIdentifier")
@XmlAccessorType(XmlAccessType.FIELD)
public class ElementIdentifier implements Serializable {
	private static final long serialVersionUID = 3461143166759375588L;

	@XmlAttribute(name="providerId") private String _providerId;
	@XmlAttribute(name="elementId") private String _elementId;

	/**
	 * Class constructor
	 *
	 */
	public ElementIdentifier() {
		super();
	}

	/**
	 * Class constructor
	 *
	 * @param providerId
	 * @param elementId
	 */
	public ElementIdentifier(String providerId, String elementId) {
		super();
		this._providerId = providerId;
		this._elementId = elementId;
	}
	
	/**
	 * @return the 'providerId' value
	 */
	public final String getProviderId() {
		return this._providerId;
	}

	/**
	 * @param providerId the 'providerId' value to set
	 */
	public final void setProviderId(String providerId) {
		this._providerId = providerId;
	}

	/**
	 * @return the 'elementId' value
	 */
	public final String getElementId() {
		return this._elementId;
	}

	/**
	 * @param elementId the 'elementId' value to set
	 */
	public final void setElementId(String elementId) {
		this._elementId = elementId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this._elementId == null) ? 0 : this._elementId.hashCode());
		result = prime * result + ((this._providerId == null) ? 0 : this._providerId.hashCode());
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
		ElementIdentifier other = (ElementIdentifier) obj;
		if (this._elementId == null) {
			if (other._elementId != null)
				return false;
		} else if (!this._elementId.equals(other._elementId))
			return false;
		if (this._providerId == null) {
			if (other._providerId != null)
				return false;
		} else if (!this._providerId.equals(other._providerId))
			return false;
		return true;
	}
}