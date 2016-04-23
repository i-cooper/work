package com.example.point6;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class   extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		LinearLayout li=new LinearLayout(this);
		li.setPadding(10,10,10,10);
		TextView tView=new TextView(this);
		
		tView.setTextSize(18);
		tView.setText("sdhjfheiogholdsfjglsdofjgkljfdlkbjgirffbjr\ndsgdgdfvfdv");
		li.addView(tView);
		setContentView(li);
	}

}
