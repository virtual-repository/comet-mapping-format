/**
 * (c) 2014 FAO / UN (project: comet-mapping-format)
 */
package org.fao.fi.comet.mapping.dsl;

import org.fao.fi.comet.mapping.ScoreValue;

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
public class MappingDataDSL {
	final static public double minimumWeightedScore(double score) {
		if(Double.compare(score, ScoreValue.NO_MATCH) < 0 || Double.compare(score, ScoreValue.FULL_MATCH) > 0)
			throw new IllegalArgumentException("The mapping minimum score should be in the range [" + ScoreValue.NO_MATCH + ", " + ScoreValue.FULL_MATCH + "]");
		
		return score;
	}
	
	final static public int maximumCandidates(int maximumCandidates) {
		if(maximumCandidates <= 0)
			throw new IllegalArgumentException("The mapping maximum number of candidates should be greater than zero");
		
		return maximumCandidates;
	}
}
