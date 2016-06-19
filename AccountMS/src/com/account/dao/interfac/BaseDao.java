package com.account.dao.interfac;


public interface BaseDao
{
	/**
	 * ���ݿ����һ����¼
	 * @param obj
	 */
	public void add(Object obj);
	/**
	 * ���ݿ����obj��¼
	 * @param obj
	 */
	public void update(Object obj);
	/**
	 * ��ȡ���Ϊid�ļ�¼
	 * @param id
	 * ���ؼ�¼bean
	 * @return
	 */
	public Object find(int id);
	/**
	 * ɾ��������¼
	 * @param ids
	 */
	public void delete(Integer ... ids);
	/**
	 * ��ȡ���ݿ��м�¼����
	 * @return
	 */
	public long getCount();
	/**
	 * ��ȡidֵ���ļ�¼���
	 * @return
	 */
	public int getMaxId();

}
