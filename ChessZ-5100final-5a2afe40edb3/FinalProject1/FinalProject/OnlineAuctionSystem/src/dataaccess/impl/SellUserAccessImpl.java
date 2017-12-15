package dataaccess.impl;

import java.sql.ResultSet;

import dataaccess.SellUserAccess;
import dataaccess.SqlConnection;

public class SellUserAccessImpl implements SellUserAccess {

	SqlConnection consql=new SqlConnection();
	public boolean addUser(String sql) {
		// TODO Auto-generated method stub
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
