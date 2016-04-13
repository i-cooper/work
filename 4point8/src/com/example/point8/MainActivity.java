package com.example.point8;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity
{

	CheckBox cbox=null;
	ImageButton iButton=null;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		cbox=(CheckBox) findViewById(R.id.agrreId);
		iButton=(ImageButton) findViewById(R.id.start);

		cbox.setOnCheckedChangeListener(new OnCheckedChangeListener()
		{

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
			{
				// TODO Auto-generated method stub
				if(isChecked)
				{
					iButton.setVisibility(View.VISIBLE);
				}
				else
				{
					iButton.setVisibility(View.INVISIBLE);  
				}
				iButton.invalidate();
			}

		});

		iButton.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this,"Ω¯»Î”Œœ∑....",Toast.LENGTH_SHORT).show();	
			}
		})	;
	}
}
