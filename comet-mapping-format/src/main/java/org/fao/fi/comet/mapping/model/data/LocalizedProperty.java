/**
 * (c) 2014 FAO / UN (project: comet-mapping-format)
 */
package org.fao.fi.comet.mapping.model.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

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
@XmlType(name="LocalizedProperty")
@XmlAccessorType(XmlAccessType.FIELD)
public class LocalizedProperty extends Property {
	/** Field serialVersionUID */
	private static final long serialVersionUID = -6887342784737790644L;
	
	@XmlAttribute(name="lang", required=true)
	private String _lang;

	/**
	 * Class constructor
	 *
	 */
	public LocalizedProperty() {
		super();
	}

	/**
	 * Class constructor
	 *
	 * @param name
	 * @param type
	 * @param value
	 * @param lang
	 */
	public LocalizedProperty(String name, String type, String value, String lang) {
		super(name, type, value);
		this._lang = lang;
	}

	/**
	 * @return the 'lang' value
	 */
	public String getLang() {
		return this._lang;
	}

	/**
	 * @param lang the 'lang' value to set
	 */
	public void setLang(String lang) {
		this._lang = lang;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((this._lang == null) ? 0 : this._lang.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocalizedProperty other = (LocalizedProperty) obj;
		if (this._lang == null) {
			if (other._lang != null)
				return false;
		} else if (!this._lang.equals(other._lang))
			return false;
		return true;
	}
}
