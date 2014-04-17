/**
 * (C) 2014 by FAO / UN (project: comet-mapping-format)
 */
package org.fao.fi.comet.mapping.model.test.support.mock;

import static org.fao.fi.comet.mapping.dsl.ElementDSL.wrap;
import static org.fao.fi.comet.mapping.dsl.ElementIdentifierDSL.identifierFor;
import static org.fao.fi.comet.mapping.dsl.MappingContributionDSL.matcher;
import static org.fao.fi.comet.mapping.dsl.MappingDSL.map;
import static org.fao.fi.comet.mapping.dsl.MappingDataDSL.maximumCandidates;
import static org.fao.fi.comet.mapping.dsl.MappingDataDSL.minimumWeightedScore;
import static org.fao.fi.comet.mapping.dsl.MappingDetailDSL.target;
import static org.fao.fi.comet.mapping.dsl.MatcherConfigurationDSL.configuredMatcher;
import static org.fao.fi.comet.mapping.dsl.MatcherConfigurationDSL.optional;
import static org.fao.fi.comet.mapping.dsl.MatcherConfigurationPropertyDSL.configurationProperty;

import java.util.Date;

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
public class GenericTermMappingDataMock extends MappingData<GenericTerm, GenericTerm> {
	final static public long serialVersionUID = -666;
	
	private GenericTermMappingDataMock() {
		super();
	}
	
	static final public MappingData<GenericTerm, GenericTerm> newInstance() {
		DataProvider sourceDataProvider = new DataProvider("fooResourceStatus", GenericTerm.class.getName());
		DataProvider targetDataProvider = new DataProvider("barResourceStatus", GenericTerm.class.getName());
		
		MappingData<GenericTerm, GenericTerm> mappingData = new MappingData<GenericTerm, GenericTerm>().
			version("0.01").
			producedBy("Foo Bazzi").
			on(new Date()).
			linking(sourceDataProvider).to(targetDataProvider).
			through(
				configuredMatcher("foo").
					ofType("org.fao.fi.comet.common.matchers.LexicalMatcher").
					weighting(10).
					withMinimumScore(0.1).
					having(
						configurationProperty("stripSymbols", Boolean.FALSE)
					),
				optional(
					configuredMatcher("bar").
						ofType("org.fao.fi.comet.common.matchers.AnotherLexicalMatcher").
						weighting(30).
						withMinimumScore(0.0).
						having(
							configurationProperty("useSoundex", Boolean.TRUE),
							configurationProperty("stripSymbols", Boolean.TRUE)
						)
					),
				optional(
					configuredMatcher("baz").
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
				map(wrap(GenericTerm.describing("over-exploited")).with(identifierFor(sourceDataProvider, "1")), GenericTerm.class).
					to(
						target(wrap(GenericTerm.describing("overexploited")).with(identifierFor(targetDataProvider, "69"))).
							asContributedBy(matcher("foo").scoring(0.39), 
											matcher("bar").scoring(0.69),
											matcher("baz").nonPerformed()
							).withWeightedScore(0.59)
					).andTo(
						target(wrap(GenericTerm.describing("ov-erexploited")).with(identifierFor(targetDataProvider, "96"))).
							asContributedBy(matcher("foo").scoring(0.79), 
											matcher("bar").nonPerformed(),
											matcher("baz").nonPerformed()
							).withWeightedScore(0.59)
					)
			).including(
				map(wrap(GenericTerm.describing("under-exploited")).with(identifierFor(sourceDataProvider, "2")), GenericTerm.class).
					to(
						target(wrap(GenericTerm.describing("underexploited")).with(identifierFor(targetDataProvider, "70"))).
							asContributedBy(matcher("foo").scoring(0.49), 
											matcher("bar").scoring(0.59),
											matcher("baz").nonPerformed()
							).withWeightedScore(0.39)
					).andTo(
						target(wrap(GenericTerm.describing("und-erexploited")).with(identifierFor(targetDataProvider, "97"))).
							asContributedBy(matcher("foo").scoring(0.79), 
											matcher("bar").nonPerformed(),
											matcher("baz").nonPerformed()
							).withWeightedScore(0.79)
					).andTo(
						target(wrap(GenericTerm.describing("un-derexploited")).with(identifierFor(targetDataProvider, "98"))).
							asContributedBy(matcher("foo").scoring(0.29), 
											matcher("bar").nonPerformed(),
											matcher("baz").scoring(0.39)
							).withWeightedScore(0.35)
					)
		);
		
		return mappingData;
	}
}
