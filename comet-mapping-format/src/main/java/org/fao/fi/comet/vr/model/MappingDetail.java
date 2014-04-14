/**
 * (c) 2014 FAO / UN (project: comet-core-vr-model)
 */
package org.fao.fi.comet.vr.model;

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
 * 11 Apr 2014   Fiorellato     Creation.
 *
 * @version 1.0
 * @since 11 Apr 2014
 */
@XmlType(name="MappingDetail")
@XmlAccessorType(XmlAccessType.FIELD)
public class MappingDetail<TARGET extends Serializable> implements Serializable {
	/** Field serialVersionUID */
	private static final long serialVersionUID = -1479077411818857917L;

	@XmlAttribute(name="mappingScore")
	private double _score;
	
	@XmlElement(name="TargetElement")
	private TARGET _targetElement;

	/**
	 * Class constructor
	 *
	 */
	public MappingDetail() {
		super();
	}

	/**
	 * Class constructor
	 *
	 * @param score
	 * @param targetElement
	 */
	public MappingDetail(double score, TARGET targetElement) {
		super();
		this._score = score;
		this._targetElement = targetElement;
	}

	/**
	 * @return the 'score' value
	 */
	public final double getScore() {
		return this._score;
	}

	/**
	 * @param score the 'score' value to set
	 */
	public final void setScore(double score) {
		this._score = score;
	}

	/**
	 * @return the 'targetElement' value
	 */
	public final TARGET getTargetElement() {
		return this._targetElement;
	}

	/**
	 * @param targetElement the 'targetElement' value to set
	 */
	public final void setTargetElement(TARGET targetElement) {
		this._targetElement = targetElement;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(this._score);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((this._targetElement == null) ? 0 : this._targetElement.hashCode());
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
		MappingDetail other = (MappingDetail) obj;
		if (Double.doubleToLongBits(this._score) != Double.doubleToLongBits(other._score))
			return false;
		if (this._targetElement == null) {
			if (other._targetElement != null)
				return false;
		} else if (!this._targetElement.equals(other._targetElement))
			return false;
		return true;
	}
}
