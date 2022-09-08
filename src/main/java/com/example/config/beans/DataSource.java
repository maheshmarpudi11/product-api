package com.example.config.beans;

public class DataSource {
	
	private String username;
	private String password;
	private String dbType;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDbType() {
		return dbType;
	}
	public void setDbType(String dbType) {
		this.dbType = dbType;
	}
	
	  @Override public String toString() { return "DataSource [username=" +
	  username + ", password=" + password + ", DB-Type=" + dbType + "]"; }
	 
		
}
