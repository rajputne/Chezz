package dataaccess.impl;

import dataaccess.LeaveWordAccess;
import dataaccess.SqlConnection;

public class LeaveWordAccessImpl implements LeaveWordAccess {

	SqlConnection consql=new SqlConnection();
	public boolean addLeaveWord(String sql) {
		// TODO Auto-generated method stub
		return this.consql.conupdate(sql);
	}

}
