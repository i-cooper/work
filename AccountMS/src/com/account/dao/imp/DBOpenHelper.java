package com.account.dao.imp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper
{

	private static final int VERSION=1;
	private static String DBNAME="account.db";
	
	public DBOpenHelper(Context context)
	{
		super(context, DBNAME, null, VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db)
	{
		// TODO Auto-generated method stub

		db.execSQL("create table tb_outaccount (_id integer primary key,money decimal,time varchar(20)," +
				"type varchar(20),address varchar(100),mark varchar(200));");
		db.execSQL("create table tb_inaccount (_id integer primary key,money decimal,time varchar(20)," +
				"type varchar(20),handler varchar(100),mark varchar(200));");
		db.execSQL("create table tb_pwd (password varchar(100));");
		db.execSQL("create table tb_flag (_id integer primary key,flag varchar(200));");
		db.execSQL("insert into tb_pwd (password) values ('cooper')");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		// TODO Auto-generated method stub

	}

}
