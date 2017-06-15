package com.juvenxu.mvnbook.account.captcha;

import java.util.Random;

public class RandomGenerator {

	private static String range="0123456789abcdefghijklmnopqrstuvwxyz";

	public static synchronized String getRandomString(){
		Random random=new Random();
		StringBuffer sb=new StringBuffer();

		for(int i=0;i<8;i++){
			char temp=range.charAt(random.nextInt(range.length()));
			sb.append(temp);
		}
		return sb.toString();
	}
}
