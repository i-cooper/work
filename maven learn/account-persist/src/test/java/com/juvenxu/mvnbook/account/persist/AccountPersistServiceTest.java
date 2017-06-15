package com.juvenxu.mvnbook.account.persist;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountPersistServiceTest {

	private AccountPersistService service;
	
	@Before
	public void prepare()throws Exception{
		File persistDataFile=new File("target/test-classes/persist-data.xml");
		if(persistDataFile.exists())
		{
			persistDataFile.delete();
		}
		ApplicationContext ctx=new ClassPathXmlApplicationContext("account-persist.xml");
		service=(AccountPersistService) ctx.getBean("accountPersistService");
		Account account=new Account();
		account.setId("juven");
		account.setName("Lee");
		account.setEmail("backthe@162.com");
		account.setPassword("thisispassword");
		account.setActivated(true);
		
		service.createAccount(account);
	}
	
	@Test
	public void testReadAccount()throws Exception{
		Account account=service.readAccount("juven");
		
		assertNotNull(account);
		assertEquals("juven",account.getId());
		assertEquals("Lee",account.getName());
		assertEquals("backthe@162.com",account.getEmail());
		assertEquals("thisispassword",account.getPassword());
		assertTrue(account.isActivated());
	}
}
