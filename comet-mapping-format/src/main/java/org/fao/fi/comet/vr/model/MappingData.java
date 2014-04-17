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
	
//	@XmlElementWrapper(name="Mappings")
	@XmlElement(name="Mapping")
	private Collection<Mapping<SOURCE, TARGET>> _mappings;

	/**
	 * Class constructor
	 *
	 */
	public MappingData() {
		super();
	}

	/**
	 * Class constructor
	 *
	 * @param mappings
	 */
	public MappingData(Collection<Mapping<SOURCE, TARGET>> mappings) {
		super();
		this._mappings = mappings;
	}

	/**
	 * @return the 'mappings' value
	 */
	public final Collection<Mapping<SOURCE, TARGET>> getMappings() {
		return this._mappings;
	}

	/**
	 * @param mappings the 'mappings' value to set
	 */
	public final void setMappings(Collection<Mapping<SOURCE, TARGET>> mappings) {
		this._mappings = mappings;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this._mappings == null) ? 0 : this._mappings.hashCode());
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
		MappingData other = (MappingData) obj;
		if (this._mappings == null) {
			if (other._mappings != null)
				return false;
		} else if (!this._mappings.equals(other._mappings))
			return false;
		return true;
	}
}
