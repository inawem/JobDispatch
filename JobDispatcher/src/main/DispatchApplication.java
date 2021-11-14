package main;

import com.demo.entities.Handler;
import com.demo.entities.Job;
import com.demo.entities.Score;
import com.demo.utils.Calculations;
import com.demo.utils.ReadConsole;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This is a main class to read the console for Driver's and Job's file
 *
 * @author dm
 */
public class DispatchApplication {

	/**
	 * Main Method to perform dispatch jobs to handlers
	 * 
	 * @param args Arguments if any
	 */
	public static void main(String[] args) {
		try {
			ArrayList<Job> jobs = new ArrayList<>();
			ArrayList<Handler> handlers = new ArrayList<>();

			// Read the Jobs and Handlers
			ReadConsole.readJobsAndHandlers(jobs, handlers);

			// Dispatch the Jobs to Handlers
			performDispatch(jobs, handlers);

			// Print the results
			for (var handler : handlers)
				System.out.println(handler);
		} catch (RuntimeException e) {
			System.out.println("Error occurred:" + e);
		}
	}

	/**
	 * Method to perform dispatch jobs to handlers
	 * 
	 * @param jobs:     Jobs Street Addresses for the day to dispatch
	 * @param handlers: Drivers ready to pick the jobs
	 */
	public static void performDispatch(ArrayList<Job> jobs, ArrayList<Handler> handlers) {
		ArrayList<Score> scores = new ArrayList<>();
		// Rank the jobs
		for (var handler : handlers)
			for (var job : jobs)
				scores.add(new Score(Calculations.calculateScore(handler, job),
						handler.getGuId(),
						job.getGuId()));

		// Sort the scores
		scores.sort(Collections.reverseOrder());

		// Assign the jobs to the handlers
		while (scores.size() > 0) {
			Score r = scores.stream().findFirst().get();
			var h = handlers.stream().filter(x -> x.getGuId() == r.getHandlerGuId()).findFirst().get();
			if (h != null) {
				h.setJob(jobs.stream().filter(x -> x.getGuId() == r.getJobGuId()).findFirst().get());
				h.setScore(r.getScore());
			}
			// Remove mapped job and driver
			scores.removeIf(x -> x.getHandlerGuId() == r.getHandlerGuId() || x.getJobGuId() == r.getJobGuId());
		}
	}
}
