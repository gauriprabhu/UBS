package com.ubs.opsit.interviews.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.ubs.opsit.interviews.util.Clock;

public class HourClockTest {
	HourClock hrClock;

	@Test
	public void hoursClock() {
		hrClock = new HourClock();
		Clock clock = hrClock.hoursClock(18);
		assertThat(clock.getRowOne()).isEqualTo("RRRO");
		assertThat(clock.getRowTwo()).isEqualTo("RRRO");
	}

}
