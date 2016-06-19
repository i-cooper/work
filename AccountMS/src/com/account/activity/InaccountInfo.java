package com.account.activity;

import java.util.List;

import com.account.dao.imp.inAccountDaoImp;
import com.account.model.Tb_inaccount;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class InaccountInfo extends Activity
{

	private final static String TAG="InaccountInfo";
	public final static String FLAG="id";
	private String strType="";
	private ListView lv=null;
	private OnItemClickListener itemOnClick=new OnItemClickListener()
	{

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id)
		{
			// TODO Auto-generated method stub
			String inInfo=String.valueOf(((TextView)view).getText());
			String strId=inInfo.substring(0,inInfo.indexOf("|"));
			Intent intent=new Intent(InaccountInfo.this,InfoManage.class);
			intent.putExtra(FLAG,new String[]{strId,strType});
			startActivity(intent);
		}
		
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inaccountinfo);
		strType="btnininfo";
		lv=(ListView) findViewById(R.id.lvInaccountInfo);
		lv.setOnItemClickListener(itemOnClick);
		showInfo();
	}
	private void showInfo()
	{  
		
		ArrayAdapter<String> arrayAdapter=null;
		inAccountDaoImp inAccount=new inAccountDaoImp(this);
		List<Tb_inaccount> list=inAccount.getScrollData(0,(int)inAccount.getCount());
		String strInfo[]=new String[list.size()];
		Log.i(TAG,"showInfo size is "+list.size());
		for(int i=0;i<list.size();i++)
		{
			Tb_inaccount tmp=list.get(i);
			Log.i(TAG,"Tb_inaccount object "+tmp);
			
			strInfo[i]=new String(tmp.get_id()+"|"+tmp.getType()+" "+tmp.getMoney()+"Ԫ "+tmp.getTime());
		}
		arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,strInfo);
		lv.setAdapter(arrayAdapter);
	}

}
