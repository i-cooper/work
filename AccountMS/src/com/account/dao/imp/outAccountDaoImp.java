package com.account.dao.imp;

import java.util.ArrayList;
import java.util.List;

import com.account.dao.interfac.BaseDao;
import com.account.model.Tb_inaccount;
import com.account.model.Tb_outaccount;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class outAccountDaoImp implements BaseDao
{

	private  DBOpenHelper helper=null;
	private  SQLiteDatabase db=null;
	private Tb_outaccount outAccount=null;

	public outAccountDaoImp(Context context)
	{
		helper=new DBOpenHelper(context);
	}

	@Override
	public void add(Object obj)
	{
		// TODO Auto-generated method stub
		outAccount=(Tb_outaccount) obj;
		db=helper.getWritableDatabase();
		db.execSQL("insert into tb_outaccount (_id,money,time,type,address,mark) values (?,?,?,?,?,?)",
				new Object[]{outAccount.get_id(),outAccount.getMoney(),outAccount.getTime(),outAccount.getType()
				,outAccount.getAddress(),outAccount.getMark()});
		
		outAccount=null;
		if(db.isOpen())
		{
			db.close();
		}
	}

	@Override
	public void update(Object obj)
	{
		// TODO Auto-generated method stub
		outAccount=(Tb_outaccount) obj;
		db=helper.getWritableDatabase();
		db.execSQL("update tb_outaccount set money=?,time=?,type=?,address=?,mark=? where _id = ?",
				new Object[]{outAccount.getMoney(),outAccount.getTime(),outAccount.getType()
				,outAccount.getAddress(),outAccount.getMark(),outAccount.get_id()});
		
		outAccount=null;
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
		Cursor cursor=db.rawQuery("select * from tb_outaccount where _id= ?",new String[]{String.valueOf(id)});
		while(cursor.moveToNext())
		{
			outAccount=new Tb_outaccount(cursor.getInt(cursor.getColumnIndex("_id")),cursor.getDouble(cursor.getColumnIndex("money")),
					cursor.getString(cursor.getColumnIndex("time")),cursor.getString(cursor.getColumnIndex("type")),
					cursor.getString(cursor.getColumnIndex("address")),cursor.getString(cursor.getColumnIndex("mark")));
		}
		if(db.isOpen())
		{
			db.close();
		}
		return outAccount;
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
    	  db.execSQL("delete from tb_outaccount where _id in ( "+sb+" )",(Object [])ids);
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
		Cursor cursor=db.rawQuery("select count(_id) from tb_outaccount",null);
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
		Cursor cursor=db.rawQuery("select max(_id) from tb_outaccount",null);
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
	
	/**
	 * 获取收入信息
	 * 
	 * @param start
	 *            起始位置
	 * @param count
	 *            每页显示数量
	 * @return
	 */
	public List<Tb_outaccount> getScrollData(int start, int count) {
		List<Tb_outaccount> tb_outaccount = new ArrayList<Tb_outaccount>();// 创建集合对象
		db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
		// 获取所有收入信息
		Cursor cursor = db.rawQuery("select * from tb_outaccount limit ?,?",
				new String[] { String.valueOf(start), String.valueOf(count) });
		while (cursor.moveToNext())// 遍历所有的收入信息
		{
			// 将遍历到的收入信息添加到集合中
			tb_outaccount.add(new Tb_outaccount(cursor.getInt(cursor.getColumnIndex("_id")),cursor.getDouble(cursor.getColumnIndex("money")),
					cursor.getString(cursor.getColumnIndex("time")),cursor.getString(cursor.getColumnIndex("type")),
					cursor.getString(cursor.getColumnIndex("address")),cursor.getString(cursor.getColumnIndex("mark"))));
		}
		return tb_outaccount;// 返回集合
	}


}
