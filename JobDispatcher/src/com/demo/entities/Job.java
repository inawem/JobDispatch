package com.demo.entities;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This is a model class to hold the Job's Street information
 *
 * @author dm
 */
public class Job implements IEntity {

	private UUID guId;
	private String streetAddress;
	private String streetName;
	private int streetNameLength;

	/**
	 * Get the Job's Street Address
	 * 
	 * @return a <code> String </code>
	 */
	public String getStreetAddress() {
		return streetAddress;
	}

	/**
	 * Sets the Job's Street Address
	 * 
	 * @param streetAddress the String
	 */
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	/**
	 * Gets the Job's Street Name
	 * 
	 * @return a <code> String</code>
	 */
	public String getStreetName() {
		return streetName;
	}

	/**
	 * Sets the Job's Street Name
	 */
	public void setStreetName() {
		String regularPat = "\\d[,\\s-.]+[a-zA-Z\\s.-]+$";
		Pattern r = Pattern.compile(regularPat);
		Matcher m = r.matcher(streetAddress);
		if (m.find())
			this.streetName = m.group().substring(2).trim();
		else
			this.streetName = streetAddress.replaceAll("\\d+[,\\s#.]+", "");// [0-9]+\\s.#-","");

	}

	/**
	 * Gets the Job's Street Name Length
	 * 
	 * @return a <code> int </code>
	 */
	public int getStreetNameLength() {
		return streetNameLength;
	}

	/**
	 * Sets the Job's Street Name's Length
	 */
	public void setStreetNameLength() {
		this.streetNameLength = streetName.length();
	}

	/**
	 * Job constructor
	 * 
	 * @param streetAddress is the Street Address
	 * @see #setStreetAddress(String)
	 * @see #setStreetName()
	 * @see #setStreetNameLength()
	 * @author dm
	 */
	public Job(String streetAddress) {
		guId = UUID.randomUUID();
		setStreetAddress(streetAddress);
		setStreetName();
		setStreetNameLength();
	}

	@Override
	public UUID getGuId() {
		return guId;
	}

}
