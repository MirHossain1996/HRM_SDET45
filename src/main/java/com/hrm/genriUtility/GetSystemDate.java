package com.hrm.genriUtility;

import java.util.Date;
/**
 * 
 * @author =Mir.
 *
 */
public class GetSystemDate {

	public String getSystemDateWithFormate() {
		Date date=new Date();
		String dateAndTime=date.toString();
		String yyyy=dateAndTime.split(" ")[5];
		String dd=dateAndTime.split(" ")[2];
		String mm=dateAndTime.split(" ")[2];
		
		String finaldate=yyyy+" "+mm+" "+dd;
		return finaldate;
		
	}
}
