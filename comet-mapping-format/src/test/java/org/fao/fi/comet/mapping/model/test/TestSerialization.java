/**
 * (c) 2014 FAO / UN (project: comet-mapping-format)
 */
package org.fao.fi.comet.mapping.model.test;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;

import org.fao.fi.comet.mapping.model.Mapping;
import org.fao.fi.comet.mapping.model.MappingData;
import org.fao.fi.comet.mapping.model.MappingDetail;
import org.fao.fi.comet.mapping.model.test.support.GenericTerm;
import org.fao.fi.comet.mapping.model.test.support.mock.GenericTermMappingDataMock;
import org.junit.Assert;
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
		
		for(Mapping in : deserialized.getMappings()) {
			Assert.assertNotNull(in.getSource().getData());
			Assert.assertTrue(org.w3c.dom.Element.class.isAssignableFrom(in.getSource().getData().getClass()));
			
			for(MappingDetail targets : in.getTargets()) {
				Assert.assertNotNull(targets.getTargetElement().getData());
				Assert.assertTrue(org.w3c.dom.Element.class.isAssignableFrom(targets.getTargetElement().getData().getClass()));
			}
		}
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
		
		MappingData deserialized = (MappingData)ctxUnmarshall.createUnmarshaller().unmarshal(new StringReader(xml));
		
		for(Mapping in : deserialized.getMappings()) {
			Assert.assertNotNull(in.getSource().getData());
			Assert.assertTrue(org.w3c.dom.Element.class.isAssignableFrom(in.getSource().getData().getClass()));
			
			for(MappingDetail targets : in.getTargets()) {
				Assert.assertNotNull(targets.getTargetElement().getData());
				Assert.assertTrue(org.w3c.dom.Element.class.isAssignableFrom(targets.getTargetElement().getData().getClass()));
			}
		}
	}
	
	@Test
	public void roundtripWithNilsAndNoDeps() throws Throwable {
		MappingData data = GenericTermMappingDataMock.newInstanceWithNils();
		
		JAXBContext ctxMarshall = JAXBContext.newInstance(MappingData.class);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		ctxMarshall.createMarshaller().marshal(data, baos);
		
		String xml = new String(baos.toByteArray(), "UTF-8");
		
		System.out.println("Serialized without deps: " + xml);
		
		JAXBContext ctxUnmarshall = JAXBContext.newInstance(MappingData.class);
		ctxUnmarshall.createUnmarshaller().unmarshal(new StringReader(xml));
		
		MappingData deserialized = (MappingData)ctxUnmarshall.createUnmarshaller().unmarshal(new StringReader(xml));
		
		for(Mapping in : deserialized.getMappings()) {
			Assert.assertNull(in.getSource().getData());
			
			for(MappingDetail targets : in.getTargets()) {
				Assert.assertNull(targets.getTargetElement().getData());
			}
		}
	}
	
	@Test
	public void roundtripWithNilsAndDeps() throws Throwable {
		MappingData data = GenericTermMappingDataMock.newInstanceWithNils();
		
		JAXBContext ctxMarshall = JAXBContext.newInstance(MappingData.class, GenericTerm.class);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		ctxMarshall.createMarshaller().marshal(data, baos);
		
		String xml = new String(baos.toByteArray(), "UTF-8");
		
		System.out.println("Serialized without deps: " + xml);
		
		JAXBContext ctxUnmarshall = JAXBContext.newInstance(MappingData.class, GenericTerm.class);
		ctxUnmarshall.createUnmarshaller().unmarshal(new StringReader(xml));
		
		MappingData deserialized = (MappingData)ctxUnmarshall.createUnmarshaller().unmarshal(new StringReader(xml));
		
		for(Mapping in : deserialized.getMappings()) {
			Assert.assertNull(in.getSource().getData());
			
			for(MappingDetail targets : in.getTargets()) {
				Assert.assertNull(targets.getTargetElement().getData());
			}
		}
	}
}
