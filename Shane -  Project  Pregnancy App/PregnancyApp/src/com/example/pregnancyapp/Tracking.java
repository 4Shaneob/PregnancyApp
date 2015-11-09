package com.example.pregnancyapp;

import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

public class Tracking extends Activity {
	int dayz1 = 0;
	int monthz1 = 0;
	int yearz1 = 0;
	int monLeft = 0;
	public void ChangeText(String text, int id){
		TextView temp = (TextView)findViewById(id);
		temp.setText(text);
	}
	public String GetTextCalculated(int id){
		DatePicker temp = (DatePicker)findViewById(R.id.dater);
		int day = temp.getDayOfMonth();
		int month = temp.getMonth();
		int year = temp.getYear();
		
		if(day > 30){
			month = month+1;
			day = 20;
		}
		else if(day > 10 && day < 30){
			day = 30;
		}
		else{
			day = 20;
		}
		if(month == 1){
			month = 10;
		}
		else if(month == 2){
			month = 11;
		}
		else if(month == 3){
			month = 12;
		}
		else if(month == 4){
			month = 1;
			year = year + 1;
		}
		else if(month == 5){
			month = 2;
			year = year+1;
		}
		else if(month == 6){
			month = 3;
			year = year+1;
		}
		else if(month == 7){
			month = 4;
			year = year+1;
		}
		else if(month == 8){
			month = 5;
			year = year+1;
		}
		else if(month == 9){
			month = 6;
			year = year+1;
		}
		else if(month == 10){
			month = 7;
			year = year+1;
		}
		else if(month == 11){
			month = 8;
			year = year+1;
		}
		else if(month == 12){
			month = 9;
			year = year+1;
		}
		dayz1 = day;
		monthz1 = month;
		yearz1 = year;
		return String.valueOf(day)+" / "+String.valueOf(month)+" / "+String.valueOf(year);
	}
	
	public String CalculateLeft(){
		DatePicker temp = (DatePicker)findViewById(R.id.dater);
		int day1 = temp.getDayOfMonth();
		int month1 = temp.getMonth();
		int year1 = temp.getYear();
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH);
		int dayz = cal.get(Calendar.DAY_OF_MONTH);
		int yearz = cal.get(Calendar.YEAR);
		
		int leftMonths =  monthz1 - month;
		int leftDays =  dayz1 - dayz;
		monLeft = leftMonths;
		String left = leftMonths+" months and "+leftDays+" days.";
		return left;
	}
	public String Trimest(){
		String trimm = null;
		if(monLeft <= 9 && monLeft >= 6){
			trimm = "First";
		}
		else if(monLeft <= 6 && monLeft >= 3){
			trimm = "Second";
		}
		else if(monLeft <= 3 && monLeft >= 0){
			trimm = "Third";
		}
		return trimm;
	}
	public void Calculate(View v){
		ChangeText(GetTextCalculated(R.id.dater), R.id.duedate);
		ChangeText(CalculateLeft(), R.id.lefter);
		ChangeText(Trimest(), R.id.trim);
	}
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tracking);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_tracking, menu);
		return true;
	}

}
