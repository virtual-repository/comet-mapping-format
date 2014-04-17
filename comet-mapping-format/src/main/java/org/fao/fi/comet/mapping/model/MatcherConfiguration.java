/**
 * (c) 2014 FAO / UN (project: comet-mapping-format)
 */
package org.fao.fi.comet.mapping.model;

import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
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
@XmlType(name="MatcherConfiguration")
@XmlAccessorType(XmlAccessType.FIELD)
public class MatcherConfiguration implements Serializable {
	/** Field serialVersionUID */
	private static final long serialVersionUID = -5759769021546429122L;

	@XmlAttribute(name="isOptional") private boolean _isOptional;
	@XmlAttribute(name="minimumScore") private double _minimumScore;
	@XmlAttribute(name="weight") private double _weight;
	@XmlAttribute(name="type") private String _matcherType;
	@XmlAttribute(name="id") private URI _matcherId;
	
	@XmlElement(name="ConfigurationProperty")
	private Collection<MatcherConfigurationProperty> _configurationProperties;
	
	/**
	 * Class constructor
	 */
	public MatcherConfiguration() {
		super();
	}
	
	/**
	 * Class constructor
	 */
	public MatcherConfiguration(URI id) {
		this(id, null, 1D, ScoreValue.NO_MATCH, false, new ArrayList<MatcherConfigurationProperty>());
	}

	/**
	 * Class constructor
	 *
	 * @param matcherId
	 * @param matcherType
	 * @param weight
	 * @param minimumScore
	 * @param isOptional
	 * @param configurationProperties
	 */
	public MatcherConfiguration(URI matcherId, String matcherType, double weight, double minimumScore, boolean isOptional, Collection<MatcherConfigurationProperty> configurationProperties) {
		super();
		this._matcherId = matcherId;
		this._matcherType = matcherType;
		this._weight = weight;
		this._minimumScore = minimumScore;
		this._isOptional = isOptional;
		this._configurationProperties = configurationProperties;
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
	 * @return the 'matcherType' value
	 */
	public String getMatcherType() {
		return this._matcherType;
	}

	/**
	 * @param matcherType the 'matcherType' value to set
	 */
	public void setMatcherType(String matcherType) {
		this._matcherType = matcherType;
	}
	
	/**
	 * @return the 'weight' value
	 */
	public double getWeight() {
		return this._weight;
	}

	/**
	 * @param weight the 'weight' value to set
	 */
	public void setWeight(double weight) {
		this._weight = weight;
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
	 * @return the 'isOptional' value
	 */
	public boolean isOptional() {
		return this._isOptional;
	}

	/**
	 * @param isOptional the 'isOptional' value to set
	 */
	public void setOptional(boolean isOptional) {
		this._isOptional = isOptional;
	}

	/**
	 * @return the 'configurationProperties' value
	 */
	public Collection<MatcherConfigurationProperty> getConfigurationProperties() {
		return this._configurationProperties;
	}

	/**
	 * @param configurationProperties the 'configurationProperties' value to set
	 */
	public void setConfigurationProperties(Collection<MatcherConfigurationProperty> configurationProperties) {
		this._configurationProperties = configurationProperties;
	}
	
	public MatcherConfiguration having(MatcherConfigurationProperty... configurationProperties) {
		this.setConfigurationProperties(Arrays.asList(configurationProperties));
		
		return this;
	}
	
	public MatcherConfiguration weighting(double weight) {
		this._weight = weight;
		
		return this;
	}
	
	public MatcherConfiguration ofType(String type) {
		this._matcherType = type;
		
		return this;
	}
	
	public MatcherConfiguration optional() {
		this._isOptional = true;
		
		return this;
	}
	
	public MatcherConfiguration withMinimumScore(double minimumScore) {
		this._minimumScore = minimumScore;
		
		return this;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this._configurationProperties == null) ? 0 : this._configurationProperties.hashCode());
		result = prime * result + (this._isOptional ? 1231 : 1237);
		result = prime * result + ((this._matcherId == null) ? 0 : this._matcherId.hashCode());
		result = prime * result + ((this._matcherType == null) ? 0 : this._matcherType.hashCode());
		long temp;
		temp = Double.doubleToLongBits(this._minimumScore);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(this._weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		MatcherConfiguration other = (MatcherConfiguration) obj;
		if (this._configurationProperties == null) {
			if (other._configurationProperties != null)
				return false;
		} else if (!this._configurationProperties.equals(other._configurationProperties))
			return false;
		if (this._isOptional != other._isOptional)
			return false;
		if (this._matcherId == null) {
			if (other._matcherId != null)
				return false;
		} else if (!this._matcherId.equals(other._matcherId))
			return false;
		if (this._matcherType == null) {
			if (other._matcherType != null)
				return false;
		} else if (!this._matcherType.equals(other._matcherType))
			return false;
		if (Double.doubleToLongBits(this._minimumScore) != Double.doubleToLongBits(other._minimumScore))
			return false;
		if (Double.doubleToLongBits(this._weight) != Double.doubleToLongBits(other._weight))
			return false;
		return true;
	}
}