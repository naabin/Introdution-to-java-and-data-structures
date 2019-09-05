package com.week6.exercise;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CollectorTest {
	
	private Collector c1;
	private Collector c2;
	private Collector c3;

	@Before
	public void setUp() throws Exception {
		c1 = new Collector("Emily Environmental", new double[] {1.2, 2.2, 3.2, 4.2});
		c2 = new Collector("Lana Landscape", new double[] {0,0,0,0});
		c3 = new Collector("Nevil Nature", new String[] {"0.1", "0.1", "0.2", "0.3"});
	}

	@Test
	public void test1() {
		assertEquals("Emily Environmental, 10.8", c1.calculateTotal());
	}
	
	@Test
	public void test2() {
		assertEquals("Lana Landscape, 0.0", c2.calculateTotal());
	}
	
	@Test
	public void test3() {
		assertEquals("Nevil Nature, 0.7", c3.calculateTotal());
	}

}
