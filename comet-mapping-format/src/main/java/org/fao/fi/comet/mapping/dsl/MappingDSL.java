/**
 * (c) 2014 FAO / UN (project: comet-mapping-format)
 */
package org.fao.fi.comet.mapping.dsl;

import java.util.ArrayList;

import org.fao.fi.comet.mapping.model.Element;
import org.fao.fi.comet.mapping.model.Mapping;
import org.fao.fi.comet.mapping.model.MappingDetail;

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
public class MappingDSL {
	final static public <S, T> Mapping<S, T> map(Element<S> source, Class<T> targetClazz) {
		return new Mapping<S, T>(source, new ArrayList<MappingDetail<T>>());
	}
}
