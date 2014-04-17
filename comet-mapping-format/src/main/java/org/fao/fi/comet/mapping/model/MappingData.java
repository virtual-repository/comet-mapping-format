/**
 * (c) 2014 FAO / UN (project: comet-core-vr-model)
 */
package org.fao.fi.comet.mapping.model;

import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 * 11 Apr 2014   Fiorellato     Creation.
 *
 * @version 1.0
 * @since 11 Apr 2014
 */
@XmlRootElement(name="MappingData")
@XmlAccessorType(XmlAccessType.FIELD)
public class MappingData<SOURCE, TARGET> implements Serializable {
	/** Field serialVersionUID */
	private static final long serialVersionUID = 5556836524367681531L;
	
	@XmlAttribute(name="on") private Date _producedOn;
	@XmlAttribute(name="producedBy") private String _producedBy;
	@XmlAttribute(name="version") private String _version;
	@XmlAttribute(name="id") private URI _identifier;
	
	@XmlElement(name="Description")
	private String _description;
	
	@XmlElement(name="ProcessConfiguration")
	private ProcessConfiguration _processConfiguration;
	
	@XmlElementWrapper(name="Matchers")
	@XmlElement(name="MatcherConfiguration")
	private Collection<MatcherConfiguration> _matcherConfiguration;
	
	@XmlElement(name="Mapping")
	private Collection<Mapping<SOURCE, TARGET>> _mappings;

	/**
	 * Class constructor
	 */
	public MappingData() {
		super();
	}

	/**
	 * @return the 'identifier' value
	 */
	public URI getIdentifier() {
		return this._identifier;
	}

	/**
	 * @param identifier the 'identifier' value to set
	 */
	public void setIdentifier(URI identifier) {
		this._identifier = identifier;
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
	 * @return the 'producedBy' value
	 */
	public String getProducedBy() {
		return this._producedBy;
	}

	/**
	 * @param producedBy the 'producedBy' value to set
	 */
	public void setProducedBy(String producedBy) {
		this._producedBy = producedBy;
	}

	/**
	 * @return the 'producedOn' value
	 */
	public Date getProducedOn() {
		return this._producedOn;
	}

	/**
	 * @param producedOn the 'producedOn' value to set
	 */
	public void setProducedOn(Date producedOn) {
		this._producedOn = producedOn;
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
	 * @return the 'matcherConfiguration' value
	 */
	public Collection<MatcherConfiguration> getMatcherConfiguration() {
		return this._matcherConfiguration;
	}

	/**
	 * @param matcherConfiguration the 'matcherConfiguration' value to set
	 */
	public void setMatcherConfiguration(Collection<MatcherConfiguration> matcherConfiguration) {
		this._matcherConfiguration = matcherConfiguration;
	}

	/**
	 * @return the 'mappings' value
	 */
	public Collection<Mapping<SOURCE, TARGET>> getMappings() {
		return this._mappings;
	}

	/**
	 * @param mappings the 'mappings' value to set
	 */
	public void setMappings(Collection<Mapping<SOURCE, TARGET>> mappings) {
		this._mappings = mappings;
	}
	
	public MappingData<SOURCE, TARGET> id(URI identifier) {
		this._identifier = identifier;
		
		return this;
	} 
	
	public MappingData<SOURCE, TARGET> version(String version) {
		this._version = version;
		
		return this;
	}
	
	public MappingData<SOURCE, TARGET> producedBy(String producer) {
		this._producedBy = producer;
		
		return this;
	}
	
	public MappingData<SOURCE, TARGET> on(Date date) {
		this._producedOn = date;
		
		return this;
	}
	
	public MappingData<SOURCE, TARGET> linking(DataProvider source) {
		if(this._processConfiguration == null)
			this._processConfiguration = new ProcessConfiguration();
		
		this._processConfiguration.setSourceDataProvider(source);
		
		return this;
	}
	
	public MappingData<SOURCE, TARGET> to(DataProvider target) {
		if(this._processConfiguration == null)
			this._processConfiguration = new ProcessConfiguration();
		
		this._processConfiguration.setTargetDataProvider(target);
		
		return this;
	}
	
	public MappingData<SOURCE, TARGET> with(double minimumScore, int maximumNumberOfCandidates) {
		if(this._processConfiguration == null)
			this._processConfiguration = new ProcessConfiguration();
		
		this._processConfiguration.setMinimumScore(minimumScore);
		this._processConfiguration.setMaximumNumberOfCandidates(maximumNumberOfCandidates);
		
		return this;
	}
	
	public MappingData<SOURCE, TARGET> through(MatcherConfiguration... matchers) {
		this._matcherConfiguration = Arrays.asList(matchers);
		
		return this;
	}
	
	@SuppressWarnings("unchecked")
	public MappingData<SOURCE, TARGET> including(Mapping<SOURCE, TARGET> mapping) {
		return this.include(new Mapping[] { mapping });
	}
	
	public MappingData<SOURCE, TARGET> include(Mapping<SOURCE, TARGET>... mappings) {
		if(this._mappings == null)
			this._mappings = new ArrayList<Mapping<SOURCE, TARGET>>();
		
		this._mappings.addAll(Arrays.asList(mappings));
		
		return this;
	}
	
	//Move the following four methods elsewhere?
	public Collection<MappingDetail<TARGET>> mappingsFor(Element<SOURCE> source) {
		Collection<MappingDetail<TARGET>> found = new ArrayList<MappingDetail<TARGET>>();
		
		final ElementIdentifier toFind = source.getId();
		
		if(this._mappings != null) {
			for(Mapping<SOURCE, TARGET> in : this._mappings)
				if(toFind.equals(in.getSource().getId()))
					found.addAll(in.getTargets());
		}
		
		return found;
	}
	
	//Move the following two methods elsewhere?
	public Collection<ElementIdentifier> mappingsFor(final ElementIdentifier sourceIdentifier) {
		Collection<ElementIdentifier> found = new ArrayList<ElementIdentifier>();
		
		if(this._mappings != null) {
			for(Mapping<SOURCE, TARGET> in : this._mappings)
				if(sourceIdentifier.equals(in.getSource().getId())) {
					for(MappingDetail<TARGET> of : in.getTargets())
						found.add(of.getTargetElement().getId());
				}
		}
		
		return found;
	}
	
	public boolean areMapped(ElementIdentifier source, final ElementIdentifier target) {
		for(ElementIdentifier in : this.mappingsFor(source)) {
			if(target.equals(in))
				return true;
		}
		
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this._description == null) ? 0 : this._description.hashCode());
		result = prime * result + ((this._identifier == null) ? 0 : this._identifier.hashCode());
		result = prime * result + ((this._mappings == null) ? 0 : this._mappings.hashCode());
		result = prime * result + ((this._matcherConfiguration == null) ? 0 : this._matcherConfiguration.hashCode());
		result = prime * result + ((this._processConfiguration == null) ? 0 : this._processConfiguration.hashCode());
		result = prime * result + ((this._producedBy == null) ? 0 : this._producedBy.hashCode());
		result = prime * result + ((this._producedOn == null) ? 0 : this._producedOn.hashCode());
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
		@SuppressWarnings("rawtypes")
		MappingData other = (MappingData) obj;
		if (this._description == null) {
			if (other._description != null)
				return false;
		} else if (!this._description.equals(other._description))
			return false;
		if (this._identifier == null) {
			if (other._identifier != null)
				return false;
		} else if (!this._identifier.equals(other._identifier))
			return false;
		if (this._mappings == null) {
			if (other._mappings != null)
				return false;
		} else if (!this._mappings.equals(other._mappings))
			return false;
		if (this._matcherConfiguration == null) {
			if (other._matcherConfiguration != null)
				return false;
		} else if (!this._matcherConfiguration.equals(other._matcherConfiguration))
			return false;
		if (this._processConfiguration == null) {
			if (other._processConfiguration != null)
				return false;
		} else if (!this._processConfiguration.equals(other._processConfiguration))
			return false;
		if (this._producedBy == null) {
			if (other._producedBy != null)
				return false;
		} else if (!this._producedBy.equals(other._producedBy))
			return false;
		if (this._producedOn == null) {
			if (other._producedOn != null)
				return false;
		} else if (!this._producedOn.equals(other._producedOn))
			return false;
		if (this._version == null) {
			if (other._version != null)
				return false;
		} else if (!this._version.equals(other._version))
			return false;
		return true;
	}
}
