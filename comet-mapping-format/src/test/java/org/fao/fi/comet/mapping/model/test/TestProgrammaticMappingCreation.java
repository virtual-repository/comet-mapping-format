/**
 * (c) 2014 FAO / UN (project: comet-mapping-format)
 */
package org.fao.fi.comet.mapping.model.test;

import static org.fao.fi.comet.mapping.dsl.MappingDSL.map;
import static org.fao.fi.comet.mapping.dsl.MappingDetailDSL.target;
import static org.fao.fi.comet.mapping.dsl.MappingElementDSL.wrap;
import static org.fao.fi.comet.mapping.dsl.MappingElementIdentifierDSL.identifierFor;
import static org.fao.fi.comet.mapping.model.utils.jaxb.JAXB2DOMUtils.asElement;

import java.util.ArrayList;
import java.util.Collection;

import org.fao.fi.comet.mapping.model.Mapping;
import org.fao.fi.comet.mapping.model.MappingData;
import org.fao.fi.comet.mapping.model.MappingDetail;
import org.fao.fi.comet.mapping.model.MappingElement;
import org.fao.fi.comet.mapping.model.test.support.GenericTerm;
import org.fao.fi.comet.mapping.model.utils.jaxb.JAXBDeSerializationUtils;
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
 * 21 May 2014   Fiorellato     Creation.
 *
 * @version 1.0
 * @since 21 May 2014
 */
public class TestProgrammaticMappingCreation {
	@Test
	public void testCreationWithDSL() {
		MappingData mappingData = new MappingData();

		Mapping mappingEntry;

		MappingElement target, source = wrap(asElement(GenericTerm.describing("srcFoo1"))).with(identifierFor("urn:src:foo:1"));

		mappingEntry = map(source);

		for (int i = 0; i < 10; i++) {
			target = wrap(asElement(GenericTerm.describing("trgfoo_" + i))).with(identifierFor("urn:trg:foo:" + i));

			mappingEntry = mappingEntry.to(target(target));
		}

		mappingData.include(mappingEntry);
		
		source = wrap(asElement(GenericTerm.describing("srcFoo2"))).with(identifierFor("urn:src:foo:2"));
		
		mappingEntry = map(source);

		for (int i = 0; i < 8; i++) {
			target = wrap(asElement(GenericTerm.describing("trgfoo_" + i))).with(identifierFor("urn:trg:foo:" + i));

			mappingEntry = mappingEntry.to(target(target));
		}

		mappingData.include(mappingEntry);
		
		Mapping[] mappings = mappingData.getMappings().toArray(new Mapping[0]);
		
		Assert.assertEquals(2, mappings.length);
		Assert.assertEquals(10, mappings[0].getTargets().size());
		Assert.assertEquals(8, mappings[1].getTargets().size());
		
		System.out.println(JAXBDeSerializationUtils.toXML(mappingData));
	}
	
	@Test
	public void testCreationWithGettersSetters() {
		MappingData mappingData = new MappingData();
		
		Collection<Mapping> allMappings = new ArrayList<Mapping>();

		mappingData.setMappings(allMappings);
		
		MappingElement target, source = wrap(asElement(GenericTerm.describing("srcFoo1"))).with(identifierFor("urn:src:foo:1"));
		
		Collection<MappingDetail> targetMappingDetails = new ArrayList<MappingDetail>();
		
		MappingDetail detail;
		for (int i = 0; i < 10; i++) {
			detail = new MappingDetail();
			
			target = wrap(asElement(GenericTerm.describing("trgfoo_" + i))).with(identifierFor("urn:trg:foo:" + i));
			detail.setTargetElement(target);
			
			targetMappingDetails.add(detail);
		}
		
		allMappings.add(new Mapping(source, targetMappingDetails));
		
		source = wrap(asElement(GenericTerm.describing("srcFoo2"))).with(identifierFor("urn:src:foo:2"));
		
		targetMappingDetails = new ArrayList<MappingDetail>();

		for (int i = 0; i < 8; i++) {
			detail = new MappingDetail();
			
			target = wrap(asElement(GenericTerm.describing("trgfoo_" + i))).with(identifierFor("urn:trg:foo:" + i));
			detail.setTargetElement(target);
			
			targetMappingDetails.add(detail);
		}
		
		allMappings.add(new Mapping(source, targetMappingDetails));
		
		Mapping[] mappings = mappingData.getMappings().toArray(new Mapping[0]);
		
		Assert.assertEquals(2, mappings.length);
		Assert.assertEquals(10, mappings[0].getTargets().size());
		Assert.assertEquals(8, mappings[1].getTargets().size());
		
		System.out.println(JAXBDeSerializationUtils.toXML(mappingData));
	}
}
