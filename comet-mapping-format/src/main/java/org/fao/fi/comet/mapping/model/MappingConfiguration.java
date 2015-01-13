/**
 * (c) 2015 FAO / UN (project: comet-mapping-format)
 */
package org.fao.fi.comet.mapping.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Place your class / interface description here.
 *
 * History:
 *
 * ------------- --------------- -----------------------
 * Date			 Author			 Comment
 * ------------- --------------- -----------------------
 * 13 Jan 2015   Fiorellato     Creation.
 *
 * @version 1.0
 * @since 13 Jan 2015
 */
@XmlRootElement(name="MappingConfiguration")
@XmlAccessorType(XmlAccessType.FIELD)
public class MappingConfiguration implements Serializable {
	/** Field serialVersionUID */
	private static final long serialVersionUID = -8400887880370883740L;

	@XmlElement(name="Id")
	private String _id;
	
	@XmlElement(name="Version")
	private String _version;
	
	@XmlElement(name="Description")
	private String _description;
	
	@XmlElement(name="Producer")
	private String _producer;
	
	@XmlElement(name="ProductionDate")
	private Date _productionDate;
	
	@XmlElement(name="ProcessConfiguration")
	private ProcessConfiguration _processConfiguration;
	
	@XmlElementWrapper(name="MatchersConfiguration")
	@XmlElement(name="MatcherConfiguration")
	private Collection<MatcherConfiguration> _matcherConfigurations; 

	/**
	 * Class constructor
	 *
	 */
	public MappingConfiguration() {
		super();
	}

	/**
	 * Class constructor
	 *
	 * @param id
	 * @param version
	 * @param description
	 * @param producer
	 * @param productionDate
	 * @param processConfiguration
	 * @param matcherConfigurations
	 */
	public MappingConfiguration(String id, String version, String description, String producer, Date productionDate, ProcessConfiguration processConfiguration, Collection<MatcherConfiguration> matcherConfigurations) {
		super();
		this._id = id;
		this._version = version;
		this._description = description;
		this._producer = producer;
		this._productionDate = productionDate;
		this._processConfiguration = processConfiguration;
		this._matcherConfigurations = matcherConfigurations;
	}

	/**
	 * @return the 'id' value
	 */
	public String getId() {
		return this._id;
	}

	/**
	 * @param id the 'id' value to set
	 */
	public void setId(String id) {
		this._id = id;
	}

	/**
	 * @return the 'version' value
	 */
	public String getVersion() {
		return this._version;
	}

	/**
	 * @param version the 'version' value to set
	 */
	public void setVersion(String version) {
		this._version = version;
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
	 * @return the 'producer' value
	 */
	public String getProducer() {
		return this._producer;
	}

	/**
	 * @param producer the 'producer' value to set
	 */
	public void setProducer(String producer) {
		this._producer = producer;
	}

	/**
	 * @return the 'productionDate' value
	 */
	public Date getProductionDate() {
		return this._productionDate;
	}

	/**
	 * @param productionDate the 'productionDate' value to set
	 */
	public void setProductionDate(Date productionDate) {
		this._productionDate = productionDate;
	}

	/**
	 * @return the 'processConfiguration' value
	 */
	public ProcessConfiguration getProcessConfiguration() {
		return this._processConfiguration;
	}

	/**
	 * @param processConfiguration the 'processConfiguration' value to set
	 */
	public void setProcessConfiguration(ProcessConfiguration processConfiguration) {
		this._processConfiguration = processConfiguration;
	}

	/**
	 * @return the 'matcherConfigurations' value
	 */
	public Collection<MatcherConfiguration> getMatcherConfigurations() {
		return this._matcherConfigurations;
	}

	/**
	 * @param matcherConfigurations the 'matcherConfigurations' value to set
	 */
	public void setMatcherConfigurations(Collection<MatcherConfiguration> matcherConfigurations) {
		this._matcherConfigurations = matcherConfigurations;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this._description == null) ? 0 : this._description.hashCode());
		result = prime * result + ((this._id == null) ? 0 : this._id.hashCode());
		result = prime * result + ((this._matcherConfigurations == null) ? 0 : this._matcherConfigurations.hashCode());
		result = prime * result + ((this._processConfiguration == null) ? 0 : this._processConfiguration.hashCode());
		result = prime * result + ((this._producer == null) ? 0 : this._producer.hashCode());
		result = prime * result + ((this._productionDate == null) ? 0 : this._productionDate.hashCode());
		result = prime * result + ((this._version == null) ? 0 : this._version.hashCode());
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
		MappingConfiguration other = (MappingConfiguration) obj;
		if (this._description == null) {
			if (other._description != null)
				return false;
		} else if (!this._description.equals(other._description))
			return false;
		if (this._id == null) {
			if (other._id != null)
				return false;
		} else if (!this._id.equals(other._id))
			return false;
		if (this._matcherConfigurations == null) {
			if (other._matcherConfigurations != null)
				return false;
		} else if (!this._matcherConfigurations.equals(other._matcherConfigurations))
			return false;
		if (this._processConfiguration == null) {
			if (other._processConfiguration != null)
				return false;
		} else if (!this._processConfiguration.equals(other._processConfiguration))
			return false;
		if (this._producer == null) {
			if (other._producer != null)
				return false;
		} else if (!this._producer.equals(other._producer))
			return false;
		if (this._productionDate == null) {
			if (other._productionDate != null)
				return false;
		} else if (!this._productionDate.equals(other._productionDate))
			return false;
		if (this._version == null) {
			if (other._version != null)
				return false;
		} else if (!this._version.equals(other._version))
			return false;
		return true;
	}
}
