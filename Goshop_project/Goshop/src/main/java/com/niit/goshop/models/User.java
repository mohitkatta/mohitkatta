package com.niit.goshop.models;
import java.lang.String;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class User {
	
	private String user_name;
	private int user_phonenumber;
	@Id
	private String user_mailid;
	private String user_address;
	private String user_password;
	@OneToOne(mappedBy="user",cascade=CascadeType.ALL)
	private Authorities authorities;
	
	public Authorities getAuthorities() {
		return authorities;
	}
	public void setAuthorities(Authorities authorities) {
		this.authorities = authorities;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getUser_phonenumber() {
		return user_phonenumber;
	}
	public void setUser_phonenumber(int user_phonenumber) {
		this.user_phonenumber = user_phonenumber;
	}
	public String getUser_mailid() {
		return user_mailid;
	}
	public void setUser_mailid(String user_mailid) {
		this.user_mailid = user_mailid;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

}
