/**
 * (c) 2014 FAO / UN (project: comet-mapping-format)
 */
package org.fao.fi.comet.mapping.dsl;

import java.net.URI;
import java.net.URISyntaxException;

import org.fao.fi.comet.mapping.ScoreValue;
import org.fao.fi.comet.mapping.model.MatcherConfiguration;

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
public class MatcherConfigurationDSL {
	final static public MatcherConfiguration optional(MatcherConfiguration configuration) {
		configuration.setOptional(true);
		
		return configuration;
	}
	
	final static public MatcherConfiguration configuredMatcher(URI id) {
		return new MatcherConfiguration(id);
	}
	
	final static public MatcherConfiguration configuredMatcher(String idURI) {
		try {
			return MatcherConfigurationDSL.configuredMatcher(new URI(idURI));
		} catch(URISyntaxException USe) {
			throw new IllegalArgumentException("Bad format for URI " + idURI + ": " + USe.getMessage(), USe);
		}
		
	}
	
	final static public double weight(double weight) {
		if(Double.compare(weight, 0) <= 0)
			throw new IllegalArgumentException("Matcher weights must be greater than zero");
		
		return weight;
	}
	
	final static public double minimumMatcherScore(double minimumScore) {
		if(Double.compare(minimumScore, ScoreValue.NO_MATCH) < 0 || Double.compare(minimumScore, ScoreValue.FULL_MATCH) > 0) 
			throw new IllegalArgumentException("Matcher minimum scores must be in the range [" + ScoreValue.NO_MATCH + ", " + ScoreValue.FULL_MATCH + "]");
		
		return minimumScore;
	}
}
