/**
 * (c) 2014 FAO / UN (project: comet-mapping-format)
 */
package org.fao.fi.comet.mapping.model.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.transform.dom.DOMResult;

import org.fao.fi.comet.mapping.model.MappingData;
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
final public class SerializationUtils {
	final static private JAXBContext JAXB_CONTEXT;
	
	static {
		try {
			JAXB_CONTEXT = JAXBContext.newInstance(MappingData.class);
		} catch(JAXBException Je) {
			throw new RuntimeException("Unable to create JAXB Context instance: " + Je.getMessage(), Je);
		}
	}
	
	static public Document toDocument(MappingData mappingData) {
		try {
			DOMResult domResult;
			
			JAXB_CONTEXT.createMarshaller().marshal(mappingData, domResult = new DOMResult());
			
			return (Document)domResult.getNode();
		} catch(Throwable t) {
			throw new RuntimeException("Unable to marshal " + mappingData + ": " + t.getMessage(), t);
		}
	}
	
	static public MappingData fromDocument(Document document) {
		try {
			return JAXB_CONTEXT.createUnmarshaller().unmarshal(document, MappingData.class).getValue();  
		} catch(Throwable t) {
			throw new RuntimeException("Unable to un marshal " + document + ": " + t.getMessage(), t);
		}
	}
	
	static public String toXML(MappingData mappingData) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		try {
			JAXB_CONTEXT.createMarshaller().marshal(mappingData, baos);
			baos.flush();
			
			return new String(baos.toByteArray(), "UTF-8");
		} catch(Throwable t) {
			if(baos != null)
				try {
					baos.close();
				} catch(IOException IOe) {
					throw new RuntimeException("Unable to close byte stream: " + IOe.getMessage(), IOe);
				}
			
			throw new RuntimeException("Unable to marshal " + mappingData + ": " + t.getMessage(), t);
		}
	}
	
	static public MappingData fromXML(String xml) {
		StringReader sr = new StringReader(xml);
		
		try {
			return (MappingData)JAXB_CONTEXT.createUnmarshaller().unmarshal(sr);
		} catch(Throwable t) {
			if(sr != null)
				sr.close();
			
			throw new RuntimeException("Unable to unmarshal " + xml + ": " + t.getMessage(), t);
		}
	}
}
