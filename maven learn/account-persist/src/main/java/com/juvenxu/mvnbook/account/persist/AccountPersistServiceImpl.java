package com.juvenxu.mvnbook.account.persist;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class AccountPersistServiceImpl implements AccountPersistService {

	private String file;
	private SAXReader reader=new SAXReader();
	public final static String ELEMENT_ROOT="account-persist";
	public final static String ELEMENT_ACCOUNTS="accounts";
	public final static String ELEMENT_ACCOUNT_ID="id";
	public final static String ELEMENT_ACCOUNT_NAME="name";
	public final static String ELEMENT_ACCOUNT_EMAIL="email";
	public final static String ELEMENT_ACCOUNT_PASSWORD="password";
	public final static String ELEMENT_ACCOUNT_ACTIVATED="activated";

	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	private Document readDocument() throws Exception{
		File dataFile=new File(file);

		if(!dataFile.exists())
		{
			dataFile.getParentFile().mkdirs();
			Document doc=DocumentFactory.getInstance().createDocument();
			Element rootEle=doc.addElement(ELEMENT_ROOT);
			rootEle.addElement(ELEMENT_ACCOUNTS);
			writeDocument(doc);
		}
		try{
			return reader.read(new File(file));
		}
		catch(DocumentException e)
		{
			throw new Exception("");
		}
	}
	public  void writeDocument(Document doc) throws Exception{
		Writer out=null;
		try{
			out=new OutputStreamWriter(new FileOutputStream(file),"utf-8");
			XMLWriter writer=new XMLWriter(out,OutputFormat.createPrettyPrint());
			writer.write(doc);
		}catch(IOException e){
			throw new Exception("fail to write persist.xml");
		}
		finally {
			try{
				if(out!=null)
				{
					out.close();
				}
			}
			catch(IOException e)
			{
				throw new Exception("fail to close persist.xml");
			}
		}
	}

	public void createAccount(Account account) throws Exception {
		// TODO Auto-generated method stub
		Document doc=readDocument();
		Element accountsEle=doc.getRootElement().element(ELEMENT_ACCOUNTS);
		Element accountEle=accountsEle.addElement(ELEMENT_ACCOUNT_ID);
		accountEle.addElement(ELEMENT_ACCOUNT_ID).setText(account.getId());
		accountEle.addElement(ELEMENT_ACCOUNT_NAME).setText(account.getName());
		accountEle.addElement(ELEMENT_ACCOUNT_EMAIL).setText(account.getEmail());
		accountEle.addElement(ELEMENT_ACCOUNT_PASSWORD).setText(account.getPassword());
		accountEle.addElement(ELEMENT_ACCOUNT_ACTIVATED).setText(String.valueOf(account.isActivated()));

		writeDocument(doc);
	}

	public Account readAccount(String id) throws Exception {
		Document doc=readDocument();
		Element accountsEle=doc.getRootElement().element(ELEMENT_ACCOUNTS);
		for(Element account:(List<Element>)accountsEle.elements())
		{
			if(account.elementText(ELEMENT_ACCOUNT_ID).equals(id)){
				return buildAccount(account);
			}
		}
		return null;
	}

	private Account buildAccount(Element element){

		Account account=new Account();

		account.setId(element.elementText(ELEMENT_ACCOUNT_ID));
		account.setName(element.elementText(ELEMENT_ACCOUNT_NAME));
		account.setEmail(element.elementText(ELEMENT_ACCOUNT_EMAIL));
		account.setPassword(element.elementText(ELEMENT_ACCOUNT_PASSWORD));
		account.setActivated("true".equals(element.elementText(ELEMENT_ACCOUNT_ACTIVATED)));

		return account;
	}
	public void updateAccount(Account account) throws Exception {
		String accountId=account.getId();
		Document doc=readDocument();
		Element accountsEle=doc.getRootElement().element(ELEMENT_ACCOUNTS);

		for(Element accountEle : (List<Element>)accountsEle.elements()){
			if(accountEle.elementText(ELEMENT_ACCOUNT_ID).equals(accountId)){
				accountEle.element(ELEMENT_ACCOUNT_NAME).setText(account.getName());
				accountEle.element(ELEMENT_ACCOUNT_EMAIL).setText(account.getEmail());
				accountEle.element(ELEMENT_ACCOUNT_PASSWORD).setText(account.getPassword());
				accountEle.element(ELEMENT_ACCOUNT_ACTIVATED).setText(String.valueOf(account.isActivated()));
				break;
			}

		}
		writeDocument(doc);
	}

	public void deleteAccount(String id) throws Exception {
		Document doc=readDocument();
		Element accountsEle=doc.getRootElement().element(ELEMENT_ACCOUNTS);
		for(Element accountEle : (List<Element>)accountsEle.elements()){
			if(accountEle.elementText(ELEMENT_ACCOUNT_ID).equals(id)){
				accountsEle.remove(accountEle);
				break;
			}
		}
	}

}
