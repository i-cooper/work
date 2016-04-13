package com.example.point7;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;

public class MainActivity extends Activity
{

	private TabHost tabHost;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tabHost=(TabHost) findViewById(android.R.id.tabhost);
		tabHost.setup();
		
		LayoutInflater inflater=LayoutInflater.from(this);
		inflater.inflate(R.layout.tab1,tabHost.getTabContentView());
		inflater.inflate(R.layout.tab2,tabHost.getTabContentView());
		inflater.inflate(R.layout.tab3,tabHost.getTabContentView());
		
		tabHost.addTab(tabHost.newTabSpec("tab01").setIndicator("δ������").setContent(R.id.Linearlayout01));
		tabHost.addTab(tabHost.newTabSpec("tab02").setIndicator("�ѽ�����").setContent(R.id.Linearlayout02));
		tabHost.addTab(tabHost.newTabSpec("tab01").setIndicator("�Ѳ�����").setContent(R.id.Linearlayout03));
	}
}
