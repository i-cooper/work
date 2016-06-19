package com.account.activity;

import java.util.Calendar;

import com.account.dao.imp.inAccountDaoImp;
import com.account.dao.imp.outAccountDaoImp;
import com.account.model.Tb_inaccount;
import com.account.model.Tb_outaccount;

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

public class AddOutaccount extends Activity
{

	private final static int DATE_DIALOG_ID=0;
	private EditText txOutmoney=null;
	private EditText txOutTime=null;
	private Spinner txOutType=null;
	private EditText txAddress=null;
	private EditText txOutMark=null;
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
				addOutgoing();
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
		// TODO Auto-generated method stub
				super.onCreate(savedInstanceState);
				setContentView(R.layout.addoutaccount);
				txOutmoney=(EditText) findViewById(R.id.txOutmoney);
				txOutTime=(EditText) findViewById(R.id.txOutTime);
				txAddress=(EditText) findViewById(R.id.txAddress);
				txOutType=(Spinner) findViewById(R.id.txOutType);
				txOutMark=(EditText) findViewById(R.id.txOutMark);
				btSave=(Button) findViewById(R.id.btSave);
				btCancel=(Button) findViewById(R.id.btCancel);
				txOutTime.setOnClickListener(mOnClickLister);
				mYear=Calendar.getInstance().get(Calendar.YEAR);
				mMonth=Calendar.getInstance().get(Calendar.MONTH);
				mYear=Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
				updateDate();
				btSave.setOnClickListener(mButtonListener);
				btCancel.setOnClickListener(mButtonListener);
	}

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
		txOutTime.setText(mYear+"-"+(mMonth+1)+"-"+mDay);
	}

	
	
	private void addOutgoing()
	{
		String inNum=txOutmoney.getText().toString();
		outAccountDaoImp outAccount=new outAccountDaoImp(this);

		if(!"".equals(inNum))
		{
			Tb_outaccount outCome=new 
					Tb_outaccount(outAccount.getMaxId()+1,Double.parseDouble(inNum),txOutTime.getText().toString(),
							txOutType.getSelectedItem().toString(),txAddress.getText().toString(),
							txOutMark.getText().toString());
			outAccount.add(outCome);
			clearInfo();
			Toast.makeText(this,"保存成功",Toast.LENGTH_SHORT).show();
		}
		else
		{
			Toast.makeText(this,"支出金额不能为空",Toast.LENGTH_SHORT).show();
		}
	}
	private void clearInfo()
	{
		txOutmoney.setText("");
		txOutTime.setText("");
		txOutType.setSelection(0);
		txAddress.setText("");
		txOutMark.setText("");
	}
}
