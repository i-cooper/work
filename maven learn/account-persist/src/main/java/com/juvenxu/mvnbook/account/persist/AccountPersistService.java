package com.juvenxu.mvnbook.account.persist;

public interface AccountPersistService {

	void createAccount(Account account) throws Exception;
	Account readAccount(String id) throws Exception;
	void updateAccount(Account account) throws Exception;
	void deleteAccount(String id)throws Exception;
}
