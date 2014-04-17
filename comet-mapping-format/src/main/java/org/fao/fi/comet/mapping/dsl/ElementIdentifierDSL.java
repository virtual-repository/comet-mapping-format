/**
 * (c) 2014 FAO / UN (project: comet-mapping-format)
 */
package org.fao.fi.comet.mapping.dsl;

import org.fao.fi.comet.mapping.model.DataProvider;
import org.fao.fi.comet.mapping.model.ElementIdentifier;

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
public class ElementIdentifierDSL {
	final static public ElementIdentifier identifier(ElementIdentifier elementIdentifier) {
		return new ElementIdentifier(elementIdentifier.getProviderId(), elementIdentifier.getElementId());
	}

	final static public ElementIdentifier identifier(String providerId, String elementId) {
		return new ElementIdentifier(providerId, elementId);
	}
	
	final static public ElementIdentifier identifierFor(DataProvider provider, String elementId) {
		return new ElementIdentifier(provider.getIdentifier(), elementId);
	}
}
