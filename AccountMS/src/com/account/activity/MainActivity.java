package com.account.activity;

import java.util.ArrayList;
import java.util.List;

import com.account.griview.Picture;
import com.account.griview.ViewHolder;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnItemClickListener
{

	private final static String TAG="MainActivity";
	private GridView gvView=null; 
	private String [] titles=new String[]{"新增支出","新增收入","我的支出","我的收入","数据管理","系统设置","收支便签","退出"};
	private int [] images=new int [] {R.drawable.addoutaccount,R.drawable.addinaccount,R.drawable.outaccountinfo
			,R.drawable.inaccountinfo,R.drawable.showinfo,R.drawable.sysset,R.drawable.accountflag
			,R.drawable.exit};
	private PicturesAdapter adapter=null;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.activity_main);
		Log.i(TAG,"MainActivity onCreate()-----");
		gvView =(GridView) findViewById(R.id.gvInfo);
		gvView.setOnItemClickListener(this);
		adapter=new PicturesAdapter(titles,images,this);
		gvView.setAdapter(adapter);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id)
	{
		// TODO Auto-generated method stub
		Intent intent=null;
		switch(position)
		{
		case 0:
			intent=new Intent(this,AddOutaccount.class);
			startActivity(intent);
			break;
		case 1:
			intent=new Intent(this,AddInaccount.class);
			startActivity(intent);
			break;
		case 2:
			intent=new Intent(this,OutaccountInfo.class);
			startActivity(intent);
			break; 
		case 3:
			intent=new Intent(this,InaccountInfo.class);
			startActivity(intent);
			break;
		case 4:
			intent=new Intent(this,ShowInfo.class);
			startActivity(intent);
			break;
		case 5:
			intent=new Intent(this,Setting.class);
			startActivity(intent);
			break;
		case 6:
			intent=new Intent(this,AccountFlag.class);
			startActivity(intent);
			break;
		case 7:
			android.os.Process.killProcess(android.os.Process.myPid());   //获取PID 
			System.exit(0);
			break;
		}

	}

	class PicturesAdapter extends BaseAdapter
	{

		private LayoutInflater inflater;
		private List<Picture> pictures;

		public PicturesAdapter(String [] titles,int []imageIds,Context context)
		{
			super();
			pictures=new ArrayList<Picture>();
			inflater=LayoutInflater.from(context);
			for(int i=0;i<imageIds.length;i++)
			{
				Picture picture=new Picture(titles[i],imageIds[i]);
				pictures.add(picture);
			}
		}

		@Override
		public int getCount()
		{
			// TODO Auto-generated method stub
			if(pictures!=null)
			{
				return pictures.size();
			}
			return 0;
		}

		@Override
		public Object getItem(int position)
		{
			// TODO Auto-generated method stub
			if(pictures!=null)
			{
				return pictures.get(position);
			}
			return null;
		}

		@Override
		public long getItemId(int position)
		{
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent)
		{
			// TODO Auto-generated method stub
			ViewHolder viewHolder;
			if(convertView==null)
			{
				convertView=inflater.inflate(R.layout.gvitem,null);
				viewHolder=new ViewHolder();
				viewHolder.title=(TextView) convertView.findViewById(R.id.itemTitle);
				viewHolder.image=(ImageView) convertView.findViewById(R.id.itemImage);
				convertView.setTag(viewHolder);
			}
			else
			{
				viewHolder=(ViewHolder) convertView.getTag();
			}
			viewHolder.title.setText(pictures.get(position).getTitle());
			viewHolder.image.setImageResource(pictures.get(position).getImageId());
			return convertView;
		}

	}


}
