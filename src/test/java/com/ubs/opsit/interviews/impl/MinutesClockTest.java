package com.ubs.opsit.interviews.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.ubs.opsit.interviews.util.Clock;

public class MinutesClockTest {
	MinutesClock minClock;

	@Test
	public void minClock() {
		minClock = new MinutesClock();
		Clock clock = minClock.minClock(18);
		assertThat(clock.getRowOne()).isEqualTo("YYROOOOOOOO");
		assertThat(clock.getRowTwo()).isEqualTo("YYYO");
	}

}
