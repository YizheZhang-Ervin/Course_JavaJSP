package com.model;

import java.sql.*;
import java.util.ArrayList;


public class UserBeanBo {

	private ResultSet rs=null;
	private Statement sql=null;
	private Connection ct=null;
	public boolean checkUser(String user,String passwd) throws SQLException{
		boolean flag=false;
		try{
			ct=new ConnDB().getConn();
			sql=ct.createStatement();
			rs=sql.executeQuery("select * from users where name='"+user+"' limit 1");
			if(rs.next()){
				String dbPasswd=rs.getString("password");
				if(dbPasswd.equals(passwd)){
					flag=true;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//�رղ���
			this.close();
		}
		return flag;
	}
	public int getPageCount(int pageSize){
		int pageCount=0;
		int rowCount=0;
		try{
			ct=new ConnDB().getConn();
			sql=ct.createStatement();
			rs=sql.executeQuery("select count(*) from users ");
			if(rs.next()){
				rowCount=rs.getInt(1);
			}
			if(rowCount%pageSize==0){
				pageCount=rowCount/pageSize;
			}else{
				pageCount=rowCount/pageSize+1;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.close();
		}
		return pageCount;
	}
	
	public ArrayList getUsersByPage(int pageSize,int pageNow){
		ArrayList al=new ArrayList();
		try{
			ct=new ConnDB().getConn();
			sql=ct.createStatement();
			rs=sql.executeQuery("select * from users limit "+pageSize*(pageNow-1)+","+pageSize+";");
			while(rs.next()){
				UserBean ub=new UserBean();
				ub.setUserid(rs.getInt("id"));
				ub.setUsername(rs.getString("name"));
				ub.setPasswd(rs.getString("password"));
				ub.setEmail(rs.getString("email"));
				al.add(ub);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{this.close();
		}
		return al;
	}
	
	
	public void DeleteUser(int id){
		try{
			String m="delete from users where id="+id;
			ct=new ConnDB().getConn();
			sql=ct.createStatement();
			sql.executeUpdate(m);
		}catch(Exception e){
			e.printStackTrace();
			}finally{
				this.close();
			}
		}

	public void AddUsers(){
		try{
			ct=new ConnDB().getConn();
			sql=ct.createStatement();
			sql.executeUpdate("insert into users(name,password,email) values('null','null','null')");
		}catch(Exception e){
			e.printStackTrace();
			}finally{
				this.close();
			}
	}
	
	public void UpdateUser(int id){
		try{
			String m="update users set name='unknown',password='unknown',email='unknown' where id="+id;
			ct=new ConnDB().getConn();
			sql=ct.createStatement();
			sql.executeUpdate(m);
		}catch(Exception e){
			e.printStackTrace();
			}finally{
				this.close();
			}
		}
	
	
	public void close(){
		if(rs!=null){
			try{rs.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		if(ct!=null){
			try {
				ct.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		if(sql!=null){
			try {
				sql.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
}
