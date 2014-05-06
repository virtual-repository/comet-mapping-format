/**
 * (c) 2014 FAO / UN (project: comet-mapping-format)
 */
package org.fao.fi.comet.mapping.dsl;

import java.net.URI;

import org.fao.fi.comet.mapping.model.MappingElement;
import org.fao.fi.comet.mapping.model.MappingElementIdentifier;
import org.fao.fi.comet.mapping.model.utils.jaxb.JAXB2DOMUtils;
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
	
	final static public MappingElement wrap(String providerIdURI, String elementIdURI, Element data) {
		return MappingElementDSL.wrap(URI.create(providerIdURI), URI.create(elementIdURI), data);
	}

	final static public MappingElement wrap(Element data) {
		return new MappingElement().wrapping(data);
	}
	
	final static public MappingElement wrap(MappingElementIdentifier elementIdentifier, Object data) {
		return new MappingElement().with(elementIdentifier).wrapping(JAXB2DOMUtils.toElement(data));
	}
	
	final static public MappingElement wrap(String providerIdURI, String elementIdURI, Object data) {
		return MappingElementDSL.wrap(URI.create(providerIdURI), URI.create(elementIdURI), data);
	}
	
	final static public MappingElement wrap(URI providerId, URI elementId, Object data) {
		return new MappingElement().with(providerId, elementId).wrapping(JAXB2DOMUtils.toElement(data));
	}

	final static public MappingElement wrap(Object data) {
		return new MappingElement().wrapping(JAXB2DOMUtils.toElement(data));
	}
}
