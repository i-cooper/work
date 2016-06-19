package com.account.dao.imp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.account.dao.interfac.BaseDao;
import com.account.model.Tb_flag;
import com.account.model.Tb_outaccount;

public class flagAccountdaoImp implements BaseDao
{

	private  DBOpenHelper helper=null;
	private  SQLiteDatabase db=null;
	private Tb_flag flagAccount=null;

	public flagAccountdaoImp(Context context)
	{
		helper=new DBOpenHelper(context);
	}

	@Override
	public void add(Object obj)
	{
		// TODO Auto-generated method stub
		flagAccount=(Tb_flag) obj;
		db=helper.getWritableDatabase();
		db.execSQL("insert into tb_flag (_id,flag) values (?,?)",
				new Object[]{flagAccount.get_id(),flagAccount.getFlag()});
		flagAccount=null;
		if(db.isOpen())
		{
			db.close();
		}
	}

	@Override
	public void update(Object obj)
	{
		// TODO Auto-generated method stub
		flagAccount=(Tb_flag) obj;
		db=helper.getWritableDatabase();
		db.execSQL("update tb_flag set flag=?,where _id = ?",
				new Object[]{ flagAccount.getFlag(),flagAccount.get_id()});
		flagAccount=null;
		if(db.isOpen())
		{
			db.close();
		}
	}

	@Override
	public Object find(int id)
	{
		// TODO Auto-generated method stub
		db=helper.getWritableDatabase();
		Cursor cursor=db.rawQuery("select * from tb_flag where _id= ?",new String[]{String.valueOf(id)});
		while(cursor.moveToNext())
		{
			flagAccount=new Tb_flag(cursor.getInt(cursor.getColumnIndex("_id")),cursor.getString(cursor.getColumnIndex("flag")));
		}
		if(db.isOpen())
		{
			db.close();
		}
		return flagAccount;
	}

	@Override
	public void delete(Integer... ids)
	{
		// TODO Auto-generated method stub
		if(ids.length>0)
		{
			StringBuffer sb=new StringBuffer();
			for(int i=0;i<ids.length;i++)
			{
				sb.append('?').append(',');
			}
			sb.deleteCharAt(sb.length()-1);
			db=helper.getWritableDatabase();
			db.execSQL("delete from tb_flag where _id in ( "+sb+" )",(Object [])ids);
		}
		if(db.isOpen())
		{
			db.close();
		}
	}

	@Override
	public long getCount()
	{
		// TODO Auto-generated method stub
		db=helper.getWritableDatabase();
		long count=0;
		Cursor cursor=db.rawQuery("select count(_id) from tb_flag",null);
		if(cursor.moveToNext())
		{
			count= cursor.getLong(0);
		}
		if(db.isOpen())
		{
			db.close();
		}
		return count;
	}

	@Override
	public int getMaxId()
	{
		// TODO Auto-generated method stub
		db=helper.getWritableDatabase();
		int count=0;
		Cursor cursor=db.rawQuery("select max(_id) from tb_flag",null);
		if(cursor.moveToLast())
		{
			count= cursor.getInt(0);
		}
		if(db.isOpen())
		{
			db.isOpen();
		}
		return count;
	}
	
	public static void main(String[] args)
	{
		
	}

}
