/**
 * (c) 2014 FAO / UN (project: comet-mapping-format)
 */
package org.fao.fi.comet.mapping.dsl;

import java.net.URI;
import java.net.URISyntaxException;

import org.fao.fi.comet.mapping.model.DataProvider;
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
	final static public MappingElementIdentifier identifier(MappingElementIdentifier elementIdentifier) {
		return new MappingElementIdentifier(elementIdentifier.getProviderId(), elementIdentifier.getElementId());
	}

	final static public MappingElementIdentifier identifier(URI providerId, URI elementId) {
		return new MappingElementIdentifier(providerId, elementId);
	}
	
	final static public MappingElementIdentifier identifier(String providerIdURI, String elementIdURI) {
		URI providerId, elementId;
		
		try {
			providerId = new URI(providerIdURI);
		} catch(URISyntaxException USe) {
			throw new IllegalArgumentException("Bad format for URI " + providerIdURI + ": " + USe.getMessage(), USe);
		}
		
		try {
			elementId = new URI(elementIdURI);
		} catch(URISyntaxException USe) {
			throw new IllegalArgumentException("Bad format for URI " + elementIdURI + ": " + USe.getMessage(), USe);
		}
		
		return new MappingElementIdentifier(providerId, elementId);
	}
	
	final static public MappingElementIdentifier identifierFor(DataProvider provider, URI elementId) {
		return new MappingElementIdentifier(provider.getIdentifier(), elementId);
	}
	
	final static public MappingElementIdentifier identifierFor(DataProvider provider, String elementIdURI) {
		try {
			return MappingElementIdentifierDSL.identifier(provider.getIdentifier(), new URI(elementIdURI));
		} catch(URISyntaxException USe) {
			throw new IllegalArgumentException("Bad format for URI " + elementIdURI + ": " + USe.getMessage(), USe);
		}
	}
}
