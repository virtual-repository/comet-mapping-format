/**
 * (c) 2014 FAO / UN (project: comet-mapping-format)
 */
package org.fao.fi.comet.mapping.model;

import java.io.Serializable;
import java.net.URI;

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
@XmlType(name="DataProvider")
@XmlAccessorType(XmlAccessType.FIELD)
public class DataProvider implements Serializable {
	/** Field serialVersionUID */
	private static final long serialVersionUID = 5860563937581245902L;

	@XmlAttribute(name="providedType", required=false) private String _providedType;
	@XmlAttribute(name="version", required=false) private String _version;
	@XmlAttribute(name="dataSourceId") private URI _dataSourceId;
	@XmlAttribute(name="providerType") private URI _providerType;
	@XmlAttribute(name="providerId") private URI _providerId;
	
	@XmlElement(name="Description", nillable=true)
	private String _description;

	/**
	 * Class constructor
	 */
	public DataProvider() {
		super();
	}

	/**
	 * Class constructor
	 *
	 * @param providerId
	 * @param providerType
	 * @param dataSourceId
	 * @param version
	 * @param providedType
	 * @param description
	 */
	public DataProvider(URI providerId, URI providerType, URI dataSourceId, String version, String providedType, String description) {
		super();
		this._providerId = providerId;
		this._providerType = providerType;
		this._dataSourceId = dataSourceId;
		this._version = version;
		this._providedType = providedType;
		this._description = description;
	}

	/**
	 * Class constructor
	 *
	 * @param providerId
	 * @param providerType
	 * @param dataSourceId
	 * @param version
	 * @param providedType
	 */
	public DataProvider(URI providerId, URI providerType, URI dataSourceId, String version, String providedType) {
		this(providerId, providerType, dataSourceId, version, providedType, null);
	}

	/**
	 * Class constructor
	 *
	 * @param providerIdURI
	 * @param providerTypeURI
	 * @param dataSourceIdURI
	 * @param version
	 * @param providedType
	 * @param description
	 */
	public DataProvider(String providerIdURI, String providerTypeURI, String dataSourceIdURI, String version, String providedType, String description) {
		this(URI.create(providerIdURI), URI.create(providerTypeURI), URI.create(dataSourceIdURI), version, providedType, description);
	}

	/**
	 * Class constructor
	 *
	 * @param providerIdURI
	 * @param providerTypeURI
	 * @param dataSourceIdURI
	 * @param version
	 * @param providedType
	 */
	public DataProvider(String providerIdURI, String providerTypeURI, String dataSourceIdURI, String version, String providedType) {
		this(providerIdURI, providerTypeURI, dataSourceIdURI, version, providedType, null);
	}

	/**
	 * @return the 'providerId' value
	 */
	public URI getProviderId() {
		return this._providerId;
	}

	/**
	 * @param providerId the 'providerId' value to set
	 */
	public void setProviderId(URI providerId) {
		this._providerId = providerId;
	}

	/**
	 * @return the 'providerType' value
	 */
	public URI getProviderType() {
		return this._providerType;
	}

	/**
	 * @param providerType the 'providerType' value to set
	 */
	public void setProviderType(URI providerType) {
		this._providerType = providerType;
	}

	/**
	 * @return the 'dataSourceId' value
	 */
	public URI getDataSourceId() {
		return this._dataSourceId;
	}

	/**
	 * @param dataSourceId the 'dataSourceId' value to set
	 */
	public void setDataSourceId(URI dataSourceId) {
		this._dataSourceId = dataSourceId;
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
	 * @return the 'providedType' value
	 */
	public String getProvidedType() {
		return this._providedType;
	}

	/**
	 * @param providedType the 'providedType' value to set
	 */
	public void setProvidedType(String providedType) {
		this._providedType = providedType;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this._dataSourceId == null) ? 0 : this._dataSourceId.hashCode());
		result = prime * result + ((this._description == null) ? 0 : this._description.hashCode());
		result = prime * result + ((this._providerId == null) ? 0 : this._providerId.hashCode());
		result = prime * result + ((this._providedType == null) ? 0 : this._providedType.hashCode());
		result = prime * result + ((this._providerType == null) ? 0 : this._providerType.hashCode());
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
		DataProvider other = (DataProvider) obj;
		if (this._dataSourceId == null) {
			if (other._dataSourceId != null)
				return false;
		} else if (!this._dataSourceId.equals(other._dataSourceId))
			return false;
		if (this._description == null) {
			if (other._description != null)
				return false;
		} else if (!this._description.equals(other._description))
			return false;
		if (this._providerId == null) {
			if (other._providerId != null)
				return false;
		} else if (!this._providerId.equals(other._providerId))
			return false;
		if (this._providedType == null) {
			if (other._providedType != null)
				return false;
		} else if (!this._providedType.equals(other._providedType))
			return false;
		if (this._providerType == null) {
			if (other._providerType != null)
				return false;
		} else if (!this._providerType.equals(other._providerType))
			return false;
		if (this._version == null) {
			if (other._version != null)
				return false;
		} else if (!this._version.equals(other._version))
			return false;
		return true;
	}
}
