package com.ubs.opsit.interviews.impl;

import com.ubs.opsit.interviews.constant.ClockConstants;
import com.ubs.opsit.interviews.enumeration.Colors;
import com.ubs.opsit.interviews.util.Clock;

public class HourClock{

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
		return clock;
	}
	
	private String dayScenario(int hour){
		String scenario = null;
		if((hour >= ClockConstants.EARLYMORNING && hour < ClockConstants.AFTERNOON ) || hour == ClockConstants.MIDNIGHT){
			scenario = Colors.Y.toString();
		}
		else if(hour >= ClockConstants.AFTERNOON && hour < ClockConstants.MIDNIGHT){
			scenario = Colors.O.toString();
		}
		return scenario;
	}
}
