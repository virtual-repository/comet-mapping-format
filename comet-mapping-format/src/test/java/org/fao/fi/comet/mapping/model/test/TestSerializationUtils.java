/**
 * (c) 2014 FAO / UN (project: comet-mapping-format)
 */
package org.fao.fi.comet.mapping.model.test;

import org.fao.fi.comet.mapping.model.MappingData;
import org.fao.fi.comet.mapping.model.test.support.mock.GenericTermMappingDataMock;
import org.fao.fi.comet.mapping.model.utils.jaxb.JAXBDeSerializationUtils;
import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;

/**
 * Place your class / interface description here.
 *
 * History:
 *
 * ------------- --------------- -----------------------
 * Date			 Author			 Comment
 * ------------- --------------- -----------------------
 * 6 May 2014   Fiorellato     Creation.
 *
 * @version 1.0
 * @since 6 May 2014
 */
public class TestSerializationUtils {
	@Test public void testSerializeToXML() throws Throwable {
		MappingData data = GenericTermMappingDataMock.newInstance();
		
		String XML = JAXBDeSerializationUtils.toXML(data).replaceAll("\r|\n", "");
		
		MappingData rebuilt = JAXBDeSerializationUtils.fromXML(XML);
		
		String rXML = JAXBDeSerializationUtils.toXML(rebuilt).replaceAll("\r|\n", "");
		
		Assert.assertEquals(XML, rXML);
	}
	
	@Test public void testSerializeToDOM() throws Throwable {
		MappingData data = GenericTermMappingDataMock.newInstance();
		
		String XML = JAXBDeSerializationUtils.toXML(data).replaceAll("\r|\n", "");
		
		Document dom = JAXBDeSerializationUtils.toDocument(data);
		
		MappingData rebuilt = JAXBDeSerializationUtils.fromDocument(dom);
		
		String rXML = JAXBDeSerializationUtils.toXML(rebuilt).replaceAll("\r|\n", "");
		
		Assert.assertEquals(XML, rXML);
	}
}
