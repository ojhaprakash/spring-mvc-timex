package ca.mountainpirate.timex.utils;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;

public class SimpleTest {

	@Test
	public void testAddSuccess() {
		int val1 = 3;
		int val2 = 2;
		int expected = 5;
		Assert.assertTrue(val1+val2 == expected);
	}
	
	@Test
	@Ignore
	public void testAddFail() {
		int val1 = 3;
		int val2 = 2;
		int expected = 5;
		Assert.assertTrue(val1-val2 == expected);
	}
}
