package org.franlero.meetingtimer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends Activity implements OnSeekBarChangeListener {
	
	public final static String DURATION = "org.franlero.meetingtimer.DURATION";
	
	private SeekBar bar;
	
	private EditText duration;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		bar = (SeekBar)findViewById(R.id.seekBar1);
		bar.setOnSeekBarChangeListener(this);
		
		duration = (EditText)findViewById(R.id.editText1);
		duration.setText(Integer.toString(bar.getProgress()));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	/** Called when the user clicks the start button */
	public void startTimer(View view) {
	    // Do something in response to button
		Intent intent = new Intent(this, TimerActivity.class);
		intent.putExtra(DURATION, duration.getText().toString());
		startActivity(intent);
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
		// TODO Auto-generated method stub
    	// change progress text label with current seekbar value
		duration.setText(Integer.toString(progress));	
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}

}
