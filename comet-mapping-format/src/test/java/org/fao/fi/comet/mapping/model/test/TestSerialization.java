/**
 * (c) 2014 FAO / UN (project: comet-mapping-format)
 */
package org.fao.fi.comet.mapping.model.test;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;

import org.fao.fi.comet.mapping.model.MappingData;
import org.fao.fi.comet.mapping.model.test.support.GenericTerm;
import org.fao.fi.comet.mapping.model.test.support.mock.GenericTermMappingDataMock;
import org.junit.Test;

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
public class TestSerialization {
	@Test
	public void serializeWithDependencies() throws Throwable {
		MappingData data = GenericTermMappingDataMock.newInstance();
		
		JAXBContext ctx = JAXBContext.newInstance(MappingData.class, GenericTerm.class);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		ctx.createMarshaller().marshal(data, baos);
		
		System.out.println("Serialized with deps: " + new String(baos.toByteArray(), "UTF-8"));
	}
	
	@Test
	public void serializeWithoutDependencies() throws Throwable {
		MappingData data = GenericTermMappingDataMock.newInstance();
		
		JAXBContext ctx = JAXBContext.newInstance(MappingData.class);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		ctx.createMarshaller().marshal(data, baos);
		
		System.out.println("Serialized without deps: " + new String(baos.toByteArray(), "UTF-8"));
	}
	
	@Test
	public void roundtripWithDependencies() throws Throwable {
		MappingData data = GenericTermMappingDataMock.newInstance();
		
		JAXBContext ctxMarshall = JAXBContext.newInstance(MappingData.class, GenericTerm.class);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		ctxMarshall.createMarshaller().marshal(data, baos);
		
		String xml = new String(baos.toByteArray(), "UTF-8");
		
		System.out.println("Serialized with deps: " + xml);
		
		JAXBContext ctxUnmarshall = JAXBContext.newInstance(MappingData.class, GenericTerm.class);
		
		MappingData deserialized = (MappingData)ctxUnmarshall.createUnmarshaller().unmarshal(new StringReader(xml));
		
		System.out.println(deserialized);
	}
	
	@Test
	public void roundtripWithoutDependencies() throws Throwable {
		MappingData data = GenericTermMappingDataMock.newInstance();
		
		JAXBContext ctxMarshall = JAXBContext.newInstance(MappingData.class);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		ctxMarshall.createMarshaller().marshal(data, baos);
		
		String xml = new String(baos.toByteArray(), "UTF-8");
		
		System.out.println("Serialized without deps: " + xml);
		
		JAXBContext ctxUnmarshall = JAXBContext.newInstance(MappingData.class);
		ctxUnmarshall.createUnmarshaller().unmarshal(new StringReader(xml));
	}
}
