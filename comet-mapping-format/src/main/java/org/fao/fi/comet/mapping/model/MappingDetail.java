/**
 * (c) 2014 FAO / UN (project: comet-core-vr-model)
 */
package org.fao.fi.comet.mapping.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

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
public class MappingDetail<TARGET> implements Serializable {
	/** Field serialVersionUID */
	private static final long serialVersionUID = -1479077411818857917L;

	@XmlAttribute(name="score") private double _score;
	@XmlAttribute(name="scoreType") private MappingScoreType _scoreType;
	
	@XmlElement(name="MappingContribution")
	private Collection<MappingContribution> _mappingContributions;
	
	@XmlElement(name="TargetElement")
	private Element<TARGET> _targetElement;

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
	 * @param scoreType
	 * @param mappingContributions
	 * @param targetElement
	 */
	public MappingDetail(double score, MappingScoreType scoreType, Collection<MappingContribution> mappingContributions, Element<TARGET> targetElement) {
		super();
		this._score = score;
		this._scoreType = scoreType;
		this._mappingContributions = mappingContributions;
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
	 * @return the 'scoreType' value
	 */
	public MappingScoreType getScoreType() {
		return this._scoreType;
	}

	/**
	 * @param scoreType the 'scoreType' value to set
	 */
	public void setScoreType(MappingScoreType scoreType) {
		this._scoreType = scoreType;
	}

	/**
	 * @return the 'mappingContributions' value
	 */
	public Collection<MappingContribution> getMappingContributions() {
		return this._mappingContributions;
	}

	/**
	 * @param mappingContributions the 'mappingContributions' value to set
	 */
	public void setMappingContributions(Collection<MappingContribution> mappingContributions) {
		this._mappingContributions = mappingContributions;
	}
	
	public MappingDetail<TARGET> withMappingScore(double score, MappingScoreType type) {
		this._score = score;
		this._scoreType = type;
		
		return this;
	}
	
	public MappingDetail<TARGET> withWeightedScore(double score) {
		return this.withMappingScore(score, MappingScoreType.NON_AUTHORITATIVE);
	}
	
	public MappingDetail<TARGET> asContributedBy(MappingContribution... mappingContributions) {
		this._mappingContributions = new ArrayList<MappingContribution>(Arrays.asList(mappingContributions));
		
		return this;
	}
	
	public MappingDetail<TARGET> and(MappingContribution... mappingContributions) {
		if(this._mappingContributions == null)
			this.asContributedBy(mappingContributions);
		else for(MappingContribution in : mappingContributions)
			this._mappingContributions.add(in);
		
		return this;
	}

	/**
	 * @return the 'targetElement' value
	 */
	public final Element<TARGET> getTargetElement() {
		return this._targetElement;
	}

	/**
	 * @param targetElement the 'targetElement' value to set
	 */
	public final void setTargetElement(Element<TARGET> targetElement) {
		this._targetElement = targetElement;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this._mappingContributions == null) ? 0 : this._mappingContributions.hashCode());
		long temp;
		temp = Double.doubleToLongBits(this._score);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((this._scoreType == null) ? 0 : this._scoreType.hashCode());
		result = prime * result + ((this._targetElement == null) ? 0 : this._targetElement.hashCode());
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
		MappingDetail other = (MappingDetail) obj;
		if (this._mappingContributions == null) {
			if (other._mappingContributions != null)
				return false;
		} else if (!this._mappingContributions.equals(other._mappingContributions))
			return false;
		if (Double.doubleToLongBits(this._score) != Double.doubleToLongBits(other._score))
			return false;
		if (this._scoreType != other._scoreType)
			return false;
		if (this._targetElement == null) {
			if (other._targetElement != null)
				return false;
		} else if (!this._targetElement.equals(other._targetElement))
			return false;
		return true;
	}
}
