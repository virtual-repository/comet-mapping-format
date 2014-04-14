/**
 * (c) 2014 FAO / UN (project: comet-core-vr-model)
 */
package org.fao.fi.comet.vr.model;

import java.io.Serializable;
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
public class Mapping<SOURCE extends Serializable, TARGET extends Serializable> implements Serializable {
	/** Field serialVersionUID */
	private static final long serialVersionUID = 6031559793227240424L;
	
	@XmlElement(name="SourceElement")
	private Element<SOURCE> _source;
	
	@XmlElementWrapper(name="TargetMappings")
	@XmlElement(name="MappingDetail")
	private Collection<MappingDetail<TARGET>> _targets;
	
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
	public Mapping(Element<SOURCE> source, Collection<MappingDetail<TARGET>> targets) {
		super();
		this._source = source;
		this._targets = targets;
	}
	
	/**
	 * @return the 'source' value
	 */
	public final Element<SOURCE> getSource() {
		return this._source;
	}
	
	/**
	 * @param source the 'source' value to set
	 */
	public final void setSource(Element<SOURCE> source) {
		this._source = source;
	}
	
	/**
	 * @return the 'targets' value
	 */
	public final Collection<MappingDetail<TARGET>> getTargets() {
		return this._targets;
	}
	
	/**
	 * @param targets the 'targets' value to set
	 */
	public final void setTargets(Collection<MappingDetail<TARGET>> targets) {
		this._targets = targets;
	}

	/* (non-Javadoc)
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
