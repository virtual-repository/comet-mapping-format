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
@XmlType(name="ProcessConfiguration")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProcessConfiguration implements Serializable {
	/** Field serialVersionUID */
	private static final long serialVersionUID = -1108964973004836699L;

	@XmlAttribute(name="minimumScore")
	private double _minimumScore;
	
	@XmlAttribute(name="maximumNumberOfCandidates")
	private int _maximumNumberOfCandidates;

	@XmlElement(name="SourceDataProvider")
	private DataProvider _sourceDataProvider;
	
	@XmlElement(name="TargetDataProvider")
	private DataProvider _targetDataProvider;

	/**
	 * Class constructor
	 */
	public ProcessConfiguration() {
		super();
	}

	/**
	 * Class constructor
	 *
	 * @param minimumScore
	 * @param maximumNumberOfCandidates
	 * @param sourceDataProvider
	 * @param targetDataProvider
	 */
	public ProcessConfiguration(double minimumScore, int maximumNumberOfCandidates, DataProvider sourceDataProvider, DataProvider targetDataProvider) {
		super();
		this._minimumScore = minimumScore;
		this._maximumNumberOfCandidates = maximumNumberOfCandidates;
		this._sourceDataProvider = sourceDataProvider;
		this._targetDataProvider = targetDataProvider;
	}

	/**
	 * @return the 'minimumScore' value
	 */
	public double getMinimumScore() {
		return this._minimumScore;
	}

	/**
	 * @param minimumScore the 'minimumScore' value to set
	 */
	public void setMinimumScore(double minimumScore) {
		this._minimumScore = minimumScore;
	}

	/**
	 * @return the 'maximumNumberOfCandidates' value
	 */
	public int getMaximumNumberOfCandidates() {
		return this._maximumNumberOfCandidates;
	}

	/**
	 * @param maximumNumberOfCandidates the 'maximumNumberOfCandidates' value to set
	 */
	public void setMaximumNumberOfCandidates(int maximumNumberOfCandidates) {
		this._maximumNumberOfCandidates = maximumNumberOfCandidates;
	}

	/**
	 * @return the 'sourceDataProvider' value
	 */
	public DataProvider getSourceDataProvider() {
		return this._sourceDataProvider;
	}

	/**
	 * @param sourceDataProvider the 'sourceDataProvider' value to set
	 */
	public void setSourceDataProvider(DataProvider sourceDataProvider) {
		this._sourceDataProvider = sourceDataProvider;
	}

	/**
	 * @return the 'targetDataProvider' value
	 */
	public DataProvider getTargetDataProvider() {
		return this._targetDataProvider;
	}

	/**
	 * @param targetDataProvider the 'targetDataProvider' value to set
	 */
	public void setTargetDataProvider(DataProvider targetDataProvider) {
		this._targetDataProvider = targetDataProvider;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this._maximumNumberOfCandidates;
		long temp;
		temp = Double.doubleToLongBits(this._minimumScore);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((this._sourceDataProvider == null) ? 0 : this._sourceDataProvider.hashCode());
		result = prime * result + ((this._targetDataProvider == null) ? 0 : this._targetDataProvider.hashCode());
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
		ProcessConfiguration other = (ProcessConfiguration) obj;
		if (this._maximumNumberOfCandidates != other._maximumNumberOfCandidates)
			return false;
		if (Double.doubleToLongBits(this._minimumScore) != Double.doubleToLongBits(other._minimumScore))
			return false;
		if (this._sourceDataProvider == null) {
			if (other._sourceDataProvider != null)
				return false;
		} else if (!this._sourceDataProvider.equals(other._sourceDataProvider))
			return false;
		if (this._targetDataProvider == null) {
			if (other._targetDataProvider != null)
				return false;
		} else if (!this._targetDataProvider.equals(other._targetDataProvider))
			return false;
		return true;
	}
}
