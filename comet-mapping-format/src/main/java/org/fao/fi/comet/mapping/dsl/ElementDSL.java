/**
 * (c) 2014 FAO / UN (project: comet-mapping-format)
 */
package org.fao.fi.comet.mapping.dsl;

import org.fao.fi.comet.mapping.model.Element;
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
public class ElementDSL {
	final static public <T> Element<T> wrap(ElementIdentifier elementIdentifier, T data) {
		return new Element<T>().with(elementIdentifier).wrapping(data);
	}

	final static public <T> Element<T> wrap(String providerId, String elementId, T data) {
		return new Element<T>().with(providerId, elementId).wrapping(data);
	}

	final static public <T> Element<T> wrap(T data) {
		return new Element<T>().wrapping(data);
	}
}
