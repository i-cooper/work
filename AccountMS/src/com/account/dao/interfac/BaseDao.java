package com.account.dao.interfac;


public interface BaseDao
{
	/**
	 * 数据库添加一条记录
	 * @param obj
	 */
	public void add(Object obj);
	/**
	 * 数据库更新obj记录
	 * @param obj
	 */
	public void update(Object obj);
	/**
	 * 获取编号为id的记录
	 * @param id
	 * 返回记录bean
	 * @return
	 */
	public Object find(int id);
	/**
	 * 删除多条记录
	 * @param ids
	 */
	public void delete(Integer ... ids);
	/**
	 * 获取数据库中记录总数
	 * @return
	 */
	public long getCount();
	/**
	 * 获取id值最大的记录编号
	 * @return
	 */
	public int getMaxId();

}
