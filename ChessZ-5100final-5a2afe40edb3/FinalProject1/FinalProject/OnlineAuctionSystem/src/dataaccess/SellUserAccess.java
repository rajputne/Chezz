package dataaccess;

import java.sql.ResultSet;

public interface SellUserAccess {
	//拍卖者用户数据层接口	
	public boolean  addUser(String sql);
	public boolean  updateyUser(String sql);
	public boolean  deleteeUser(String sql);
	public ResultSet selectUser(String sql);
}
