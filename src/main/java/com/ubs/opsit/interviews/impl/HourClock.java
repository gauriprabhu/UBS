package com.ubs.opsit.interviews.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ubs.opsit.interviews.constant.ClockConstants;
import com.ubs.opsit.interviews.enumeration.Colors;
import com.ubs.opsit.interviews.util.Clock;

public class HourClock{

	private static final Logger LOG = LoggerFactory.getLogger(HourClock.class);
	
	public Clock hoursClock(int hour){
		Clock clock = new Clock();
		clock.setScenario(dayScenario(hour));
		StringBuilder rowOne = new StringBuilder();
		StringBuilder rowTwo = new StringBuilder();
		int firstRow = hour/ClockConstants.HOUR_MIN_DIV_ROW_ONE;
		int secondRow = hour%ClockConstants.HOUR_MIN_DIV_ROW_ONE;
		int count = 0;
		for(int i=0; i<ClockConstants.HOUR_ROW_ONE; i++){
			count++;
			if(count <= firstRow){
				rowOne.append(Colors.R);
			}
			else if(count > firstRow){
				rowOne.append(Colors.O);
			}
			if(count <= secondRow){
				rowTwo.append(Colors.R);
			}
			else if(count > secondRow){
				rowTwo.append(Colors.O);
			}
		}
		clock.setRowOne(rowOne.toString());
		clock.setRowTwo(rowTwo.toString());
		LOG.debug("Hours clock Row #1 : "+ rowOne);
		LOG.debug("Hours clock Row #2 : "+ rowTwo);
		return clock;
	}
	
	private String dayScenario(int hour){
		LOG.info("Calcuation of SCENARIOS");
		String scenario = null;
		if((hour >= ClockConstants.EARLYMORNING && hour < ClockConstants.AFTERNOON ) || hour == ClockConstants.MIDNIGHT){
			scenario = Colors.Y.toString();
		}
		else if(hour >= ClockConstants.AFTERNOON && hour < ClockConstants.MIDNIGHT){
			scenario = Colors.O.toString();
		}
		LOG.debug("SCENARIO : " + scenario);
		return scenario;
	}
}
