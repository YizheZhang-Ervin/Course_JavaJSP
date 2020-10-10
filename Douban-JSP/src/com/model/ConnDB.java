package com.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnDB {

	private Connection ct=null;
	
	public Connection getConn(){
		try{
			String driver="com.mysql.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/douban";
			String user="root";
			String password="123456";
			
			Class.forName(driver);
			ct=DriverManager.getConnection(url,user,password);
			if(!ct.isClosed()){
				System.out.println("successfully connect to the DB");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return ct;
	}
	
	public static void main(String[] args) {
		ConnDB db=new ConnDB();
		db.getConn();

	}

}
