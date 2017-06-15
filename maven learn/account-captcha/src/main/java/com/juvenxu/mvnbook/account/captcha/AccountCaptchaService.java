package com.juvenxu.mvnbook.account.captcha;

import java.util.List;

public interface AccountCaptchaService {

	String generateCaptchaKey()throws Exception;
	
	byte[] generateCaptchaImage(String captchaKey)throws Exception;
	
	boolean validateCaptcha(String captchaKey,String captchaValue )throws Exception;
	
	List<String> getPreDefinedTexts();
	
	void setPreDefinedTexts(List<String> PreDefinedTexts );
}
