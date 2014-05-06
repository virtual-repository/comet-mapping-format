/**
 * (c) 2014 FAO / UN (project: comet-mapping-format)
 */
package org.fao.fi.comet.mapping.dsl;

import java.net.URI;
import java.net.URISyntaxException;

import org.fao.fi.comet.mapping.model.MappingContribution;

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
public class MappingContributionDSL {
	final static public MappingContribution matcher(URI matcherId) {
		return new MappingContribution(matcherId, 0D, null);
	}
	
	final static public MappingContribution matcher(String matcherIdURI) {
		try {
			return MappingContributionDSL.matcher(new URI(matcherIdURI));
		} catch (URISyntaxException USe) {
			throw new IllegalArgumentException("Bad format for URI " + matcherIdURI + ": " + USe.getMessage(), USe);
		}
	}
}
