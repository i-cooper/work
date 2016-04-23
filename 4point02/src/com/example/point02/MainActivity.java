package com.example.point02;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends Activity
{

	private static final String  CONTENTS[]={"����","����̫������","����������","�������","�����Ǹ�������"};
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		AutoCompleteTextView aView=(AutoCompleteTextView) findViewById(R.id.AutoCompleteTextView);
		
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,CONTENTS);
		aView.setAdapter(adapter);
		
	}
}
