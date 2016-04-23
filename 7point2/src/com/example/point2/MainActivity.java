package com.example.point2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity
{
Button but1=null;
Button but2=null;
OnClickListener lister=null;	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		but1=(Button) findViewById(R.id.call);
		but2=(Button) findViewById(R.id.sendMessage);
		
		lister=new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				switch(v.getId())
				{
				case R.id.call:
					Intent intent=new Intent();
//					intent.setAction(Intent.ACTION_CALL);
//					intent.setData(Uri.parse("tel:18682381645"));
					startActivity(intent);
					break;
					
				case R.id.sendMessage:
					Intent intentMessage=new Intent();
					intentMessage.setAction(Intent.ACTION_SEND);
					intentMessage.setData(Uri.parse("smsto:18682381645"));
					intentMessage.putExtra("sms_body","weclome");
					startActivity(intentMessage);
					break;
				}
			}
		};
		
		but1.setOnClickListener(lister);
		but2.setOnClickListener(lister);
	}
}
