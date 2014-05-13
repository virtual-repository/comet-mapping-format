/**
 * (c) 2014 FAO / UN (project: comet-mapping-format)
 */
package org.fao.fi.comet.mapping.dsl;

import java.net.URI;

import org.fao.fi.comet.mapping.model.MappingElementIdentifier;

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
public class MappingElementIdentifierDSL {
	final static public MappingElementIdentifier identifier(MappingElementIdentifier elementId) {
		return new MappingElementIdentifier(elementId.getElementId());
	}

	final static public MappingElementIdentifier identifierFor(URI elementId) {
		return new MappingElementIdentifier(elementId);
	}
	
	final static public MappingElementIdentifier identifierFor(String elementIdURI) {
		return MappingElementIdentifierDSL.identifierFor(URI.create(elementIdURI));
	}
}