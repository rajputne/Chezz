package dataaccess;

import java.sql.ResultSet;

public interface SellUserAccess {
	//�������û����ݲ�ӿ�	
	public boolean  addUser(String sql);
	public boolean  updateyUser(String sql);
	public boolean  deleteeUser(String sql);
	public ResultSet selectUser(String sql);
}
