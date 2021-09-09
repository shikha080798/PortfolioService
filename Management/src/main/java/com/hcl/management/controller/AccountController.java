package com.hcl.management.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.management.exception.PortfolioNotFoundException;
import com.hcl.management.model.Account;
import com.hcl.management.service.IAccountService;
import com.hcl.management.service.IPortfolioService;

import com.hcl.management.model.Portfolio;

@RestController
public class AccountController {

	@Autowired
	IAccountService accountService;
	@Autowired
	IPortfolioService portfolioService;

	@GetMapping("user/accountDetails")
	public ResponseEntity<?> getAccountDetails(@RequestParam int userId) {
		List<Account> account = accountService.getAccountDetails(userId);
		if (account.size() != 0) {
			return new ResponseEntity<>(account, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No account details Found", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("user/portfolioDetails")
	public ResponseEntity<?> getportfolioDetails(@RequestParam Long AccountNo) throws PortfolioNotFoundException {

		List<Portfolio> portfolio = portfolioService.getportfolioDetails(AccountNo);

		if (portfolio.size() != 0) {
			return new ResponseEntity<>(portfolio, HttpStatus.OK);
		} else {

			return new ResponseEntity<>("no portfolio details found", HttpStatus.NOT_FOUND);
		}
	}
}

