package com.account.model;

public class Tb_inaccount
{
	private int _id;//���
	private String money;//������
	private String time;//����ʱ��
	private String type;//��������
	private String handler;//���
	private String mark;//��ע

	public Tb_inaccount()
	{
		
	}
	public Tb_inaccount(int _id,String money,String time,String type,String handler,String mark)
	{
		this._id=_id;
		this.money=money;
		this.time=time;
		this.type=type;
		this.handler=handler;
		this.mark=mark;
	}

	public int get_id()
	{
		return _id;
	}
	public void set_id(int _id)
	{
		this._id = _id;
	}
	public String getMoney()
	{
		return money;
	}
	public void setMoney(String money)
	{
		this.money = money;
	}
	public String getTime()
	{
		return time;
	}
	public void setTime(String time)
	{
		this.time = time;
	}
	public String getType()
	{
		return type;
	}
	public void setType(String type)
	{
		this.type = type;
	}
	public String getHandler()
	{
		return handler;
	}
	public void setHandler(String handler)
	{
		this.handler = handler;
	}
	public String getMark()
	{
		return mark;
	}
	public void setMark(String mark)
	{
		this.mark = mark;
	}
}
