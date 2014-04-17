/**
 * (c) 2014 FAO / UN (project: comet-mapping-format)
 */
package org.fao.fi.comet.mapping.model;

import java.io.Serializable;
import java.net.URI;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import org.fao.fi.comet.mapping.ScoreValue;

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
@XmlType(name="MappingContribution")
@XmlAccessorType(XmlAccessType.FIELD)
public class MappingContribution implements Serializable {
	/** Field serialVersionUID */
	private static final long serialVersionUID = 8748101803408206932L;

	@XmlAttribute(name="matcherScoreType") private MappingScoreType _matcherScoreType;
	@XmlAttribute(name="matcherScore") private double _matcherScore;
	@XmlAttribute(name="matcherId") private URI _matcherId;
	
	/**
	 * Class constructor
	 *
	 */
	public MappingContribution() {
		super();
	}

	/**
	 * Class constructor
	 *
	 * @param matcherId
	 * @param matcherScore
	 * @param matcherScoreType
	 */
	public MappingContribution(URI matcherId, double matcherScore, MappingScoreType matcherScoreType) {
		super();
		this._matcherId = matcherId;
		this._matcherScore = matcherScore;
		this._matcherScoreType = matcherScoreType;
	}
	
	
	/**
	 * @return the 'matcherId' value
	 */
	public URI getMatcherId() {
		return this._matcherId;
	}

	/**
	 * @param matcherId the 'matcherId' value to set
	 */
	public void setMatcherId(URI matcherId) {
		this._matcherId = matcherId;
	}

	/**
	 * @return the 'matcherScore' value
	 */
	public double getMatcherScore() {
		return this._matcherScore;
	}

	/**
	 * @param matcherScore the 'matcherScore' value to set
	 */
	public void setMatcherScore(double matcherScore) {
		this._matcherScore = matcherScore;
	}

	/**
	 * @return the 'matcherScoreType' value
	 */
	public MappingScoreType getMatcherScoreType() {
		return this._matcherScoreType;
	}

	/**
	 * @param matcherScoreType the 'matcherScoreType' value to set
	 */
	public void setMatcherScoreType(MappingScoreType matcherScoreType) {
		this._matcherScoreType = matcherScoreType;
	}
	
	public MappingContribution scoring(double score, MappingScoreType scoreType) {
		this._matcherScore = score;
		this._matcherScoreType = scoreType;
		
		return this;
	}
	
	public MappingContribution scoring(double score) {
		return this.scoring(score, MappingScoreType.NON_AUTHORITATIVE);
	}
	
	public MappingContribution nonPerformed() {
		return this.scoring(ScoreValue.NO_MATCH, MappingScoreType.NON_PERFORMED);
	}
	
	public MappingContribution authoritative(double score) {
		return this.scoring(score, MappingScoreType.AUTHORITATIVE);
	}

	public MappingContribution nonAuthoritative(double score) {
		return this.scoring(score, MappingScoreType.NON_AUTHORITATIVE);
	}

	public MappingContribution authoritativeFullMatch() {
		return this.authoritative(ScoreValue.FULL_MATCH);
	}
	
	public MappingContribution authoritativeNoMatch() {
		return this.authoritative(ScoreValue.NO_MATCH);
	}

	public MappingContribution fullMatch() {
		return this.nonAuthoritative(ScoreValue.FULL_MATCH);
	}

	public MappingContribution noMatch() {
		return this.nonAuthoritative(ScoreValue.NO_MATCH);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this._matcherId == null) ? 0 : this._matcherId.hashCode());
		long temp;
		temp = Double.doubleToLongBits(this._matcherScore);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((this._matcherScoreType == null) ? 0 : this._matcherScoreType.hashCode());
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
		MappingContribution other = (MappingContribution) obj;
		if (this._matcherId == null) {
			if (other._matcherId != null)
				return false;
		} else if (!this._matcherId.equals(other._matcherId))
			return false;
		if (Double.doubleToLongBits(this._matcherScore) != Double.doubleToLongBits(other._matcherScore))
			return false;
		if (this._matcherScoreType != other._matcherScoreType)
			return false;
		return true;
	}
}