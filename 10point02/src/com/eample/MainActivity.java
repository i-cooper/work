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
				alert.setTitle("ϵͳ��ʾ��");
				alert.setMessage("��ȡ����������ȷ���ĶԻ���");
				alert.setButton(DialogInterface.BUTTON_POSITIVE,"ȷ��",new DialogInterface.OnClickListener()
				{

					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						// TODO Auto-generated method stub
						Toast.makeText(MainActivity.this,"������ȷ����ť",Toast.LENGTH_SHORT).show();
					}

				}
						);

				alert.setButton(DialogInterface.BUTTON_NEUTRAL,"����",new DialogInterface.OnClickListener()
				{

					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						// TODO Auto-generated method stub
						Toast.makeText(MainActivity.this,"������������ť",Toast.LENGTH_SHORT).show();
					}
				});
				alert.setButton(DialogInterface.BUTTON_NEGATIVE,"ȡ��",new DialogInterface.OnClickListener()
				{

					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						// TODO Auto-generated method stub
						Toast.makeText(MainActivity.this,"������ȡ����ť",Toast.LENGTH_SHORT).show();
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
				final String items[]=new String[]{"�ܲ�","��ë��","ƹ����","����","���"};
				// TODO Auto-generated method stub
				AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
				builder.setIcon(R.drawable.advise1);
				builder.setMessage("��ѡ����ϲ�����˶���Ŀ");
				builder.setItems(items,new DialogInterface.OnClickListener()
				{

					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						// TODO Auto-generated method stub
						Toast.makeText(MainActivity.this,"��ѡ���� "+items[which],Toast.LENGTH_SHORT).show();
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
				final String [] items=new String [] {"��׼","����","����","����","����"};
				AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
				builder.setIcon(R.drawable.advise1);
				builder.setMessage("��ѡ����ϲ�����龰ģʽ");
				builder.setSingleChoiceItems(items,0,new DialogInterface.OnClickListener()
				{

					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						// TODO Auto-generated method stub
						Toast.makeText(MainActivity.this,"��ѡ���� "+items[which],Toast.LENGTH_SHORT).show();
					}
				});
				builder.setPositiveButton("ȷ��",null);
				builder.create().show();
			}
		});
	}
}
