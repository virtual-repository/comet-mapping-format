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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
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
@XmlType(name="Mapping")
@XmlAccessorType(XmlAccessType.FIELD)
public class Mapping implements Serializable {
	/** Field serialVersionUID */
	private static final long serialVersionUID = 6031559793227240424L;
	
	@XmlElement(name="SourceElement")
	private MappingElement _source;
	
	@XmlElementWrapper(name="TargetElementMappings")
	@XmlElement(name="MappingDetail")
	private Collection<MappingDetail> _targets;
	
	/**
	 * Class constructor
	 *
	 */
	public Mapping() {
		super();
	}
	
	/**
	 * Class constructor
	 *
	 * @param source
	 * @param targets
	 */
	public Mapping(MappingElement source, Collection<MappingDetail> targets) {
		super();
		this._source = source;
		this._targets = targets;
	}
	
	/**
	 * @return the 'source' value
	 */
	public final MappingElement getSource() {
		return this._source;
	}
	
	/**
	 * @param source the 'source' value to set
	 */
	public final void setSource(MappingElement source) {
		this._source = source;
	}
	
	/**
	 * @return the 'targets' value
	 */
	public final Collection<MappingDetail> getTargets() {
		return this._targets;
	}
	
	/**
	 * @param targets the 'targets' value to set
	 */
	public final void setTargets(Collection<MappingDetail> targets) {
		this._targets = targets;
	}
	
	public final Mapping to(MappingDetail target) {
		return this.andTo(target);
	}

	public final Mapping to(MappingDetail... targets) {
		return this.andTo(targets);
	}
	
	public final Mapping andTo(MappingDetail target) {
		return this.andTo(new MappingDetail[] { target });
	}
	
	public final Mapping andTo(MappingDetail... targets) {
		if(this._targets == null)
			this._targets = new ArrayList<MappingDetail>();
		
		this._targets.addAll(Arrays.asList(targets));
		
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this._source == null) ? 0 : this._source.hashCode());
		result = prime * result + ((this._targets == null) ? 0 : this._targets.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		Mapping other = (Mapping) obj;
		if (this._source == null) {
			if (other._source != null)
				return false;
		} else if (!this._source.equals(other._source))
			return false;
		if (this._targets == null) {
			if (other._targets != null)
				return false;
		} else if (!this._targets.equals(other._targets))
			return false;
		return true;
	}
}
