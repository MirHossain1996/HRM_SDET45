package com.hrm.genriUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * it is used to generate random number
	 * @return
	 */
public int getRandomNumber() {
	Random random = new Random();
	int r = random.nextInt(1000);
	return r;
}
/**
 * It is used to return the date and time according to IST formate
 * @return
 */
public String getSystemDateAndTime() {
	Date date = new Date();
	return date.toString();
	
}
/**
 * 
 * @return
 */
public String getSystemDateWithFormate() {
	Date date=new Date();
	String dateAndTime=date.toString();
	String yyyy=dateAndTime.split(" ")[5];
	String dd=dateAndTime.split(" ")[2];
	String mm=dateAndTime.split(" ")[2];
	
	String finaldate=yyyy+" "+mm+" "+dd;
	return finaldate;
	
}
public String getSystemDateAndTimeFormate() {
	SimpleDateFormat dateFormate= new SimpleDateFormat();
	Date systemdate = new Date();
	String getDateAndTime = dateFormate.format(systemdate);
	System.out.println(getDateAndTime);
	return getDateAndTime.replaceAll(":", ".");
}
}
