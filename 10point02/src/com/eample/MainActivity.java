package com.eample;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity
{

	Button bt1=null;
	Button bt2=null;
	Button bt3=null;
	Button bt4=null;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		bt1=(Button) findViewById(R.id.button1);
		bt1.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				AlertDialog alert=new AlertDialog.Builder(MainActivity.this).create();
				alert.setIcon(R.drawable.advise);
				alert.setTitle("系统提示：");
				alert.setMessage("带取消、中立和确定的对话框");
				alert.setButton(DialogInterface.BUTTON_POSITIVE,"确定",new DialogInterface.OnClickListener()
				{

					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						// TODO Auto-generated method stub
						Toast.makeText(MainActivity.this,"单击了确定按钮",Toast.LENGTH_SHORT).show();
					}

				}
						);

				alert.setButton(DialogInterface.BUTTON_NEUTRAL,"中立",new DialogInterface.OnClickListener()
				{

					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						// TODO Auto-generated method stub
						Toast.makeText(MainActivity.this,"单击了中立按钮",Toast.LENGTH_SHORT).show();
					}
				});
				alert.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",new DialogInterface.OnClickListener()
				{

					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						// TODO Auto-generated method stub
						Toast.makeText(MainActivity.this,"单击了取消按钮",Toast.LENGTH_SHORT).show();
					}
				});
				alert.show();
			}
		});
		bt2=(Button) findViewById(R.id.button2);
		bt2.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				final String items[]=new String[]{"跑步","羽毛球","乒乓球","网球","体操"};
				// TODO Auto-generated method stub
				AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
				builder.setIcon(R.drawable.advise1);
				builder.setMessage("请选择你喜欢的运动项目");
				builder.setItems(items,new DialogInterface.OnClickListener()
				{

					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						// TODO Auto-generated method stub
						Toast.makeText(MainActivity.this,"您选择了 "+items[which],Toast.LENGTH_SHORT).show();
					}
				});
				builder.create().show();
			}
		});
		bt3=(Button) findViewById(R.id.button3);
		bt3.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				final String [] items=new String [] {"标准","无声","会议","户外","离线"};
				AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
				builder.setIcon(R.drawable.advise1);
				builder.setMessage("请选择你喜欢的情景模式");
				builder.setSingleChoiceItems(items,0,new DialogInterface.OnClickListener()
				{

					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						// TODO Auto-generated method stub
						Toast.makeText(MainActivity.this,"您选择了 "+items[which],Toast.LENGTH_SHORT).show();
					}
				});
				builder.setPositiveButton("确定",null);
				builder.create().show();
			}
		});
	}
}
