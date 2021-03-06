/**
 * (c) 2014 FAO / UN (project: comet-mapping-format)
 */
package org.fao.fi.comet.mapping.dsl;

import org.fao.fi.comet.mapping.model.MappingElement;
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
public class MappingDetailDSL {
	final static public MappingDetail target(MappingElement target) {
		MappingDetail mapping = new MappingDetail();
		mapping.setTargetElement(target);
		
		return mapping;
	}
}
