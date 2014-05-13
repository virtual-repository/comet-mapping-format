/**
 * (c) 2014 FAO / UN (project: comet-mapping-format)
 */
package org.fao.fi.comet.mapping.dsl;

import java.net.URI;

import org.fao.fi.comet.mapping.model.DataProvider;

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
public class DataProviderDSL {
	final static public DataProvider provider(URI identifier) {
		DataProvider provider = new DataProvider();
		provider.setProviderId(identifier);
		return provider;
	}
	
	final static public DataProvider provider(String identifierURI) {
		return provider(URI.create(identifierURI));
	}
	
	final static public DataProvider provider(String identifierURI, String dataSourceIdentifierURI) {
		return DataProviderDSL.provider(identifierURI, dataSourceIdentifierURI, null);
	}
	
	final static public DataProvider provider(String identifierURI, String dataSourceIdentifierURI, String version) {
		return DataProviderDSL.provider(URI.create(identifierURI), (URI)null, URI.create(dataSourceIdentifierURI), version);
	}
	
	final static public DataProvider provider(String identifierURI, String providedTypeURI, String dataSourceIdentifierURI, String version) {
		return new DataProvider(URI.create(identifierURI), URI.create(dataSourceIdentifierURI), version, URI.create(providedTypeURI));
	}
	
	final static public DataProvider provider(URI identifier, URI dataSourceIdentifier, String version) {
		return new DataProvider(identifier, dataSourceIdentifier, version, null);
	}
	
	final static public DataProvider provider(URI identifier, URI providedType, URI dataSourceIdentifier, String version) {
		return new DataProvider(identifier, dataSourceIdentifier, version, providedType);
	}
	
	final static public DataProvider provider(URI identifier, URI providedType, URI dataSourceIdentifier) {
		return new DataProvider(identifier, dataSourceIdentifier, null, providedType);
	}
}
