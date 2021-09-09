package com.hcl.management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.management.model.Account;
import com.hcl.management.repository.AccountRepository;
import com.hcl.management.service.IAccountService;


@Service
public class AccountServiceImpl implements IAccountService {
	@Autowired
	AccountRepository accountRepository;
	@Override
	public List<Account> getAccountDetails(int userId) {
		List<Account> account=accountRepository.getAccountDetails(userId);
		return account;
		// TODO Auto-generated method stub
		
	}
	
}
