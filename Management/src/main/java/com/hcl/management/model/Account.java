package com.hcl.management.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="account")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int accountId;
	
	@Column(name="account_no")
	private Long AccountNo;
	
	@Column(name="account_type")
	private String accountType;
	
	@Column(name="balance")
	private double balance;
	
	@JoinColumn(name="AccountNo")
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Portfolio> portfolio=new ArrayList<>();
	

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public Long getAccountNo() {
		return AccountNo;
	}

	public void setAccountNo(Long accountNo) {
		AccountNo = accountNo;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
//	@ManyToOne
//	private User user;

}
