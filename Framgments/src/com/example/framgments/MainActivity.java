package com.example.framgments;

import android.app.Activity;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Display display=getWindowManager().getDefaultDisplay();
		if(display.getWidth()>display.getHeight())
		{
			Fragment1 fragment1=new Fragment1();
			getFragmentManager().beginTransaction().replace(R.id.main_layout, fragment1).commit(); 
			
		}
		else
		{
			Fragment2 fragment2 = new Fragment2();  
            getFragmentManager().beginTransaction().replace(R.id.main_layout, fragment2).commit();  
		}
	}
}
