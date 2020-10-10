package com.model;

public class UserBean {

	private int userid;
	private String passwd;
	private String username;
	private String email;
	
	public String getUsername(){
		return username;
	}
	
	public void setUsername(String username){
		this.username=username;
		
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
