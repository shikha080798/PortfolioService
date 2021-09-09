package com.hcl.management.service;

import java.util.List;

import com.hcl.management.model.Account;

public interface IAccountService {

	public List<Account> getAccountDetails(int userId);

	

	//Object findByAccountId(int accountId);

}
