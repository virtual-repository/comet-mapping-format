/**
 * (c) 2014 FAO / UN (project: comet-mapping-format)
 */
package org.fao.fi.comet.mapping.model.utils;

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
	static public Element toElement(Object data) throws JAXBException {
		if(data == null)
			return null;
		
		//Check whether DOMResult and Marshaller are stateless and thread safe, in order to replace
		//their instantiation with singletons...
		DOMResult domResult = new DOMResult();
		Marshaller marshaller = JAXBContext.newInstance(data.getClass()).createMarshaller();
		
		marshaller.marshal(data, domResult);
		
		return ((Document)domResult.getNode()).getDocumentElement();
	}
}
