package test;

import com.demo.entities.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DispatchAppTest {
	ArrayList<Handler> h = new ArrayList<Handler>();
	ArrayList<Job> j = new ArrayList<Job>();
	String handler1 = "Dheeraj Mewani";
	String handler2 = "David M'Olive DDEE";
	String streetAddress1 = "82 Dundee Ave";
	String streetAddress2 = "23, Old Bridge Avenue";

	@BeforeEach
	public void setUp() {
		h.add(new Handler(handler1));
		j.add(new Job(streetAddress1));
		h.add(new Handler(handler2));
		j.add(new Job(streetAddress2));
		main.DispatchApplication.performDispatch(j, h);
	}

	@Test
	void test1Score() {
		double res = h.get(0).getScore();
		assertEquals(7, res);
	}

	@Test
	void test1StreetName() {
		String streetName = j.get(0).getStreetName();
		assertEquals("Dundee Ave", streetName);
	}

	@Test
	void test1Vowel() {
		int vowels = h.get(0).getVowels();
		assertEquals(6, vowels);
	}

	@Test
	void test1Consonants() {
		int consonants = h.get(0).getConsonants();
		assertEquals(7, consonants);
	}

	@Test
	void test1HandlerJobAssociation() {
		String streetName = h.get(0).getJob().getStreetName();
		assertEquals(streetName, "Old Bridge Avenue");

	}

}
