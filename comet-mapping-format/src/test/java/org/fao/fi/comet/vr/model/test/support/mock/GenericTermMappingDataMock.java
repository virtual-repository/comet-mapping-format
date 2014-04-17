/**
 * (C) 2014 by FAO / UN (project: comet-mapping-format)
 */
package org.fao.fi.comet.vr.model.test.support.mock;

import java.util.ArrayList;
import java.util.Collection;

import org.fao.fi.comet.vr.model.Element;
import org.fao.fi.comet.vr.model.ElementIdentifier;
import org.fao.fi.comet.vr.model.Mapping;
import org.fao.fi.comet.vr.model.MappingData;
import org.fao.fi.comet.vr.model.MappingDetail;
import org.fao.fi.comet.vr.model.test.support.GenericTerm;
import static org.fao.fi.comet.vr.model.Element.*;
import static org.fao.fi.comet.vr.model.ElementIdentifier.*;
/**
 * Place your class / interface description here.
 *
 * History:
 *
 * ------------- --------------- -----------------------
 * Date			 Author			 Comment
 * ------------- --------------- -----------------------
 * 17/apr/2014   Fabio     Creation.
 *
 * @version 1.0
 * @since 17/apr/2014
 */
public class GenericTermMappingDataMock extends MappingData<GenericTerm, GenericTerm> {
	private GenericTermMappingDataMock() {
		super();
	}
	
	final static MappingData<GenericTerm, GenericTerm> newInstance() {
		Element<GenericTerm> eLeft1   = wrap(GenericTerm.describing("over-exploited")).with(identifier("fooResourceStatus", "1"));
        Element<GenericTerm> eRight11 = wrap(GenericTerm.describing("overexploited")).with(identifier("barResourceStatus", "69"));
        Element<GenericTerm> eRight12 = wrap(GenericTerm.describing("ov-erexploited")).with(identifier("barResourceStatus", "96"));
        
        Element<GenericTerm> eLeft2   = wrap(GenericTerm.describing("under-exploited")).with(identifier("fooResourceStatus", "2"));
        Element<GenericTerm> eRight21 = wrap(GenericTerm.describing("underexploited")).with(identifier("barResourceStatus", "70"));

        Element<GenericTerm> eRight22 = wrap(GenericTerm.describing("und-erexploited")).with(identifier("barResourceStatus", "97"));
        Element<GenericTerm> eRight23 = wrap(GenericTerm.describing("un-derexploited")).with(identifier("barResourceStatus", "98"));

        Collection<MappingDetail<GenericTerm>> leftMappings1 = new ArrayList<MappingDetail<GenericTerm>>();
        leftMappings1.add(new MappingDetail<GenericTerm>(0.99, eRight11));
        leftMappings1.add(new MappingDetail<GenericTerm>(0.69, eRight12));

        Collection<MappingDetail<GenericTerm>> leftMappings2 = new ArrayList<MappingDetail<GenericTerm>>();
        leftMappings2.add(new MappingDetail<GenericTerm>(0.99, eRight21));
        leftMappings2.add(new MappingDetail<GenericTerm>(0.69, eRight22));
        leftMappings2.add(new MappingDetail<GenericTerm>(0.39, eRight23));

        Mapping<GenericTerm, GenericTerm> mapping1 = new Mapping<GenericTerm, GenericTerm>(eLeft1, leftMappings1);
        Mapping<GenericTerm, GenericTerm> mapping2 = new Mapping<GenericTerm, GenericTerm>(eLeft2, leftMappings2);
        
        Collection<Mapping<GenericTerm, GenericTerm>> mappings = new ArrayList<Mapping<GenericTerm, GenericTerm>>();
        mappings.add(mapping1);
        mappings.add(mapping2);
        
        MappingData<GenericTerm, GenericTerm> mappingData = new MappingData<GenericTerm, GenericTerm>();
        mappingData.setMappings(mappings);
        
        return mappingData;
	}
}
