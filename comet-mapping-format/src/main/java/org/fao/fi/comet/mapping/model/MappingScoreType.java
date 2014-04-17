/**
 * (c) 2014 FAO / UN (project: comet-mapping-format)
 */
package org.fao.fi.comet.mapping.model;

import javax.xml.bind.annotation.XmlEnum;

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
@XmlEnum
public enum MappingScoreType {
	AUTHORITATIVE("AUTHORITATIVE"),
	NON_AUTHORITATIVE("NON_AUTHORITATIVE"),
	NON_PERFORMED("NON_PERFORMED");
	
	String _type;
		
	private MappingScoreType(String type) {
		this._type = type;
	}

	/**
	 * @return the 'type' value
	 */
	public String getType() {
		return this._type;
	}
}