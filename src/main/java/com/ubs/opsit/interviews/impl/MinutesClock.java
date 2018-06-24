package com.ubs.opsit.interviews.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ubs.opsit.interviews.constant.ClockConstants;
import com.ubs.opsit.interviews.enumeration.Colors;
import com.ubs.opsit.interviews.util.Clock;

public class MinutesClock{

	private static final Logger LOG = LoggerFactory.getLogger(MinutesClock.class);
	
	public Clock minClock(int min){
		Clock clock = new Clock();
		StringBuilder rowOne = new StringBuilder();
		StringBuilder rowTwo = new StringBuilder();
		int firstRow = min/ClockConstants.HOUR_MIN_DIV_ROW_ONE;
		int secondRow = min%ClockConstants.HOUR_MIN_DIV_ROW_ONE;
		int count = 0;
		int quarter = 0;
		for(int i=0; i<ClockConstants.MINUTES_ROW_ONE; i++){
			count++;
			quarter = count * ClockConstants.HOUR_MIN_DIV_ROW_ONE;
			if((quarter == ClockConstants.FIRST_QUARTER || quarter == ClockConstants.HALF_QUARTER || quarter == ClockConstants.LAST_QUARTER) && count <= firstRow){
				rowOne.append(Colors.R);
			}
			else if(count <= firstRow){
				rowOne.append(Colors.Y);
			}
			else if(count > firstRow){
				rowOne.append(Colors.O);
			}
			if(count <= secondRow && count <= ClockConstants.MINUTES_ROW_TWO){
				rowTwo.append(Colors.Y);
			}
			else if(count > secondRow && count <= ClockConstants.MINUTES_ROW_TWO){
				rowTwo.append(Colors.O);
			}
		}
		clock.setRowOne(rowOne.toString());
		clock.setRowTwo(rowTwo.toString());
		LOG.debug("Minutes clock Row #1 : "+ rowOne);
		LOG.debug("Minutes clock Row #2 : "+ rowTwo);
		return clock;
	}
	
	
}
