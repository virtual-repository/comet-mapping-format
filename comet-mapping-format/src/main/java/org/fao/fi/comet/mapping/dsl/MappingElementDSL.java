/**
 * (c) 2014 FAO / UN (project: comet-mapping-format)
 */
package org.fao.fi.comet.mapping.dsl;

import java.net.URI;

import org.fao.fi.comet.mapping.model.MappingElement;
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
public class MappingElementDSL {
	final static public <T> MappingElement<T> wrap(MappingElementIdentifier elementIdentifier, T data) {
		return new MappingElement<T>().with(elementIdentifier).wrapping(data);
	}

	final static public <T> MappingElement<T> wrap(URI providerId, URI elementId, T data) {
		return new MappingElement<T>().with(providerId, elementId).wrapping(data);
	}

	final static public <T> MappingElement<T> wrap(T data) {
		return new MappingElement<T>().wrapping(data);
	}
}
