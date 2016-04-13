package com.test.demo;


/**
 * 
 * @author Cooper
 *任意进制的转换
 */
public class Test1
{

	/**
	 * @param args
	 */
//	public static void main(String[] args)
//	{
//		// TODO Auto-generated method stub
//		System.out.println(new Test1().transfer(9,5,12));
//	}

	private String transfer(int m,int n,long number)
	{
		int mnumLength=Long.toString(number).length();
		long result=0;
		long temp;
		long power;
		int basicnumber;
		//m进制先转换为10进制
		for(int i=mnumLength-1;i>=0;i--)
		{
			power=(long) Math.pow(m,i);
			basicnumber=(int) (number/Math.pow(10,i));
			number=(long) (number%Math.pow(10,i));
			result+=power*basicnumber;
		}
		System.out.println(result);   
        
		StringBuilder sb=new StringBuilder();
		int nnumLength=Long.toString(result).length();

		//10进制转换为n进制
		for(int i=0;i<nnumLength+1;i++)
		{
			Character ch= String.valueOf((result%n)).charAt(0);
			result=result/n;
			sb.append(ch);
		}

		return sb.reverse().toString();
	}


}
