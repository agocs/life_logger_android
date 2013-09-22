package com.agocs.motoridelogger;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class DisplayStatus extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_status);
		// Show the Up button in the action bar.
		setupActionBar();
		
		
		
		Intent intent  = getIntent();
		
		String rideName = intent.getStringExtra(StartupActivity.RIDENAME);
		boolean loggerOnOff = intent.getBooleanExtra(StartupActivity.LOGGERONOFF , false);
		int updateFreq = intent.getIntExtra(StartupActivity.UPDATEFREQ, 1);
		boolean photoCheckBox = intent.getBooleanExtra(StartupActivity.PHOTOCHECKBOX, false);
		boolean speedCheckBox = intent.getBooleanExtra(StartupActivity.SPEEDCHECKBOX, false);
		boolean bearingCheckBox = intent.getBooleanExtra(StartupActivity.BEARINGCHECKBOX, false);
		boolean locationCheckBox = intent.getBooleanExtra(StartupActivity.LOCATIONCHECKBOX, false);
		
		TextView rideNameTextView = (TextView) findViewById(R.id.rideNameTextView);
		TextView onOffTextView = (TextView) findViewById(R.id.onOffTextView);
		TextView updateFreqTextView = (TextView) findViewById(R.id.updateFreqTextView);
		TextView photoTextView = (TextView) findViewById(R.id.photoTextView);
		TextView speedTextView = (TextView) findViewById(R.id.speedTextView);
		TextView bearingTextView = (TextView) findViewById(R.id.bearingTextView);
		TextView locationTextView = (TextView) findViewById(R.id.locationTextView);
		
		rideNameTextView.setText(rideName);
		onOffTextView.setText(loggerOnOff ? "True" : "False");
		updateFreqTextView.setText("Updating "+ updateFreq + "times per hour");
		photoTextView.setText(photoCheckBox ? "True" : "False");
		speedTextView.setText(speedCheckBox ? "True" : "False");
		bearingTextView.setText(bearingCheckBox ? "True" : "False");
		locationTextView.setText(locationCheckBox ? "True" : "False");
		
		
		
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_status, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
