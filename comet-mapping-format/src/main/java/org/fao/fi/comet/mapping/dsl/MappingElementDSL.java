/**
 * (c) 2014 FAO / UN (project: comet-mapping-format)
 */
package org.fao.fi.comet.mapping.dsl;

import java.net.URI;

import org.fao.fi.comet.mapping.model.MappingElement;
import org.fao.fi.comet.mapping.model.MappingElementIdentifier;
import org.w3c.dom.Element;

/**
 * Place your class / interface description here.
 *
 * History:
 *
 * ------------- --------------- -----------------------
 * Date			 Author			 Comment
 * ------------- --------------- -----------------------
 * 17 Apr 2014  Fiorellato   Creation.
 *
 * @version 1.0
 * @since 17 Apr 2014
 */
public class MappingElementDSL {
	final static public MappingElement wrap(MappingElementIdentifier elementIdentifier, Element data) {
		return new MappingElement().with(elementIdentifier).wrapping(data);
	}

	final static public MappingElement wrap(URI providerId, URI elementId, Element data) {
		return new MappingElement().with(providerId, elementId).wrapping(data);
	}

	final static public MappingElement wrap(Element data) {
		return new MappingElement().wrapping(data);
	}
}
