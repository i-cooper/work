package com.example.point04;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends Activity
{

	public static final String TAG="RabbitView";
	RabbitView rabbit;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		FrameLayout fm = (FrameLayout)findViewById(R.id.mylayout);
		
		 rabbit=new RabbitView(this); 
		rabbit.setOnTouchListener(new View.OnTouchListener()
		{
			
			@Override
			public boolean onTouch(View v, MotionEvent event)
			{
				// TODO Auto-generated method stub
				rabbit.bitmapX=event.getX();
				rabbit.bitmapY=event.getY();
				rabbit.invalidate();
				return true;
			}
		}
		 );
		if(fm==null)
		{
			Log.e(TAG,"fm==null");
			return;
		}
		fm.addView(rabbit);
	}
	
	
}
