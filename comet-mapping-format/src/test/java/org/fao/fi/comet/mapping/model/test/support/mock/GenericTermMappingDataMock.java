/**
 * (C) 2014 by FAO / UN (project: comet-mapping-format)
 */
package org.fao.fi.comet.mapping.model.test.support.mock;

import static org.fao.fi.comet.mapping.dsl.MappingElementDSL.wrap;
import static org.fao.fi.comet.mapping.dsl.MappingElementIdentifierDSL.identifierFor;
import static org.fao.fi.comet.mapping.dsl.MappingContributionDSL.matcher;
import static org.fao.fi.comet.mapping.dsl.MappingDSL.map;
import static org.fao.fi.comet.mapping.dsl.MappingDataDSL.maximumCandidates;
import static org.fao.fi.comet.mapping.dsl.MappingDataDSL.minimumWeightedScore;
import static org.fao.fi.comet.mapping.dsl.MappingDetailDSL.target;
import static org.fao.fi.comet.mapping.dsl.MatcherConfigurationDSL.configuredMatcher;
import static org.fao.fi.comet.mapping.dsl.MatcherConfigurationDSL.optional;
import static org.fao.fi.comet.mapping.dsl.MatcherConfigurationPropertyDSL.configurationProperty;

import java.net.URI;
import java.util.Date;

import org.fao.fi.comet.mapping.model.DataProvider;
import org.fao.fi.comet.mapping.model.MappingData;
import org.fao.fi.comet.mapping.model.test.support.GenericTerm;
import org.fao.fi.comet.mapping.model.utils.DOMUtils;

/**
 * Place your class / interface description here.
 *
 * History:
 *
 * ------------- --------------- -----------------------
 * Date			 Author			 Comment
 * ------------- --------------- -----------------------
 * 17/apr/2014   Fabio	 Creation.
 *
 * @version 1.0
 * @since 17/apr/2014
 */
public class GenericTermMappingDataMock extends MappingData {
	final static public long serialVersionUID = -666;
	
	private GenericTermMappingDataMock() {
		super();
	}
	
	static final public MappingData newInstance() throws Throwable {
		DataProvider sourceDataProvider = new DataProvider(new URI("urn:fooResourceStatus"), GenericTerm.class.getName());
		DataProvider targetDataProvider = new DataProvider(new URI("urn:barResourceStatus"), GenericTerm.class.getName());
		
		MappingData mappingData = new MappingData().
			id(new URI("urn:foo:bar")).
			version("0.01").
			producedBy("Foo Bazzi").
			on(new Date()).
			linking(sourceDataProvider).to(targetDataProvider).
			through(
				configuredMatcher(new URI("urn:matcher:foo")).
					ofType("org.fao.fi.comet.common.matchers.LexicalMatcher").
					weighting(10).
					withMinimumScore(0.1).
					having(
						configurationProperty("stripSymbols", Boolean.FALSE)
					),
				optional(
					configuredMatcher(new URI("urn:matcher:bar")).
						ofType("org.fao.fi.comet.common.matchers.AnotherLexicalMatcher").
						weighting(30).
						withMinimumScore(0.0).
						having(
							configurationProperty("useSoundex", Boolean.TRUE),
							configurationProperty("stripSymbols", Boolean.TRUE)
						)
					),
				optional(
					configuredMatcher(new URI("urn:matcher:baz")).
						ofType("org.fao.fi.comet.common.matchers.YetAnotherLexicalMatcher").
						weighting(20).
						withMinimumScore(0.2).
						having(
							configurationProperty("useSoundex", Boolean.TRUE)
						)
					)
			).
			with(minimumWeightedScore(0.3), maximumCandidates(5)).
			including(
				map(wrap(DOMUtils.toElement(GenericTerm.describing("over-exploited"))).with(identifierFor(sourceDataProvider, new URI("urn:1")))).
					to(
						target(wrap(DOMUtils.toElement(GenericTerm.describing("overexploited"))).with(identifierFor(targetDataProvider, new URI("urn:69")))).
							asContributedBy(matcher(new URI("urn:matcher:foo")).scoring(0.39), 
											matcher(new URI("urn:matcher:bar")).scoring(0.69),
											matcher(new URI("urn:matcher:baz")).nonPerformed()
							).withWeightedScore(0.59)
					).andTo(
						target(wrap(DOMUtils.toElement(GenericTerm.describing("ov-erexploited"))).with(identifierFor(targetDataProvider, new URI("urn:96")))).
							asContributedBy(matcher(new URI("urn:matcher:foo")).scoring(0.79), 
											matcher(new URI("urn:matcher:bar")).nonPerformed(),
											matcher(new URI("urn:matcher:baz")).nonPerformed()
							).withWeightedScore(0.59)
					)
			).including(
				map(wrap(DOMUtils.toElement(GenericTerm.describing("under-exploited"))).with(identifierFor(sourceDataProvider, new URI("urn:2")))).
					to(
						target(wrap(DOMUtils.toElement(GenericTerm.describing("underexploited"))).with(identifierFor(targetDataProvider, new URI("urn:70")))).
							asContributedBy(matcher(new URI("urn:matcher:foo")).scoring(0.49), 
											matcher(new URI("urn:matcher:bar")).scoring(0.59),
											matcher(new URI("urn:matcher:baz")).nonPerformed()
							).withWeightedScore(0.39)
					).andTo(
						target(wrap(DOMUtils.toElement(GenericTerm.describing("und-erexploited"))).with(identifierFor(targetDataProvider, new URI("urn:97")))).
							asContributedBy(matcher(new URI("urn:matcher:foo")).scoring(0.79), 
											matcher(new URI("urn:matcher:bar")).nonPerformed(),
											matcher(new URI("urn:matcher:baz")).nonPerformed()
							).withWeightedScore(0.79)
					).andTo(
						target(wrap(DOMUtils.toElement(GenericTerm.describing("un-derexploited"))).with(identifierFor(targetDataProvider, new URI("urn:98")))).
							asContributedBy(matcher(new URI("urn:matcher:foo")).scoring(0.29), 
											matcher(new URI("urn:matcher:bar")).nonPerformed(),
											matcher(new URI("urn:matcher:baz")).scoring(0.39)
							).withWeightedScore(0.35)
					)
		);
		
		return mappingData;
	}
}
