package com.demo.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.demo.entities.Handler;
import com.demo.entities.Job;

/**
 * Class to perform various business calculations
 */
public final class Calculations {
	
	/**
	 * Static Method to calculate Common Factor of two numbers
	 * @param n1: First Integer
	 * @param n2: Second Integer
	 * @return <code> boolean </code>
	 */
	public static boolean CheckCommonFactor(int n1, int n2) {
		if (n1 == 1 || n2 == 1) {
			return false;
		}
		for (int i = 2; i <= n1 && i <= n2; ++i) {
			if (n1 % i == 0 && n2 % i == 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Static Method to calculate the SS for a Driver and a Job
	 * @param job: Jobs holding the Street Addresses and related data
	 * @param handler: Drivers information
	 * @return <code> double </code>
	 */
	public static double CalcuateScore(Handler handler, Job job) {
		float score = handler.getConsonants();
		if (job.getStreetNameLength() % 2 == 0) {
			score = (float) (handler.getVovels() * 1.5);
		}

		if (CheckCommonFactor(handler.getNameLength(), job.getStreetNameLength())) {
			score = (float) (score * 1.5);
		}
		System.out.println(String.format("%1$s Score:%2$s for %3$s", handler.getName(),score, job.getStreetName()));
		return score;
	}

	/**
	 * Static Method calculate Vovels in a name
	 * @param name: String name
	 * @return <code> int </code>
	 */
	public static int CalculateVovels(String name) {
		int count = 0;
		String vowels = "[aeiou]";
		Pattern r = Pattern.compile(vowels);
		Matcher m = r.matcher(name.toLowerCase());
		while (m.find())
			count++;
		return count;
	}

	/**
	 * Static Method calculate Consonents in a name
	 * @param name: String name
	 * @return <code> int </code>
	 */
	public static int CalculateConsonents(String name) {
		int count = 0;
		String consonents = "[b-df-hj-np-tv-z]";
		Pattern r = Pattern.compile(consonents);
		Matcher m = r.matcher(name.toLowerCase());
		while (m.find())
			count++;
		return count;
	}
}
