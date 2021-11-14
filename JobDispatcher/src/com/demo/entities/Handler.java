package com.demo.entities;
import java.util.UUID;

import com.demo.utils.Calculations;

/**
 * This is a model class to hold the Driver's information
 *
 * @author dm
 */
public class Handler implements IEntity{
	private UUID guId ;
    private String name; 
    private double score;
    private Job Job;
    private int nameLength;
    private int vowels;
    private int consonants;
    
    @Override
	public UUID getGuId() {
		return guId;
	}

	/**
	* Gets the Driver's Name
	* @return a <code> String </code>
	*/
	public String getName() {
		return name;
	}
	
	/**
	* Sets the Driver's Name
	* @param name is the Driver's Name
	*/
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	* Gets the Driver's Score
	* @return a <code> double </code>
	*/
	public final double getScore() {
		return score;
	}
	
	/**
	* Sets the Driver's score
	* @param score the score
	*/
	public void setScore(double score) {
		this.score = score;
	}
	
	/**
	* Gets the Job
	* @return a <code> Job </code>
	*/
	public final Job getJob() {
		return Job;
	}
	
	/**
	* Sets the Driver's Job
	* @param job the Job
	*/
	public final void setJob(Job job) {
		Job = job;
	}
	
	/**
	* Gets the Driver's Name Length
	* @return a <code> int </code>
	*/
	public final int getNameLength() {
		return nameLength;
	}
	
	/**
	* Sets the Driver's Name Length
	*/
	public final void setNameLength() {
		this.nameLength = name.length();
	}
	
	/**
	* Gets the Vowels in the Driver's Name
	* @return a <code> int </code>
	*/
	public final int getVowels() {
		return vowels;
	}
	
	/**
	* Sets the Vowels in the Driver's name
	*/
	public final void setVowels() {
		this.vowels = Calculations.CalculateVowels(name);
	}
	
	/**
	* Gets the Consonants in the Driver's Name
	* @return a <code> int </code>
	*/
	public final int getConsonants() {
		return consonants;
	}
	
	/**
	* Sets the Consonants in Driver's name
	*/
	public final void setConsonants() {
		this.consonants = Calculations.CalculateConsonants(name);
	}

   /**
    * Handler constructor
    * @param name is the name of the Driver
    * @see #setName(String)
    * @see #setVowels()
    * @see #setConsonants()
    * @see #setNameLength()
    * @author dm
    */
	public Handler(String name)
	{
		guId = UUID.randomUUID();
		setName(name);
		setVowels();
		setConsonants();
		setNameLength();
	}
	
	@Override
	public boolean equals(Object h) {
		if(h instanceof Handler)
			return(this.getName().equalsIgnoreCase(((Handler)h).getName()));
		return false;
	}
	
	@Override
    public int hashCode(){
        return 1;
    }

	@Override
	public String toString()
	{
		if(getJob()==null)
			return(String.format("%1$s(%2$s,%3$s,%4$s) No Job allocated", getName(), getNameLength(), getVowels(), getConsonants()));
		else
			return(String.format("%1$s(%2$s,%3$s,%4$s) Score:%5$s, Street:%6$s(%7$s)", getName(), getNameLength(), getVowels(), getConsonants(), getScore(), getJob().getStreetName(), getJob().getStreetNameLength()));
	}
}
