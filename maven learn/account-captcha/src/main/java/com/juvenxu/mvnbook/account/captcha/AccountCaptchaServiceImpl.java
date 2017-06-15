package com.juvenxu.mvnbook.account.captcha;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.InitializingBean;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;

public class AccountCaptchaServiceImpl implements AccountCaptchaService, InitializingBean {

	private DefaultKaptcha producer;
	private HashMap<String,String> captchaMap=new HashMap<String,String>();
	private List<String> preDefinedTexts;
	private int textCount=0;

	public String generateCaptchaKey() throws Exception {
		// TODO Auto-generated method stub
		String key= RandomGenerator.getRandomString();
		String value=getCaptchaText();
		captchaMap.put(key, value);
		return key;
	}

	public byte[] generateCaptchaImage(String captchaKey) throws Exception {
		// TODO Auto-generated method stub
		String value=captchaMap.get(captchaKey);
		if(value==null){
			throw new Exception("captchaKey:"+captchaKey+"not fount!");
		}
		BufferedImage image=producer.createImage(value);
		ByteArrayOutputStream out=new ByteArrayOutputStream();
		try{
			ImageIO.write(image, "jpg", out);
		}
		catch(IOException e)
		{
			throw new Exception("Failed to write captca stream! ");
		}
		return out.toByteArray();
	}

	public boolean validateCaptcha(String captchaKey, String captchaValue) throws Exception {
		// TODO Auto-generated method stub
		String text=captchaMap.get(captchaKey);
		if(text==null){
			throw new Exception("captchaKey:"+captchaKey+"not fount!");
		}
		if(text.equals(captchaValue)){
			captchaMap.remove(captchaKey);
			return true;
		}
		return false;
	}

	public List<String> getPreDefinedTexts() {
		// TODO Auto-generated method stub
		return preDefinedTexts;
	}

	public void setPreDefinedTexts(List<String> PreDefinedTexts) {
		// TODO Auto-generated method stub
		this.preDefinedTexts=preDefinedTexts;
	}

	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		producer=new DefaultKaptcha();
		producer.setConfig(new Config(new Properties()));
	}

	private String getCaptchaText(){
		if(preDefinedTexts!=null && !preDefinedTexts.isEmpty()){
			String text=preDefinedTexts.get(textCount);
			textCount=(textCount+1)%preDefinedTexts.size();
			return text;
		}
		else{
			return producer.createText();
		}

	}
}
