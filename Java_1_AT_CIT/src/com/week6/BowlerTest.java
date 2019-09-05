package com.week6;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BowlerTest {
	
	private Bowler b1;
	private Bowler b2;
	private Bowler b3;
	private Bowler b4;
	
	public BowlerTest() {
		
	}

	@Before
	public void setUp() throws Exception {
		b1 = new Bowler("Andy Apple", new int[] {100, 120, 50});
		b2 = new Bowler("Bart Banana", new int[] {0, 0, 0});
		b3 = new Bowler("Calvin Carrot", new int[] {100, 120, 200});
		b4 = new Bowler("Drew Date", new String[] {"100", "100", "100"});
	}

	@Test
	public void test1() {
		assertEquals("Andy Apple, 90.0", b1.calculateAverage());
	}
	
	@Test
	public void test2() {
		assertEquals("Bart Banana, 0.0", b2.calculateAverage());
	}
	
	@Test
	public void test3() {
		assertEquals("Calvin Carrot, 140.0", b3.calculateAverage());
	}
	
	@Test
	public void test4() {
		assertEquals("Drew Date, 100.0", b4.calculateAverage());
	}

}
