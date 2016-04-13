package com.example.point0;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity
{
	int imageIds []=new int [] {R.drawable.shoe_ok,R.drawable.shoe_sorry,R.drawable.shoe_sorry};

	private ImageView image1=null;
	private ImageView image2=null;
	private ImageView image3=null;

	private TextView result=null;

	private Button button=null;
	private boolean isOnClicked=false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		image1=(ImageView) findViewById(R.id.iView1);
		image2=(ImageView) findViewById(R.id.iView2);
		image3=(ImageView) findViewById(R.id.iView3);
		result=(TextView) findViewById(R.id.title);
		button=(Button) findViewById(R.id.resetButton);
		reset();
		image1.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				if(!isOnClicked)
				{
					isRight(v,0);
				}
			
			}
		});
		image2.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				if(!isOnClicked)
				{
					isRight(v,1);
				}			}
		});

		image3.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				if(!isOnClicked)
				{
					isRight(v,2);
				}
			}
		});

		button.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				reset();
				isOnClicked=false;
				result.setText(R.string.gameTitle);

				image1.setAlpha(255);
				image2.setAlpha(255);
				image3.setAlpha(255);

				image1.setImageDrawable(getResources().getDrawable(R.drawable.shoe_default));
				image2.setImageDrawable(getResources().getDrawable(R.drawable.shoe_default));
				image3.setImageDrawable(getResources().getDrawable(R.drawable.shoe_default));
			}
		});

	}

	@SuppressWarnings("deprecation")
	private void isRight(View v,int location)
	{
		image1.setImageDrawable(getResources().getDrawable(imageIds[0]));
		image2.setImageDrawable(getResources().getDrawable(imageIds[1]));
		image3.setImageDrawable(getResources().getDrawable(imageIds[2]));

		image1.setAlpha(100);
		image2.setAlpha(100);
		image3.setAlpha(100);

		isOnClicked=true;
		ImageView v1=(ImageView)v;
		v1.setAlpha(255);

		if(imageIds[location]==R.drawable.shoe_ok)
		{
			result.setText(R.string.successTitle);
		}
		else
		{
			result.setText(R.string.failTitle);
		}

	}

	private void reset ()
	{
		for(int i=0;i<imageIds.length;i++)
		{
			int temp=imageIds[i];
			int index= (int)(Math.random()*3);
			imageIds[i]=imageIds[index];
			imageIds[index]=temp;
		}
	}
}
