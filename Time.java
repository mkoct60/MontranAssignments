package com.montran.pojo;

public class Time {

	private int hours,minutes;
	
	public void settime(int hours,int minutes) {
		this.hours=hours;
		this.minutes=minutes;
	}
	
	public void showtime() {
		System.out.print("Time hours=" + hours + ", minutes=" + minutes);
	}

	public Time sum(Time time1) {
		Time time2=new Time();

		time2.minutes = minutes + time1.minutes+60*hours+60*time1.hours;
		

		time2.hours=time2.minutes/60;

		time2.minutes=time2.minutes%60;

		//time2.hours += hours + time2.hours;

		return time2;
	}
	
	
	
}
