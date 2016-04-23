package com.test;

import junit.framework.TestCase;

public class CalculatorTest extends TestCase
{
	public void testFail()
	{
		fail("fail");
		
	}
	
	public void testAdd()
	{
		Calculator cal =new Calculator();
		double result=cal.add(50,60);
		assertEquals(110,result,0);
	}
	
//	public static Test suite()
//	{
//		
//	}
	
	public static void main(String[] args)
	{
		new CalculatorTest().testAdd();
	
	}
}
