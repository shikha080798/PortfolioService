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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="mail")
	private String mailId;
	
	@Column(name="phoneno")
	private Long phoneNo;
	@JoinColumn(name="userId")
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Account> account=new ArrayList<>();
	
	public List<Account> getAccount() {
		return account;
	}

	public void setAccount(List<Account> account) {
		this.account = account;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public User(int userId, String userName, String password, String mailId, Long phoneNo) {
		
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.mailId = mailId;
		this.phoneNo = phoneNo;
	}
	public User() {
		
	}
	
	
	

}
