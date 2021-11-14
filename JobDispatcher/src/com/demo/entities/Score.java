package com.demo.entities;

import java.util.*;

/**
 * This is a model class to hold the Driver's score per job
 *
 * @author dm
 */
public class Score implements Comparable<Score>{
	private double score;
	private UUID handlerGuid;
	private UUID jobGuid;
	
	/**
	* Gets the score
	* @return a <code> double </code>
	* ss for a driver per job
	*/
	public final double getScore()
	{
		return score;
	}
	
	/**
	* Sets the Driver's score
	* @param value the score
	*/
	public final void setScore(double value)
	{
		score = value;
	}
	
	/**
	* Gets the Driver's GiId
	* @return a <code> UUID </code>
	*/
	public final UUID getHandlerGuid()
	{
		return handlerGuid;
	}
	
	/**
	* Sets the Driver's GuId
	* @param value the GuId
	*/
	public final void setHandlerGuid(UUID value)
	{
		handlerGuid = value;
	}

	/**
	* Gets the Job's GuId
	* @return a <code> UUID </code>
	*/
	public final UUID getJobGuid()
	{
		return jobGuid;
	}
	
	/**
	* Sets the Job's GuId
	* @param value the UUID
	*/
	public final void setJobGuid(UUID value)
	{
		jobGuid = value;
	}
	
	/**
	    * Score constructor
	    * @param score is calculate score
	    * @param handlerGuId is Driver's GuId
	    * @param jobGuId is Job's GuId
	    * @see #setScore(double)
	    * @see #setHandlerGuid(GuId)
	    * @see #setJobGuid(GuId)
	    * @author dm
	    */

	public Score(double score, UUID handlerGuId, UUID jobGuId)
	{
		setScore(score);
		setHandlerGuid(handlerGuId);
		setJobGuid(jobGuId);
	}
	
	@Override
	public String toString()
	{
		return String.format("Rank:%1$s for Job%2$s", getHandlerGuid(), getJobGuid());
	}
	
	@Override
	public int compareTo(Score o) {
		return (int)((this.getScore()) - (o.getScore()));
	}
}
