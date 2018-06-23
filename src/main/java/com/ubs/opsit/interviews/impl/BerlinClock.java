package com.ubs.opsit.interviews.impl;
/*
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;*/

import com.ubs.opsit.interviews.TimeConverter;
import com.ubs.opsit.interviews.util.Clock;

public class BerlinClock implements TimeConverter {

	@Override
	public String convertTime(String time) {
		
		int[] date = formatTimeBySplit(time);
		System.out.println("Time: " + date);
		
		int hour =  date[0];
		HourClock hrClock = new HourClock();
		Clock clock = hrClock.hoursClock(hour);
		MinutesClock minClock = new MinutesClock();
		Clock min = minClock.minClock(date[1]); 
		return clock.getScenario()+"\r"+"\n"+clock.getRowOne()+"\r"+"\n"+clock.getRowTwo()+"\r"+"\n"+min.getRowOne()+"\r"+"\n"+min.getRowTwo();
	}
	
	//format date in terms of HH:mm:ss
	/*private Date formatTime(String time){
	
		DateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(time);
		} catch (ParseException e) {
			System.out.println("Error occured while parsing time. " + e);
		}
		return date;
	}*/
	
	private int[] formatTimeBySplit(String time){
		String[] date = time.split(":");
		int[] intDate = { Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2])};
		return intDate;
	}

}
