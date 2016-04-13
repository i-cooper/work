package com.example.point09;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends Activity
{
	public final  static String TAG="IamageView";
	private int index=0;
	private int imagePath[]={R.drawable.img01,R.drawable.img02,R.drawable.img03,R.drawable.img04};

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		LinearLayout layout=(LinearLayout) findViewById(R.id.layout);
		ImageView image=new ImageView(this);
		LinearLayout.LayoutParams paramms=new LinearLayout.LayoutParams(500,448);
		image.setLayoutParams(paramms);
		image.setImageResource(imagePath[index]);
		image.setOnTouchListener(new OnTouchListener()
		{
			
			@Override
			public boolean onTouch(View v, MotionEvent event)
			{
				// TODO Auto-generated method stub
				if(index<3)
				{
					index++;
				}
				else
				{
					index=0;
				}
				Log.i(TAG,"index= "+index);
				System.out.println("index =="+index);
				((ImageView)v).setImageResource(imagePath[index]);
				return true;
			}
		});
		layout.addView(image);
		
	}
}
