package dataaccess;

import java.sql.ResultSet;


public interface BuyUserAccess {
	//�����û��Ľӿ�
	public boolean  addUser(String sql);
	public boolean  updateyUser(String sql);
	public boolean  deleteeUser(String sql);
	public ResultSet selectUser(String sql);
}
