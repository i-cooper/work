package com.account.activity;

import java.util.Calendar;

import com.account.dao.imp.inAccountDaoImp;
import com.account.dao.imp.outAccountDaoImp;
import com.account.model.Tb_inaccount;
import com.account.model.Tb_outaccount;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class InfoManage extends Activity
{
	private final static String TAG="InfoManage";
	private final static int DATE_DIALOG_ID=0;
	private EditText txInmoney=null;
	private EditText txInTime=null;
	private Spinner txInType=null;
	private EditText txInHandler=null;
	private EditText txInMark=null;
	private TextView tvTitle=null;
	private TextView tvInHandler=null;
	private Button btUpdate=null;
	private Button btRemove=null;
 
	
	public final static String FLAG="id";
	private String strType="";
	private String strId="";
	private Intent intent=null;
	private String strInfo[]=null;
	
	private inAccountDaoImp inDao=new inAccountDaoImp(InfoManage.this);
	private outAccountDaoImp outDao=new outAccountDaoImp(InfoManage.this);
	
	
	private OnClickListener mOnClickListener=new OnClickListener()
	{

		@Override
		public void onClick(View v)
		{
			// TODO Auto-generated method stub
			switch(v.getId())
			{
			case R.id.btUpdate:
				updateInfo();
				break;
			case R.id.btRemove:
				removeInfo();
				break;
			
			}
		}};
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.infomanage);
		tvTitle=(TextView) findViewById(R.id.tvTitle);
		tvInHandler=(TextView) findViewById(R.id.tvInHandler);
		txInmoney=(EditText) findViewById(R.id.txInmoney);
		txInTime=(EditText) findViewById(R.id.txInTime);
		txInHandler=(EditText) findViewById(R.id.txInHandler);
		txInType=(Spinner) findViewById(R.id.txInType);
		txInMark=(EditText) findViewById(R.id.txInMark);
		btUpdate=(Button) findViewById(R.id.btUpdate);
		btRemove=(Button) findViewById(R.id.btRemove);
//		txInTime.setOnClickListener(mOnClickLister);
//		mYear=Calendar.getInstance().get(Calendar.YEAR);
//		mMonth=Calendar.getInstance().get(Calendar.MONTH);
//		mYear=Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
//		updateDate();
		btUpdate.setOnClickListener(mOnClickListener);
		btRemove.setOnClickListener(mOnClickListener);
		intent=getIntent();
		showInfo(intent);
		
	}
	
	public void showInfo(Intent intent)
	{
		strInfo=intent.getExtras().getStringArray(ShowInfo.FLAG);
		strId=strInfo[0];
		strType=strInfo[1];
		
		Log.i(TAG,"strId:"+strId);
		Log.i(TAG,"strType:"+strType);
		
		if("btnininfo".equals(strType))
		{
			Tb_inaccount tb_inAccount=(Tb_inaccount) inDao.find(Integer.parseInt(strId));
			
			setTb_inaccountObject(tb_inAccount);
		}
		else if("btnoutinfo".equals(strType))
		{
			Tb_outaccount tb_outAccount=(Tb_outaccount) outDao.find(Integer.parseInt(strId));
			setTb_outaccountObject(tb_outAccount);
		}
	}
	
	public void setTb_inaccountObject(Tb_inaccount obj)
	{
		tvTitle.setText("收入管理");
		tvInHandler.setText("付款方：");
		txInmoney.setText(obj.getMoney());
		txInTime.setText(obj.getTime());
		txInHandler.setText(obj.getHandler());
		txInType.setPrompt(obj.getType());
		txInMark.setText(obj.getMark());
	}
	
	public void setTb_outaccountObject(Tb_outaccount obj)
	{
		tvTitle.setText("支出管理");
		tvInHandler.setText("地 点：");
		tvInHandler.setTextSize(25);
		txInmoney.setText(String.valueOf(obj.getMoney()));
		txInTime.setText(obj.getTime());
		txInHandler.setText(obj.getAddress());
		txInType.setPrompt(obj.getType());
		txInMark.setText(obj.getMark());
	}
	//删除信息记录
	private void removeInfo()
	{
		if("btnininfo".equals(strType))
		{
			inDao.delete(Integer.parseInt(strId));
		}
		else if("btnoutinfo".equals(strType))
		{
			outDao.delete(Integer.parseInt(strId));
		}
		Toast.makeText(this,"删除信息成功",Toast.LENGTH_SHORT).show();
//		clearInfo();
		finish();
	}
	
	private void updateInfo()
	{
		if("btnininfo".equals(strType))
		{
			Tb_inaccount tbIn=new Tb_inaccount();
			tbIn.set_id(Integer.parseInt(strId));
			tbIn.setHandler(txInHandler.getText().toString());
			tbIn.setMoney(txInmoney.getText().toString());
			tbIn.setTime(txInTime.getText().toString());
			tbIn.setType(txInType.getSelectedItem().toString());
			tbIn.setMark(txInMark.getText().toString());
			inDao.update(tbIn);
		}
		else if("btnoutinfo".equals(strType))
		{
			Tb_outaccount tbOut=new Tb_outaccount();
			tbOut.set_id(Integer.parseInt(strId));
			tbOut.setAddress(txInHandler.getText().toString());
			tbOut.setMoney(Double.parseDouble(txInmoney.getText().toString()));
			tbOut.setTime(txInTime.getText().toString());
			tbOut.setType(txInType.getSelectedItem().toString());
			tbOut.setMark(txInMark.getText().toString());
			outDao.update(tbOut);
		}
		Toast.makeText(this,"修改信息成功",Toast.LENGTH_SHORT).show();
//		clearInfo();
		finish();
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
