package dataaccess;

import java.sql.ResultSet;


public interface BuyUserAccess {
	//买者用户的接口
	public boolean  addUser(String sql);
	public boolean  updateyUser(String sql);
	public boolean  deleteeUser(String sql);
	public ResultSet selectUser(String sql);
}
