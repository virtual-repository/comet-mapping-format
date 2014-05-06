/**
 * (c) 2014 FAO / UN (project: comet-mapping-format)
 */
package org.fao.fi.comet.mapping.model.utils.jaxb;

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
final public class JAXBDeSerializationUtils {
	final static private JAXBContext MINIMAL_JAXB_CONTEXT;
	
	static {
		try {
			MINIMAL_JAXB_CONTEXT = JAXBContext.newInstance(MappingData.class);
		} catch(JAXBException Je) {
			throw new RuntimeException("Unable to create minimal JAXB Context instance: " + Je.getMessage(), Je);
		}
	}
	
	static public Document toDocument(MappingData mappingData) {
		return JAXBDeSerializationUtils.toDocument(mappingData, MINIMAL_JAXB_CONTEXT);
	}
	
	static public Document toDocument(MappingData mappingData, JAXBContext context) {
		try {
			DOMResult domResult;
			
			context.createMarshaller().marshal(mappingData, domResult = new DOMResult());
			
			return (Document)domResult.getNode();
		} catch(Throwable t) {
			throw new RuntimeException("Unable to marshal " + mappingData + ": " + t.getMessage(), t);
		}
	}
	
	static public MappingData fromDocument(Document document) {
		return JAXBDeSerializationUtils.fromDocument(document, MINIMAL_JAXB_CONTEXT);
	}
	
	static public MappingData fromDocument(Document document, JAXBContext context) {
		try {
			return context.createUnmarshaller().unmarshal(document, MappingData.class).getValue();  
		} catch(Throwable t) {
			throw new RuntimeException("Unable to un marshal " + document + ": " + t.getMessage(), t);
		}
	}
	
	static public String toXML(MappingData mappingData) {
		return JAXBDeSerializationUtils.toXML(mappingData, MINIMAL_JAXB_CONTEXT);
	}
	
	static public String toXML(MappingData mappingData, JAXBContext context) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		try {
			context.createMarshaller().marshal(mappingData, baos);
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
		return JAXBDeSerializationUtils.fromXML(xml, MINIMAL_JAXB_CONTEXT);
	}
	
	static public MappingData fromXML(String xml, JAXBContext context) {
		StringReader sr = new StringReader(xml);
		
		try {
			return (MappingData)context.createUnmarshaller().unmarshal(sr);
		} catch(Throwable t) {
			if(sr != null)
				sr.close();
			
			throw new RuntimeException("Unable to unmarshal " + xml + ": " + t.getMessage(), t);
		}
	}
}
