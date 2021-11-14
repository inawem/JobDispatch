/**
 * com.demo.utils is a group of utils for operating on Dispatch application.
 */
package com.demo.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import com.demo.entities.Handler;
import com.demo.entities.Job;

/**
 * Static Class to perform various read calculations and operations
 */
public final class ReadConsole {

	/**
	 * Static Method to Read the Jobs and Drivers from the System console
	 * @param jobs: Jobs Street Addresses for the day to dispatch
	 * @param handlers: Drivers ready to pick the jobs
	 */
	public static void ReadJobsAndHandlers(ArrayList<Job> jobs, ArrayList<Handler> handlers) {
		try (Scanner scanner = new Scanner(System.in)) {
			var contents = ReadCsvFile("Specify the Jobs file (CSV):", scanner);
			for (String streetAddress : contents) {
				jobs.add(new Job(streetAddress));
			}

			contents = ReadCsvFile("Specify the Drivers file (CSV):", scanner);
			for (String name : contents) {
				var handler = new Handler(name.trim());
				if(!handlers.contains(handler))
					handlers.add(handler);
				else
					System.out.println("****Duplicate Handler found: " + handler.getName());
			}
		}
	}

	
	/**
	 * Method to Read the CSV file (Only with one column)
	 * @param message to show the message 
	 * @param sc: System Scanner
	 * @return a <code> String[]</code>
	 */
	public static String[] ReadCsvFile(String message, Scanner sc) {
		System.out.println(message);
		String contents = "";
		boolean validFile = false;

		while (!validFile) {
			try {
				String JobsFileLoction = sc.nextLine();
				Path path = Paths.get(JobsFileLoction);
				if (Files.exists(path)) {
					contents = Files.readString(path);
					validFile = true;
				} else
					System.out.println("Invalid file. " + message);
			} catch (IOException e) {
				System.out.println("Invalid file. " + message);
			}
		}
		return contents.split(System.lineSeparator());
	}
}
