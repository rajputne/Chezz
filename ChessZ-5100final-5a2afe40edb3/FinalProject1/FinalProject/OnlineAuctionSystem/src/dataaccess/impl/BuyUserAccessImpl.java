package dataaccess.impl;

import java.sql.ResultSet;

import dataaccess.BuyUserAccess;
import dataaccess.SqlConnection;

public class BuyUserAccessImpl implements BuyUserAccess {
	SqlConnection consql=new SqlConnection();

	public boolean addUser(String sql) {
		return this.consql.conupdate(sql);
	}

	public boolean updateyUser(String sql) {
		// TODO Auto-generated method stub
		return this.consql.conupdate(sql);
	}

	public boolean deleteeUser(String sql) {
		// TODO Auto-generated method stub
		return this.consql.conupdate(sql);
	}

	public ResultSet selectUser(String sql) {
		// TODO Auto-generated method stub
		ResultSet rs=this.consql.lookfor(sql);
		return rs;
	}



}
