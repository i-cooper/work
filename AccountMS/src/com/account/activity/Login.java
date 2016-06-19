package com.account.activity;

import com.account.dao.imp.pwdDaoImp;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity implements OnClickListener
{

	private final static String TAG="Login";
	private Button btLogin=null;
	private Button btQuit=null;
	private EditText editV=null;
	private Intent intent=null;		
	private pwdDaoImp pwd=null;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		btLogin=(Button) findViewById(R.id.btLogin);
		btQuit=(Button) findViewById(R.id.btQuit);
		editV=(EditText) findViewById(R.id.txtLogin);
		btLogin.setOnClickListener(this);
		btQuit.setOnClickListener(this);
	}

	@Override
	public void onClick(View v)
	{
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.btLogin:
			login();
			break; 
		case R.id.btQuit:
			finish();
			break;
		default:
			break;
		}
	}

	private void login()
	{
		intent=new Intent();
		intent.setClass(this,MainActivity.class);
		pwd=new pwdDaoImp(this);
		if((!("".equals(editV.getText().toString())))&&pwd.find().getPassword().equals(editV.getText().toString()))
		{
			Log.i(TAG,"login()------,start activity");
			startActivity(intent);
		}
		else
		{
			editV.setText("");
			Toast.makeText(this,"请输入正确的密码！",Toast.LENGTH_SHORT).show();
		}
	}
}
