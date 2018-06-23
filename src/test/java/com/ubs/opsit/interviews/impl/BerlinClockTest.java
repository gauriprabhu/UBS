package com.ubs.opsit.interviews.impl;

import static org.junit.Assert.*;

import org.junit.Test;

public class BerlinClockTest {

	@Test
	public void convertTime() {
		BerlinClock clock = new BerlinClock();
		clock.convertTime("18:32:00");
	}

	@Test
	public void convertTimeScenario2() {
		BerlinClock clock = new BerlinClock();
		clock.convertTime("11:32:00");
	}
	
	@Test
	public void convertTimeScenario3() {
		BerlinClock clock = new BerlinClock();
		clock.convertTime("00:00:00");
	}
	
	@Test
	public void convertTimeScenario4() {
		BerlinClock clock = new BerlinClock();
		clock.convertTime("24:00:00");
	}
}
