/**
 * (c) 2014 FAO / UN (project: comet-mapping-format)
 */
package org.fao.fi.comet.mapping.dsl;

import org.fao.fi.comet.mapping.model.MatcherConfigurationProperty;

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
public class MatcherConfigurationPropertyDSL {
	final static public MatcherConfigurationProperty configurationProperty(String name, String type, String description, Object value) {
		return new MatcherConfigurationProperty(name, type, description, value);
	}
	
	final static public MatcherConfigurationProperty configurationProperty(String name, String type, Object value) {
		return new MatcherConfigurationProperty(name, type, null, value);
	}
	
	final static public MatcherConfigurationProperty configurationProperty(String name, Object value) {
		return new MatcherConfigurationProperty(name, ( value == null ? Object.class : value.getClass() ).getSimpleName(), null, value);
	}
}
