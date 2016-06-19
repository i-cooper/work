package com.account.dao.imp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.account.dao.interfac.BaseDao;
import com.account.model.Tb_pwd;

public class pwdDaoImp implements BaseDao
{

	private  DBOpenHelper helper=null;
	private  SQLiteDatabase db=null;
private Tb_pwd pwd=null;
	
	public pwdDaoImp(Context context)
	{
		helper=new DBOpenHelper(context);
		pwd=new Tb_pwd();
	}

	@Override
	public void add(Object obj)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Object obj)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public Object find(int id)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer... ids)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public long getCount()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxId()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	public Tb_pwd find()
	{
		db=helper.getWritableDatabase();
		String password="";
		Cursor cursor=db.rawQuery("select * from tb_pwd",null);
		if(cursor.moveToNext())
		{
			password= cursor.getString(cursor.getColumnIndex("password"));
		}
		if(db.isOpen())
		{
			db.close();
		}
		pwd.setPassword(password);
		return pwd;
	}
}
