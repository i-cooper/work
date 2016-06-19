package com.account.activity;

import java.util.Calendar;

import com.account.dao.imp.inAccountDaoImp;
import com.account.model.Tb_inaccount;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddInaccount extends Activity
{

	private final static int DATE_DIALOG_ID=0;
	private EditText txInmoney=null;
	private EditText txInTime=null;
	private Spinner txInType=null;
	private EditText txInHandler=null;
	private EditText txInMark=null;
	private Button btSave=null;
	private Button btCancel=null;
	private int mYear=0;
	private int mMonth=0;
	private int mDay=0;

	private DatePickerDialog.OnDateSetListener mDateSetListener=new DatePickerDialog.OnDateSetListener()
	{

		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth)
		{
			// TODO Auto-generated method stub
			mYear=year;
			mMonth=monthOfYear;
			mDay=dayOfMonth;
		}

	};
	//date onClick listener
	private View.OnClickListener mOnClickLister=new View.OnClickListener()
	{

		@Override
		public void onClick(View v)
		{
			// TODO Auto-generated method stub
			showDialog(DATE_DIALOG_ID);
		}

	};
	// button onClick listener
	private View.OnClickListener mButtonListener=new View.OnClickListener()
	{

		@Override
		public void onClick(View v)
		{
			// TODO Auto-generated method stub
			switch(v.getId())
			{
			case R.id.btSave:
				addInCome();
				break;
			case R.id.btCancel:
				finish();
				break;
			}
		}

	};
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addinaccount);
		txInmoney=(EditText) findViewById(R.id.txInmoney);
		txInTime=(EditText) findViewById(R.id.txInTime);
		txInHandler=(EditText) findViewById(R.id.txInHandler);
		txInType=(Spinner) findViewById(R.id.txInType);
		txInMark=(EditText) findViewById(R.id.txInMark);
		btSave=(Button) findViewById(R.id.btSave);
		btCancel=(Button) findViewById(R.id.btCancel);
		txInTime.setOnClickListener(mOnClickLister);
		mYear=Calendar.getInstance().get(Calendar.YEAR);
		mMonth=Calendar.getInstance().get(Calendar.MONTH);
		mYear=Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		updateDate();
		btSave.setOnClickListener(mButtonListener);
		btCancel.setOnClickListener(mButtonListener);
	}

	@Override
	@Deprecated
	protected Dialog onCreateDialog(int id)
	{
		// TODO Auto-generated method stub
		switch(id)
		{
		case DATE_DIALOG_ID:
			return new DatePickerDialog(this,mDateSetListener,mYear,mMonth,mDay);
		}
		return super.onCreateDialog(id);
	}
	/**
	 * update date show
	 */
	private void updateDate()
	{
		txInTime.setText(mYear+"-"+(mMonth+1)+"-"+mDay);
	}
	/**
	 * add income
	 */
	private void addInCome()
	{
		String inNum=txInmoney.getText().toString();
		inAccountDaoImp inAccount=new inAccountDaoImp(this);

		if(!"".equals(inNum))
		{
			Tb_inaccount inCome=new 
					Tb_inaccount(inAccount.getMaxId()+1,inNum,txInTime.getText().toString(),
							txInType.getSelectedItem().toString(),txInHandler.getText().toString(),
							txInMark.getText().toString());
			inAccount.add(inCome);
			clearInfo();
			Toast.makeText(this,"保存成功",Toast.LENGTH_SHORT).show();
		}
		else
		{
			Toast.makeText(this,"收入金额不能为空",Toast.LENGTH_SHORT).show();
		}
	}
	private void clearInfo()
	{
		txInmoney.setText("");
		txInTime.setText("");
		txInType.setSelection(0);
		txInHandler.setText("");
		txInMark.setText("");
	}
}
