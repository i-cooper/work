package com.example;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity
{
	NotificationManager nManager=null;
	
	Button bt1=null;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		nManager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		bt1=(Button) findViewById(R.id.but1);
		bt1.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				Notification notification=new Notification();
				// TODO Auto-generated method stub
				notification.icon=R.drawable.ic_launcher;
				notification.tickerText="显示第一个通知";
				notification.when=System.currentTimeMillis();
				notification.setLatestEventInfo(MainActivity.this,"无题","每天进步一点",null);
				nManager.notify(12345,notification);
			}
		});
	}
}
