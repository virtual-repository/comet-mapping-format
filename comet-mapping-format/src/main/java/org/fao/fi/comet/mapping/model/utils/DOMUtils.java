/**
 * (c) 2014 FAO / UN (project: comet-mapping-format)
 */
package org.fao.fi.comet.mapping.model.utils;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.dom.DOMResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
public class DOMUtils {
	final static private Map<Class<?>, JAXBContext> JAXB_CONTEXTS_MAP = new HashMap<Class<?>, JAXBContext>();
	final static private Map<Class<?>, Marshaller> MARSHALLERS_MAP = new HashMap<Class<?>, Marshaller>();
	
	final static private JAXBContext contextFor(Class<?> clazz) throws JAXBException {
		JAXBContext context;
		if((context = JAXB_CONTEXTS_MAP.get(clazz)) == null) {
			context = JAXBContext.newInstance(clazz);
			
			JAXB_CONTEXTS_MAP.put(clazz, context);
		}
		
		return context;
	}
	
	final static private Marshaller marshallerFor(Class<?> clazz) throws JAXBException {
		Marshaller marshaller;
		if((marshaller = MARSHALLERS_MAP.get(clazz)) == null) {
			marshaller = contextFor(clazz).createMarshaller();
			
			MARSHALLERS_MAP.put(clazz, marshaller);
		}
		
		return marshaller;
	}
	
	final static private Element marshalToElement(Marshaller marshaller, Object data) throws JAXBException {
		DOMResult domResult;
		
		marshaller.marshal(data, domResult = new DOMResult());
		
		return ((Document)domResult.getNode()).getDocumentElement();
	}
	
	final static public Element toElement(Object data) {
		if(data == null)
			return null;
		
		try {
			return marshalToElement(marshallerFor(data.getClass()), data);
		} catch (JAXBException JAXBe) {
			throw new IllegalArgumentException("Can't marshal (" + data.getClass().getName() + ")" + data + " to org.w3c.dom.Element: " + JAXBe.getMessage(), JAXBe);
		}
	}
}
