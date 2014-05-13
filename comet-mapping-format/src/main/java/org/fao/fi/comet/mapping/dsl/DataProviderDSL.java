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
	final static public DataProvider provider(String identifierURI, String typeURI, String dataSourceIdentifierURI) {
		return DataProviderDSL.provider(identifierURI, dataSourceIdentifierURI, null);
	}
	
	final static public DataProvider provider(String identifierURI, String typeURI, String dataSourceIdentifierURI, String version) {
		return DataProviderDSL.provider(URI.create(identifierURI), URI.create(typeURI), URI.create(dataSourceIdentifierURI), version, (URI)null);
	}
	
	final static public DataProvider provider(String identifierURI, String typeURI, String dataSourceIdentifierURI, String version, String providedTypeURI) {
		return new DataProvider(URI.create(identifierURI), URI.create(typeURI), URI.create(dataSourceIdentifierURI), version, URI.create(providedTypeURI));
	}
	
	final static public DataProvider provider(URI identifier, URI type, URI dataSourceIdentifier, String version) {
		return new DataProvider(identifier, type, dataSourceIdentifier, version, null);
	}
	
	final static public DataProvider provider(URI identifier, URI type, URI dataSourceIdentifier, String version, URI providedType) {
		return new DataProvider(identifier, type, dataSourceIdentifier, version, providedType);
	}
	
	final static public DataProvider provider(URI identifier, URI type, URI dataSourceIdentifier, URI providedType) {
		return new DataProvider(identifier, type, dataSourceIdentifier, null, providedType);
	}
}
