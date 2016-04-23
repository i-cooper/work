package com.alarmmanager.point9;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;
import com.alarmmanager.point9.AlarmActivity;

public class MainActivity extends Activity
{
	TimePicker timer=null;
	Button bt1=null;
     Calendar c=null;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		c=Calendar.getInstance();
		c.setTimeInMillis(System.currentTimeMillis());
		timer=(TimePicker) findViewById(R.id.timer);
		timer.setIs24HourView(true);
		timer.setCurrentHour(c.get(Calendar.HOUR_OF_DAY));
		timer.setCurrentMinute(c.get(Calendar.MINUTE));
		
		bt1=(Button) findViewById(R.id.bt1);
		bt1.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				Intent intent=new Intent(MainActivity.this,AlarmActivity.class);
				PendingIntent pendingIntent=PendingIntent.getActivity(MainActivity.this,0,intent,0);
				
				AlarmManager alarm=(AlarmManager) getSystemService(Context.ALARM_SERVICE);
				c.set(Calendar.HOUR_OF_DAY,timer.getCurrentHour());
				c.set(Calendar.MINUTE,timer.getCurrentMinute());
				alarm.set(AlarmManager.RTC_WAKEUP,c.getTimeInMillis(),pendingIntent);
				Toast.makeText(MainActivity.this,"ƒ÷÷”…Ë÷√≥…π¶",Toast.LENGTH_SHORT).show();
			}
		});
	}
}
