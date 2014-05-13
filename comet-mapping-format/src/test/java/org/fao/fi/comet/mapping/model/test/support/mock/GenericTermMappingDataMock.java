/**
 * (C) 2014 by FAO / UN (project: comet-mapping-format)
 */
package org.fao.fi.comet.mapping.model.test.support.mock;

import static org.fao.fi.comet.mapping.dsl.MappingContributionDSL.matcher;
import static org.fao.fi.comet.mapping.dsl.MappingDSL.map;
import static org.fao.fi.comet.mapping.dsl.MappingDataDSL.maximumCandidates;
import static org.fao.fi.comet.mapping.dsl.MappingDataDSL.minimumWeightedScore;
import static org.fao.fi.comet.mapping.dsl.MappingDetailDSL.target;
import static org.fao.fi.comet.mapping.dsl.MappingElementDSL.nil;
import static org.fao.fi.comet.mapping.dsl.MappingElementDSL.wrap;
import static org.fao.fi.comet.mapping.dsl.MappingElementIdentifierDSL.identifierFor;
import static org.fao.fi.comet.mapping.dsl.MatcherConfigurationDSL.configuredMatcher;
import static org.fao.fi.comet.mapping.dsl.MatcherConfigurationDSL.optional;
import static org.fao.fi.comet.mapping.dsl.MatcherConfigurationPropertyDSL.configurationProperty;
import static org.fao.fi.comet.mapping.model.utils.jaxb.JAXB2DOMUtils.asElement;

import org.fao.fi.comet.mapping.dsl.DataProviderDSL;
import org.fao.fi.comet.mapping.model.DataProvider;
import org.fao.fi.comet.mapping.model.MappingData;
import org.fao.fi.comet.mapping.model.test.support.GenericTerm;

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
		DataProvider sourceDataProvider = DataProviderDSL.provider("urn:fooResourceStatusProvider", "http://cotrix.org", "urn:fooResourceStatus", "1.0");
		DataProvider targetDataProvider = DataProviderDSL.provider("urn:barResourceStatusProvider", "http://cotrix.org", "urn:barResourceStatus", "1.1");
		
		MappingData mappingData = MappingData.
			withId("urn:foo:bar").
			version("0.01").
			producedBy("Foo Bazzi").
			now().
			linking(sourceDataProvider).to(targetDataProvider).
			through(
				configuredMatcher("urn:matcher:foo").
					ofType("org.fao.fi.comet.common.matchers.LexicalMatcher").
					weighting(10).
					withMinimumScore(0.1).
					having(
						configurationProperty("stripSymbols", Boolean.FALSE)
					),
				optional(
					configuredMatcher("urn:matcher:bar").
						ofType("org.fao.fi.comet.common.matchers.AnotherLexicalMatcher").
						weighting(30).
						withMinimumScore(0.0).
						having(
							configurationProperty("useSoundex", Boolean.TRUE),
							configurationProperty("stripSymbols", Boolean.TRUE)
						)
					),
				optional(
					configuredMatcher("urn:matcher:baz").
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
				map(wrap(asElement(GenericTerm.describing("over-exploited"))).with(identifierFor(sourceDataProvider, "urn:1"))).
					to(
						target(wrap(asElement(GenericTerm.describing("overexploited"))).with(identifierFor(targetDataProvider, "urn:69"))).
							asContributedBy(matcher("urn:matcher:foo").scoring(0.39), 
											matcher("urn:matcher:bar").scoring(0.69),
											matcher("urn:matcher:baz").nonPerformed()
							).withWeightedScore(0.59)
					).andTo(
						target(wrap(asElement(GenericTerm.describing("ov-erexploited"))).with(identifierFor(targetDataProvider, "urn:96"))).
							asContributedBy(matcher("urn:matcher:foo").scoring(0.79), 
											matcher("urn:matcher:bar").nonPerformed(),
											matcher("urn:matcher:baz").nonPerformed()
							).withWeightedScore(0.59)
					)
			).including(
				map(wrap(asElement(GenericTerm.describing("under-exploited"))).with(identifierFor(sourceDataProvider, "urn:2"))).
					to(
						target(wrap(asElement(GenericTerm.describing("underexploited"))).with(identifierFor(targetDataProvider, "urn:70"))).
							asContributedBy(matcher("urn:matcher:foo").scoring(0.49), 
											matcher("urn:matcher:bar").scoring(0.59),
											matcher("urn:matcher:baz").nonPerformed()
							).withWeightedScore(0.39)
					).andTo(
						target(wrap(asElement(GenericTerm.describing("und-erexploited"))).with(identifierFor(targetDataProvider, "urn:97"))).
							asContributedBy(matcher("urn:matcher:foo").scoring(0.79), 
											matcher("urn:matcher:bar").scoringNoMatch(),
											matcher("urn:matcher:baz").nonPerformed()
							).withWeightedScore(0.79)
					).andTo(
						target(wrap(asElement(GenericTerm.describing("un-derexploited"))).with(identifierFor(targetDataProvider, "urn:98"))).
							asContributedBy(matcher("urn:matcher:foo").scoringFullMatch(), 
											matcher("urn:matcher:bar").nonPerformed(),
											matcher("urn:matcher:baz").scoring(0.39)
							).withWeightedScore(0.35)
					)
		);
		
		return mappingData;
	}
	
	static final public MappingData newInstanceWithNils() throws Throwable {
		DataProvider sourceDataProvider = DataProviderDSL.provider("urn:fooResourceStatusProvider", "http://cotrix.org", "urn:fooResourceStatus", "1.0");
		DataProvider targetDataProvider = DataProviderDSL.provider("urn:barResourceStatusProvider", "http://cotrix.org", "urn:barResourceStatus", "1.1");
		
		MappingData mappingData = MappingData.
			withId("urn:foo:bar").
			version("0.01").
			producedBy("Foo Bazzi").
			now().
			linking(sourceDataProvider).to(targetDataProvider).
			including(
				map(nil().with(identifierFor(sourceDataProvider, "urn:1"))).
					to(
						target(nil().with(identifierFor(targetDataProvider, "urn:69")))
					).andTo(
						target(nil().with(identifierFor(targetDataProvider, "urn:96")))
					)
			).including(
				map(nil().with(identifierFor(sourceDataProvider, "urn:2"))).
					to(
						target(nil().with(identifierFor(targetDataProvider, "urn:70")))
					).andTo(
						target(nil().with(identifierFor(targetDataProvider, "urn:97")))
					).andTo(
						target(nil().with(identifierFor(targetDataProvider, "urn:98")))
					)
		);
		
		return mappingData;
	}
}