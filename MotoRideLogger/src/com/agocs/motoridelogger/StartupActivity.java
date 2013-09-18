package com.agocs.motoridelogger;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.*;

public class StartupActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.startup, menu);
        return true;
    }
    
    
    public void startLogger(View view) {
    	Intent intent = new Intent(this, DisplayStatus.class);
    	boolean loggerOnOff = ((ToggleButton) findViewById(R.id.RideLoggerOnOff)).isChecked();
    	String rideName = ((EditText) findViewById(R.id.rideName)).getText().toString();
    	int updateFreq = Integer.parseInt(((EditText) findViewById(R.id.updateFreq)).getText().toString());
    	boolean photoCheckBox = ((CheckBox) findViewById(R.id.checkBoxPhoto)).isChecked();
    	boolean speedCheckBox = ((CheckBox) findViewById(R.id.checkBoxSpeed)).isChecked();
    	boolean bearingCheckBox = ((CheckBox) findViewById(R.id.checkBoxBearing)).isChecked();
    	boolean locationCheckBox = ((CheckBox) findViewById(R.id.checkBoxLocation)).isChecked();
    	
    	intent.putExtra(LOGGERONOFF, loggerOnOff);
    	intent.putExtra(RIDENAME, rideName);
    	intent.putExtra(UPDATEFREQ, updateFreq);
    	intent.putExtra(PHOTOCHECKBOX, photoCheckBox);
    	intent.putExtra(SPEEDCHECKBOX, speedCheckBox);
    	intent.putExtra(BEARINGCHECKBOX, bearingCheckBox);
    	intent.putExtra(LOCATIONCHECKBOX, locationCheckBox);
    	startActivity(intent);
    }
    
    public String LOGGERONOFF = "LOGGERONOFF";
    public String RIDENAME = "RIDENAME";
    public String UPDATEFREQ = "UPDATEFREQ";
    public String PHOTOCHECKBOX = "PHOTOCHECKBOX";
    public String SPEEDCHECKBOX = "SPEEDCHECKBOX";
    public String BEARINGCHECKBOX = "BEARINGCHECKBOX";
    public String LOCATIONCHECKBOX = "LOCATIONCHECKBOX";
    
    
    
    
}

