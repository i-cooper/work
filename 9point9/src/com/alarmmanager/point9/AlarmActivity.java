package com.alarmmanager.point9;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

public class AlarmActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		AlertDialog alert=new AlertDialog.Builder(this).create();
		alert.setTitle("����");
		alert.setMessage("�ϴ���������ʱ�䵽��");
		alert.setButton(AlertDialog.BUTTON_POSITIVE,"ȷ��",new DialogInterface.OnClickListener()
		{
			
			@Override
			public void onClick(DialogInterface dialog, int which)
			{
				// TODO Auto-generated method stub
				
			}
		});
		alert.show(); 
	}

}
