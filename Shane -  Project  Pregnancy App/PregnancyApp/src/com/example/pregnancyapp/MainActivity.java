package com.example.pregnancyapp;


import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;

public class MainActivity extends Activity {

	public void MakeCall(View v){
		Intent callIntent = new Intent(Intent.ACTION_CALL);
		callIntent.setData(Uri.parse("tel:086228095"));
		startActivity(callIntent);
	}
	
	public void TrackingOpen(View v){
		Intent IncInt = new Intent(MainActivity.this, Tracking.class);
		MainActivity.this.startActivity(IncInt);
	}
	
	public void WeeklyOpen(View v){
		Intent IncInt = new Intent(MainActivity.this, Weekly.class);
		MainActivity.this.startActivity(IncInt);
	}
	
	public void DietOpen(View v){
		Intent IncInt = new Intent(MainActivity.this, Diet.class);
		MainActivity.this.startActivity(IncInt);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//WebView ww = (WebView) findViewById(R.id.vg);
		//ww.loadUrl("file:///assets/pro/index.html");
	}
	
	public void SettingsOpen(View v){
    	Intent IncInt = new Intent(MainActivity.this, Settings.class);
		MainActivity.this.startActivity(IncInt);
    }
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
